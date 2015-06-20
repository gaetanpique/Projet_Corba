package Universite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;



import org.omg.CORBA.ORB;

import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantPOA;
import Etudes.Licence;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.Voeu;
import Etudes.diplomesDifferentsException;
import Util.*;

public class EtudiantImpl extends EtudiantPOA {
	
	private String numero;	
	private String motDePasse;
	private ArrayList<ResultatImpl> resultats;
	private UniversiteImpl universite;
	private ArrayList<Voeu> listeVoeux;

	public EtudiantImpl(String numE, ArrayList<ResultatImpl> resE, UniversiteImpl univE) {
		this(numE, resE, univE, null);
	}

	public EtudiantImpl(String numE, ArrayList<ResultatImpl> resE, UniversiteImpl univE,
			String motDePasse) {
		this.numero = numE;
		this.resultats = resE;
		this.universite = univE;
		this.motDePasse = motDePasse;
		this.listeVoeux = new ArrayList<Voeu>();

		UtilConnexion.connexionAuNammingService(this, "Etu_" + this.numero);
		
		this.universite.referencer(this);
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Etudiant_" + this.numero + " référencé et opérationnel.");
	}
	
	public EtudiantImpl(String numEtudiant, UniversiteImpl u, String mdp) 
	{		
		ArrayList<ResultatImpl> r = new ArrayList<ResultatImpl>();
		for(int i =1; i==6;i++)
		{
			r.add(new ResultatImpl(numEtudiant,i));
		}
		
		//this(numEtudiant, r, u,mdp);
	}

	//-----------------GETTERS ANS SETTERS--------------------------------//
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public Voeu[] listeVoeux() {
		return (Voeu[]) Util.UtilTraitements.ToTableau(listeVoeux);
	}

	@Override
	public Resultat[] resultats() {
		return (Resultat[]) UtilTraitements.ToTableau(resultats);
	}

	@Override
	public Universite getUniversite() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : Etudiant_" + this.numero + ".getUniversite()");
		return universite._this();
	}
	
	@Override
	public String numEtudiant() {
		return this.numero;
	}

	//-----------------METHODS--------------------------------//
	/**
	 * Compare la moyenne des semestres de deux étudiants.
	 * En cas d'égalité, on compare leur position au dernier semestre
	 * 
	 * @return false si l'étudiant en paramètre est meilleur, true sinon
	 * @author BAPeTISTE
	 */
	@Override
	public boolean estMeilleurQue(Etudiant aComparer) {
		EtudiantImpl e = (EtudiantImpl)aComparer;
		float moy1 = this.getMoyenneLicenceEtudiant();
		float moy2 = e.getMoyenneLicenceEtudiant();
		
		//si moyennes égales, on compare la position da l'élève dans la promotion
		if (moy1 == moy2) {
			return (this.resultats()[this.resultats().length-1].position() > e.resultats()[this.resultats().length-1].position());
		} else
			return (moy1 > moy2);
	}
	
	/**
	 * Calcule la moyenne de tous les semestres d'un étudiant (les résultats contenus dans la liste "resultats"
	 * 
	 * @return float représentant la moyenne des semestre
	 */
	public float getMoyenneLicenceEtudiant(){
		float moy = 0;
		for(ResultatImpl r : this.resultats){
			moy += r.moyenne();
		}
		return (moy/this.resultats.size());
	}

	/**
	 * Cette méthode initialise le mot de passe d'un étudiant entré en paramètre
	 * prérequis : le mdp doit être null
	 * 
	 * @exception EtudiantDejaInscritException
	 *                : étudiant déjà inscrit
	 * @author Baptiste
	 */
	public void inscrireEtudiant(String mdp)
			throws EtudiantDejaInscritException {
		if (this.motDePasse != null)
			throw new EtudiantDejaInscritException(this.numero);
		else
			this.motDePasse = mdp;
	}

	/**
	 * Cette méthode vérifie si un résultat est valide pour une formation
	 * donnée.
	 * 
	 * 
	 * @return validité du résultat.
	 * @author Baptiste
	 */
	public boolean ResultatsValideForProposition(Proposition p) {
		// Résultat est dans le même projet donc on appelle la méthode en local
		ResultatImpl r = (ResultatImpl) this.resultats()[0];;
		return r.isValideForProposition(p);
	}

	/**
	 * Cette méthode retourne l'attribut position du dernier semestre de l'étudiant
	 * 
	 * 
	 * @return attribut position de l'étudiant sur son résultat
	 * @author Baptiste
	 */
	@Override
	public int getPositionEtudiant() {
		// appel interne au projet donc pas de méthode CORBA
		ResultatImpl res = (ResultatImpl) this.resultats()[this.resultats().length-1];
		return res.position();
	}

	/**
	 * Cette méthode vérifie si un étudiant a la Licence entrée en paramètre
	 * 
	 * @return resultat de la vérification
	 * @author Baptiste
	 */
	public boolean checkLicence(Licence l) {
		ResultatImpl res1 = (ResultatImpl) this.resultats()[0];
		return (res1.getLicence()._equals(l));
	}

	/**
	 * Ajoute un voeu à la lite des voeux de l'étudiant (listeVoeux)
	 */
	@Override
	public void addVoeuEtudiant(Voeu v) throws NombreMaxDeVoeuxAtteintException {
		if (listeVoeux.size() == 5) {
			throw new NombreMaxDeVoeuxAtteintException();
		}
		else listeVoeux.add(v);
	}


}
