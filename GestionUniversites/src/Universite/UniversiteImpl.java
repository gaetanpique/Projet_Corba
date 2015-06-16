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
