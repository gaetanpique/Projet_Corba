package Rectorat;

import java.util.ArrayList;
import java.util.HashMap;

import Etudes.Etudiant;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.Formation;
import Etudes.Master;
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
	 * @author Gaetan
	 */
	@Override
	public Etudiant getEtudiantByNumero(String numEtudiant) {
		Etudiant result = null;
		System.out.println("TEST DE COMMIT");
		
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
	 * @throws EtudiantInconnu Si il n'est pas inscrit, ou ne d�pend pas de ce rectorat
	 * @author Gaetan
	 */
	@Override
	public void demanderConnexion(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException{
		Universite univDeLetudiant = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		if (univDeLetudiant == null)
		{
			throw new EtudiantInconnuException();
		}
		else
		{
			univDeLetudiant.connecter(etudiant, motDePasse);
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
	 * @throws EtudiantInconnu Si l'�tudiant ne fait pas parti de ce rectorat, ou si il est d�j� inscrit
	 * @author Gaetan
	 */
	@Override
	public void demanderInscription(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException {
		Universite univDinscription = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		//univDinscription == null <=> �tudiant ne fait pas partie de ce rectorat
		if (univDinscription == null)
		{
			throw new EtudiantInconnuException();
		}
		else
		{
			try {
				univDinscription.inscrire(etudiant, motDePasse);
			} catch (EtudiantInconnuException e) {
				System.out.println("ERREUR : Etudiant n�" + e.numEtudiantInconnu + " inconnu de l'universit� " + e.nomUniversite);
				throw e;
			}
		}
	}

	/**
	 * Cette m�thode retourne l'ensemble des universit�s qui d�pendent de ce rectorat
	 * 
	 * @return Universite[] Un tableau des unviersit�s
	 * @author Gaetan
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
	 * @author Gaetan
	 */
	@Override
	public Formation[] getAccreditationsByUniversite(Universite universite) {
		return this.accreditations.get(universite).toArray(new Formation[this.accreditations.get(universite).size()]);
	}

	/**
	 * Cette m�thode retourne toutes les propositions des universit�s qui d�pendent de ce rectorat pour la formation demand�e
	 * 
	 * @param formation Master La formation pour laquelle on veut r�cup�rer les propositions
	 * @return Proposition[] Les propositions des universit�s de ce rectorat pour la formation pass�e en param�tre
	 * @author Gaetan
	 */
	@Override
	public Proposition[] getPropositionByFormation(Master formation) {
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
