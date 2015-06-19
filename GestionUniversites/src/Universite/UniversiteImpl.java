package Universite;

import java.util.ArrayList;
import java.util.Calendar;

import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.Licence;
import Etudes.Master;
import Etudes.Proposition;
import Etudes.PropositionDoesNotExist;
import Etudes.PropositionDoesNotExistException;
import Etudes.Rectorat;
import Etudes.RectoratHelper;
import Etudes.UniversitePOA;
import Etudes.formationDejaProposeeException;
import Etudes.pasDiplomeException;
import Util.UtilConnexion;
import Util.UtilTraitements;

public class UniversiteImpl extends UniversitePOA {
	
	private String nom;
	
	private Rectorat rectoratDappartenance;
	
	private ArrayList<EtudiantImpl> etudiants;
	
	private ArrayList<PropositionImpl> listeDesPropositions; 
	
	public static void main(String[] args) {
		new UniversiteImpl(args[0], args[1]);
		
	}
	
	public UniversiteImpl(String _nomUniversite, String _nomRectoratReference)
	{
		super();
		this.nom = _nomUniversite;
		this.etudiants = new ArrayList<EtudiantImpl>();
		this.listeDesPropositions = new ArrayList<PropositionImpl>();
		
		// Intialisation de l'orb
		UtilConnexion.connexionAuNammingService(this, "Universite_" + this.nom);
		
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Rectorat_" + _nomRectoratReference);
		this.rectoratDappartenance = RectoratHelper.narrow(result);
		
		this.rectoratDappartenance.referencer(this._this());
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Universite_" + this.nom + " r�f�renc� et op�rationnel.");
		
		UtilConnexion.runORB();
		
		new EtudiantImpl("012345", new ResultatImpl(), this);
	}


	@Override
	public Proposition[] listeDesPropositions() {
		return (Proposition[]) UtilTraitements.ToTableau(listeDesPropositions);
	}

	@Override
	public void listeDesPropositions(Proposition[] value) {
		this.listeDesPropositions = (ArrayList<PropositionImpl>) UtilTraitements.ToArray(value);
	}
	
	/**
	 * Cette m�thode retourne la liste des �tudiants qui ont �tudi� au sein de cette universit�
	 * 
	 * @return Etudiant[] Un tableau des �tudiants
	 * @author Gaetan
	 */
	@Override
	public Etudiant[] getEtudiants() {
		return this.etudiants.toArray(new Etudiant[this.etudiants.size()]);
	}

	/**
	 * Cette m�thode l'�tudiant correspondant au num�ro demand�. Si aucun n'�tudiant de cette universit� ne porte ce num�ro, retourne null
	 * 
	 * @param String numEtudiant La num�ro de l'�tudiant recherch�
	 * @return Etudiant L'�tudiant recherch� si il appartient � cette universit�, null sinon
	 * @author Gaetan
	 */
	@Override
	public Etudiant getEtudiantByNumero(String numEtudiant) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : Universite_" + this.nom + ".getEtudiantByNumero(" + numEtudiant + ")");
		
		Etudiant result = null;
		
		for (EtudiantImpl e : this.etudiants)
		{
			if (e.numEtudiant().equals(numEtudiant))
			{
				result = e._this();
				break;
			}
		}
		
		return result;
	}

	/**
	 * Cette m�thode inscrit un �tudiant en lui attribuant le mot de passe pass� en param�tre
	 * 
	 * @param Etudiant etudiant L'�tudiant � inscrire
	 * @param String motDePasse Le mot de passe � lui attribuer
	 * @throws EtudiantInconnu Si l'�tudiant est d�j� inscrit, ou qu'il ne fait pas parti de cette universit�
	 * @author Gaetan
	 */
	@Override
	public void inscrire(Etudiant etudiant, String motDePasse) throws EtudiantDejaInscritException, EtudiantInconnuException {
		EtudiantImpl etudiantAInscrire = null;
		
		for (EtudiantImpl e : this.etudiants)
		{
			if (e.numEtudiant().equals(etudiant.numEtudiant()))
			{
				etudiantAInscrire = e;
				break;
			}
		}
		if (etudiantAInscrire == null)
		{
			throw new EtudiantInconnuException(((EtudiantImpl) etudiant).numEtudiant(), this.nom);
		}
		else
		{
			etudiantAInscrire.inscrireEtudiant(motDePasse);
		}
	}

	/**
	 * Cette m�thode connecte un �tudiant. Elle v�rifie le mot de passe pass� en param�tre
	 * 	
	 * @param Etudiant etudiant L'�tudiant � connecter
	 * @param String motDePasse Le mot de passe saisit lors de la tentative d'inscription
	 * @throws EtudiantInconnu Si le mot de passe est incorrect, ou que l'�tudiant ne fait pas parti de cette universit�
	 * @author Gaetan
	 */
	@Override
	public void connecter(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException {
		EtudiantImpl etudiantAConnecter = null;
		
		for (EtudiantImpl e : this.etudiants)
		{
			if (e.numEtudiant().equals(etudiant.numEtudiant()))
			{
				etudiantAConnecter = e;
				break;
			}
		}

		if (etudiantAConnecter == null || etudiantAConnecter.getMotDePasse() == null)
		{
			throw new EtudiantInconnuException(((EtudiantImpl) etudiant).numEtudiant(), this.nom);
		}
		else
		{
			if (!etudiantAConnecter.getMotDePasse().equals(motDePasse))
			{
				throw new EtudiantInconnuException(((EtudiantImpl) etudiant).numEtudiant(), this.nom);
			}
		}
	}

	/**
	 * Cette m�thode retourne la proposition de formation faite par l'universit� pour le master demand�
	 * 
	 * @param formation Master Le master pour lequel on cherche une proposition
	 * @return Proposition La proposition correspondant au master demand�, null si il n'est pas propos�
	 * @author Gaetan
	 */
	@Override
	public Proposition getPropositionByFormation(Master formation){
		for (PropositionImpl p : this.listeDesPropositions)
		{
			if (p.masterPropose() == formation)
			{
				return p._this();
			}
		}
		
		return null;
	}

	/**
	 * Retourne la ou les licences pr�requises si le master est propos� par cette universit�
	 * 
	 * Pr�-condition : L'universit� doit propos� ce Master
	 * 
	 * @param formation Master Le master pour lequel on demande les pr�requis
	 * @return Licence[] La liste des licences pr�requise pour postuler
	 * @author Gaetan
	 * @throws PropositionDoesNotExist 
	 */
	@Override
	public Licence[] getPrerequis(Proposition p) throws PropositionDoesNotExistException {
		PropositionImpl proposition = (PropositionImpl) p;
		
		if (proposition == null)
		{
			throw new PropositionDoesNotExistException(p.masterPropose());
		}
		else
		{
			return proposition.prerequis();
		}
	}
	
	/**
	 * Effectue une proposition de formation 
	 * 
	 * @param nouvelleFormation Master Le master propos�
	 * @param prerequis Licence[] L'ensemeble des formations pr�requisent
	 * @param universite Universite l'universite de la proposition
	 * @author Thibaut
	 */
	@Override
	public void creerProposition(String intituleMaster, Licence[] prerequis) throws formationDejaProposeeException{
		
		// test si la formation existe deja
		for (PropositionImpl p : this.listeDesPropositions)
		{
			if (p.masterPropose().intitule().equals(intituleMaster))
			{
				throw new formationDejaProposeeException();
			}
			else
			{
				// cr�e un nouvelle proposition de formation 
				this.listeDesPropositions.add(new PropositionImpl(prerequis, this.nom, intituleMaster));
			}
		}	
	}
	
	
	/**
	 * Effectue une proposition de formation 
	 * 
	 * @param proposition Proposition Le master de la proposition
	 * @param nouveauxPrerequis Licence[] La nouvelle liste de pr�requis 
	 * @author Thibaut
	 */
	@Override
	public void majPrerequis(Proposition proposition, Licence[] nouveauxPrerequis) throws PropositionDoesNotExistException {
		// TODO Auto-generated method stub
		// test si la formation existe deja
		PropositionImpl p = (PropositionImpl) proposition;
		
		if (p == null)
		{
			throw new PropositionDoesNotExistException(p.masterPropose());
		}
		else
		{
			p.prerequis(nouveauxPrerequis);
		}
		
	}


	/**
	 * Retourne la position de l'etudiant pour la formation "formation" auquel il postule
	 * 
	 * Pr�_requis : L'etudiant doit avoir un diplome (licence)
	 * 
	 * @param sujet Etudiant L'etudiant pour lequel on demande le classement
	 * @return short La liste des licences pr�requise pour postuler
	 * @author Thibaut
	 */

	
	public boolean checkLicenceEtudiant(Etudiant _etudiant, Licence formation){
		return false;
		
	}

	/**
	 * Retourne la position de l'etudiant pour la formation "formation" auquel il postule
	 * 
	 * Pr�_requis : L'etudiant doit avoir un diplome (licence)
	 * 
	 * @param sujet Etudiant L'etudiant pour lequel on demande le classement
	 * @return short La liste des licences pr�requise pour postuler
	 * @author Thibaut
	 */
	@Override
	public short getPositionEtudiant(Etudiant sujet, Licence formation)
			throws pasDiplomeException {
				EtudiantImpl etudiantPosition = this.etudiants.get(this.etudiants.indexOf((EtudiantImpl) sujet));
				// TODO Recup�rer la position 
				return 0;
	}

	public void referencer(EtudiantImpl etudiantAAjouter) {
		this.etudiants.add(etudiantAAjouter);
		System.out.println(Calendar.getInstance().getTime().toString() + " : Universite_ " + this.nom + ".referencer(EtudiantImpl) :");
	}
}
