package Universite;

import java.util.ArrayList;

import Etudes.Etudiant;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.Formation;
import Etudes.Licence;
import Etudes.Master;
import Etudes.Proposition;
import Etudes.PropositionDoesNotExist;
import Etudes.PropositionDoesNotExistException;
import Etudes.Rectorat;
import Etudes.UniversitePOA;
import Etudes.pasDiplomeException;

public class UniversiteImpl extends UniversitePOA {
	
	private String nom;
	
	private Rectorat rectoratDappartenance;
	
	private ArrayList<EtudiantImpl> etudiants;
	
	private ArrayList<Proposition> mastersProposes; 

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
		Etudiant result = null;
		
		for (EtudiantImpl e : this.etudiants)
		{
			if (e.getNumero().equals(numEtudiant))
			{
				result = (Etudiant) e;
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
	public void inscrire(Etudiant etudiant, String motDePasse)
			throws EtudiantInconnuException {
		EtudiantImpl etudiantAInscrire = this.etudiants.get(this.etudiants.indexOf((EtudiantImpl) etudiant));
		
		if (etudiantAInscrire == null)
		{
			throw new EtudiantInconnuException(((EtudiantImpl) etudiant).getNumero(), this.nom);
		}
		else
		{
			etudiantAInscrire.setMotDePasse(motDePasse);
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
		EtudiantImpl etudiantAConnecter = this.etudiants.get(this.etudiants.indexOf((EtudiantImpl) etudiant));
		
		if (etudiantAConnecter == null)
		{
			throw new EtudiantInconnuException(((EtudiantImpl) etudiant).getNumero(), this.nom);
		}
		else
		{
			if (!etudiantAConnecter.getMotDePasse().equals(motDePasse))
			{
				throw new EtudiantInconnuException(((EtudiantImpl) etudiant).getNumero(), this.nom);
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
		for (Proposition p : this.mastersProposes)
		{
			if (p.masterPropose() == formation)
			{
				return p;
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
	 */
	@Override
	public Licence[] getPrerequis(Master formation) throws PropositionDoesNotExistException {
		PropositionImpl proposition = (PropositionImpl) this.getPropositionByFormation(formation);
		
		if (proposition == null)
		{
			throw new PropositionDoesNotExistException(formation);
		}
		else
		{
			return proposition.prerequis();
		}
	}

	@Override
	public void creerProposition(Formation nouvelleFormation,
			Licence[] prerequis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void majPrerequis(Formation formation, Licence[] nouveauxPrerequis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getClassementEtudiant(Etudiant sujet, Licence formation)
			throws pasDiplomeException {
		// TODO Auto-generated method stub
		return 0;
	}

}
