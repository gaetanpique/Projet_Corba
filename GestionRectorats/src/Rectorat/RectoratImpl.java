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
	 * Cette m�thode recherche l'�tudiant correspondant au num�ro demand�
	 * 
	 * @param String numEtudiant Le num�ro de l'�tudiant recherch�
	 * @return Etudiant L'�tudiant si il appartient � ce rectorat, null si il n'a pas �t� trouv�
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
	 * Cette m�thode v�rifie une demande de connexion.
	 * 
	 * Pr�-conditions : L'�tudiant doit �tre inscrit dans une universit� de ce rectorat
	 * 
	 * @param etudiant Etudiant L'�tudiant qui �ssait de se connecter
	 * @param motDePasse String Le mot de passe entr� lors de la demande de connexion
	 * @return boolean Vrai si le mot de passe correspond au num�ro �tudiant envoy�, Faux sinon
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
	 * Cette m�thode traite une demande d'inscription. V�rifie dans un premier que l'�tudiant n'est pas d�j� inscrit,
	 * puis l'inscrit si il ne l'�tait pas.
	 * 
	 * Pr�-conditions : L'�tudiant doit avoir �tudi� dans une des universit�s de ce rectorat, et ne doit pas �tre inscrit
	 * 
	 * @param etudiant Etudiant L'�tudiant qui essait de s'inscrire
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
				System.out.println("ERREUR : Etudiant n�" + e.numEtudiantInconnu + " inconnu de l'universit� " + e.nomUniversite);
				return false;
			}
		}
	}

	/**
	 * Cette m�thode retourne l'ensemble des universit�s qui d�pendent de ce rectorat
	 * 
	 * @return Universite[] Un tableau des unviersit�s
	 */
	@Override
	public Universite[] getListUniversites() {
		return this.universites.toArray(new Universite[this.universites.size()]);
	}

	/**
	 * Cette m�thode retourne les formations de Master pour lesquelles l'universit� en question � une accr�ditation
	 * 
	 * Pr�-condition : L'universit� doit d�pendre de ce rectorat
	 * 
	 * @param universite Universite L'universit� pour lesquelles on veut les accr�ditations
	 * @return Formation[] La liste des accr�ditations
	 */
	@Override
	public Formation[] getAccreditationsByUniversite(Universite universite) {
		return this.accreditations.get(universite).toArray(new Formation[this.accreditations.get(universite).size()]);
	}

	/**
	 * Cette m�thode retourne toutes les propositions des universit�s qui d�pendent de ce rectorat pour la formation demand�e
	 * 
	 * @param formation Formation La formation pour laquelle on veut r�cup�rer les propositions
	 * @return Proposition[] Les propositions des universit�s de ce rectorat pour la formation pass�e en param�tre
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
