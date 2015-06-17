package Universite;

import java.util.ArrayList;

import Etudes.Etudiant;
import Etudes.EtudiantInconnuException;
import Etudes.Formation;
import Etudes.Licence;
import Etudes.Master;
import Etudes.Proposition;
import Etudes.PropositionDoesNotExistException;
import Etudes.Rectorat;
import Etudes.Universite;
import Etudes.UniversitePOA;
import Etudes.diplomesDifferents;
import Etudes.pasDiplomeException;

public class UniversiteImpl extends UniversitePOA {
	
	private String nom;
	
	private Rectorat rectoratDappartenance;
	
	private ArrayList<EtudiantImpl> etudiants;
	
	private ArrayList<Proposition> mastersProposes; 

	/**
	 * Cette méthode retourne la liste des étudiants qui ont étudié au sein de cette université
	 * 
	 * @return Etudiant[] Un tableau des étudiants
	 * @author Gaetan
	 */
	@Override
	public Etudiant[] getEtudiants() {
		return this.etudiants.toArray(new Etudiant[this.etudiants.size()]);
	}

	/**
	 * Cette méthode l'étudiant correspondant au numéro demandé. Si aucun n'étudiant de cette université ne porte ce numéro, retourne null
	 * 
	 * @param String numEtudiant La numéro de l'étudiant recherché
	 * @return Etudiant L'étudiant recherché si il appartient à cette université, null sinon
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
	 * Cette méthode inscrit un étudiant en lui attribuant le mot de passe passé en paramètre
	 * 
	 * @param Etudiant etudiant L'étudiant à inscrire
	 * @param String motDePasse Le mot de passe à lui attribuer
	 * @throws EtudiantInconnu Si l'étudiant est déjà inscrit, ou qu'il ne fait pas parti de cette université
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
	 * Cette méthode connecte un étudiant. Elle vérifie le mot de passe passé en paramètre
	 * 	
	 * @param Etudiant etudiant L'étudiant à connecter
	 * @param String motDePasse Le mot de passe saisit lors de la tentative d'inscription
	 * @throws EtudiantInconnu Si le mot de passe est incorrect, ou que l'étudiant ne fait pas parti de cette université
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
	 * Cette méthode retourne la proposition de formation faite par l'université pour le master demandé
	 * 
	 * @param formation Master Le master pour lequel on cherche une proposition
	 * @return Proposition La proposition correspondant au master demandé, null si il n'est pas proposé
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
	 * Retourne la ou les licences prérequises si le master est proposé par cette université
	 * 
	 * Pré-condition : L'université doit proposé ce Master
	 * 
	 * @param formation Master Le master pour lequel on demande les prérequis
	 * @return Licence[] La liste des licences prérequise pour postuler
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
	 * @param nouvelleFormation Master Le master proposé
	 * @param prerequis Licence[] L'ensemeble des formations prérequisent
	 * @param universite Universite l'universite de la proposition
	 * @author Thibaut
	 */
	@Override
	public void creerProposition(Master nouvelleFormation, Licence[] prerequis, Universite universite) {
		// TODO Auto-generated method stub
		// crée un nouvelle proposition de formation 
		PropositionImpl proposition = new PropositionImpl(prerequis, universite, nouvelleFormation);
		
		/*
		// test si la formation existe deja
		for (Proposition p : this.mastersProposes)
		{
			if (p.masterPropose() == nouvelleFormation)
			{
				throw new formationDejaExistantException();
			}
		}	
		*/
	}
	
	
	/**
	 * Effectue une proposition de formation 
	 * 
	 * @param proposition Proposition Le master de la proposition
	 * @param nouveauxPrerequis Licence[] La nouvelle liste de prérequis 
	 * @author Thibaut
	 */
	@Override
	public void majPrerequis(Proposition proposition, Licence[] nouveauxPrerequis)
			throws PropositionDoesNotExistException {
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
	 * Pré_requis : L'etudiant doit avoir un diplome (licence)
	 * 
	 * @param sujet Etudiant L'etudiant pour lequel on demande le classement
	 * @return short La liste des licences prérequise pour postuler
	 * @author Thibaut
	 */

	
	public boolean checkLicenceEtudiant(Etudiant _etudiant, Licence formation){
		return false;
		
	}

	/**
	 * Retourne la position de l'etudiant pour la formation "formation" auquel il postule
	 * 
	 * Pré_requis : L'etudiant doit avoir un diplome (licence)
	 * 
	 * @param sujet Etudiant L'etudiant pour lequel on demande le classement
	 * @return short La liste des licences prérequise pour postuler
	 * @author Thibaut
	 */
	@Override
	public short getPositionEtudiant(Etudiant sujet, Licence formation)
			throws pasDiplomeException {
		// TODO Auto-generated method stub
				EtudiantImpl etudiantPosition = this.etudiants.get(this.etudiants.indexOf((EtudiantImpl) sujet));
				// TODO Recupérer la position 
				return 0;
	}



}
