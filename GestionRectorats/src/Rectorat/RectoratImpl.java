package Rectorat;

import java.util.ArrayList;
import java.util.HashMap;

import Etudes.Etudiant;
import Etudes.EtudiantInconnu;
import Etudes.Formation;
import Etudes.Proposition;
import Etudes.RectoratPOA;
import Etudes.Universite;

public class RectoratImpl extends RectoratPOA {
	
	private ArrayList<Universite> universites = new ArrayList<Universite>();
	
	private HashMap<Universite, ArrayList<Formation>> accreditations = new HashMap<Universite, ArrayList<Formation>>();
	

	/**
	 * Cette méthode recherche l'étudiant correspondant au numéro demandé
	 * 
	 * @param String numEtudiant Le numéro de l'étudiant recherché
	 * @return Etudiant L'étudiant si il appartient à ce rectorat, null si il n'a pas été trouvé
	 */
	@Override
	public Etudiant getEtudiantByNumero(String numEtudiant) {
		Etudiant result = null;
		
		for (Universite u : this.universites)
		{
			result = u.getEtudiantByNumero(numEtudiant);
			if (result != null)
			{
				break;
			}
		}
		
		return result;
	}

	/**
	 * Cette méthode vérifie une demande de connexion.
	 * 
	 * Pré-conditions : L'étudiant doit être inscrit dans une université de ce rectorat
	 * 
	 * @param etudiant Etudiant L'étudiant qui éssait de se connecter
	 * @param motDePasse String Le mot de passe entré lors de la demande de connexion
	 * @return boolean Vrai si le mot de passe correspond au numéro étudiant envoyé, Faux sinon
	 */
	@Override
	public boolean demanderConnexion(Etudiant etudiant, String motDePasse) {
		if (etudiant.isInscrit() && etudiant.isMotDePasseCorrect(motDePasse))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Cette méthode traite une demande d'inscription. Vérifie dans un premier que l'étudiant n'est pas déjà inscrit,
	 * puis l'inscrit si il ne l'était pas.
	 * 
	 * Pré-conditions : L'étudiant doit avoir étudié dans une des universités de ce rectorat, et ne doit pas être inscrit
	 * 
	 * @param etudiant Etudiant L'étudiant qui essait de s'inscrire
	 * @param motDePasse String Le mot de passe qu'il a saisi
	 * @return boolean Vrai si l'inscription a bien eu lieu, faux sinon 
	 */
	@Override
	public boolean demanderInscription(Etudiant etudiant, String motDePasse) {
		Universite univDinscription = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		if (univDinscription == null)
		{
			return false;
		}
		else
		{
			try {
				univDinscription.inscrire(etudiant, motDePasse);
				return true;
			} catch (EtudiantInconnu e) {
				System.out.println("ERREUR : Etudiant n°" + e.numEtudiantInconnu + " inconnu de l'université " + e.nomUniversite);
				return false;
			}
		}
	}

	/**
	 * Cette méthode retourne l'ensemble des universités qui dépendent de ce rectorat
	 * 
	 * @return Universite[] Un tableau des unviersités
	 */
	@Override
	public Universite[] getListUniversites() {
		return this.universites.toArray(new Universite[this.universites.size()]);
	}

	/**
	 * Cette méthode retourne les formations de Master pour lesquelles l'université en question à une accréditation
	 * 
	 * Pré-condition : L'université doit dépendre de ce rectorat
	 * 
	 * @param universite Universite L'université pour lesquelles on veut les accréditations
	 * @return Formation[] La liste des accréditations
	 */
	@Override
	public Formation[] getAccreditationsByUniversite(Universite universite) {
		return this.accreditations.get(universite).toArray(new Formation[this.accreditations.get(universite).size()]);
	}

	/**
	 * Cette méthode retourne toutes les propositions des universités qui dépendent de ce rectorat pour la formation demandée
	 * 
	 * @param formation Formation La formation pour laquelle on veut récupérer les propositions
	 * @return Proposition[] Les propositions des universités de ce rectorat pour la formation passée en paramètre
	 */
	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		ArrayList<Proposition> resultat = new ArrayList<Proposition>();
		Proposition temp;
		
		for (Universite u : this.universites)
		{
			temp = u.getPropositionByFormation(formation);
			if (u.getPropositionByFormation(formation) != null)
			{
				resultat.add(temp);
			}
		}
		
		return resultat.toArray(new Proposition[resultat.size()]);
	}
}
