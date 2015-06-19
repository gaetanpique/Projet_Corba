package Universite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Calendar;

import Util.UtilTraitements;

import org.omg.CORBA.ORB;

import Util.UtilConnexion;
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

class EtudiantImpl extends EtudiantPOA {

	private String numero;
	private String motDePasse;
	private ResultatImpl resultats;
	private UniversiteImpl universite;
	private ArrayList<Voeu> listeVoeux;

	public EtudiantImpl(String numE, ResultatImpl resE, UniversiteImpl univE) {
		this(numE, resE, univE, null);
	}

	public EtudiantImpl(String numE, ResultatImpl resE, UniversiteImpl univE,
			String motDePasse) {
		this.numero = numE;
		this.resultats = resE;
		this.universite = univE;
		this.motDePasse = motDePasse;
		this.listeVoeux = new ArrayList<Voeu>();

		ORB orb = UtilConnexion.connexionAuNammingService(this, "Etu_"
				+ this.numero);

		this.universite.referencer(this);
		System.out.println(Calendar.getInstance().getTime().toString()
				+ " : Servant Etudiant_" + this.numero
				+ " référencé et opérationnel.");

		orb.run();
	}

	@Override
	public void listeVoeux(Voeu[] value) {
		listeVoeux.clear();
		listeVoeux.addAll((Collection<? extends Voeu>) UtilTraitements
				.ToArray(value));
	}

	@Override
	public void resultats(Resultat value) {
		resultats = (ResultatImpl) value;

	}

	@Override
	public Voeu[] listeVoeux() {
		return (Voeu[]) Util.UtilTraitements.ToTableau(listeVoeux);
	}

	@Override
	public Resultat resultats() {
		return resultats._this();
	}

	@Override
	public Universite getUniversite() {
		return universite._this();
	}

	public String getNumero() {
		return this.numero;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public boolean estMeilleurQue(Etudiant aComparer)
			throws diplomesDifferentsException {
		ResultatImpl res1 = (ResultatImpl) this.resultats();
		ResultatImpl res2 = (ResultatImpl) aComparer.resultats();
		if (!res1.getLicence()._equals(res2.getLicence())) {
			throw new diplomesDifferentsException();
		} else if (res1.moyenne() == res2.moyenne()) {
			return (res1.position() > res2.position());
		} else
			return (res1.moyenne() > res2.moyenne());
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
		if (this.motDePasse == null)
			throw new EtudiantDejaInscritException(this.numero);
		else
			setMotDePasse(mdp);
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
		ResultatImpl r = (ResultatImpl) this.resultats();
		return r.isValideForProposition(p);
	}

	/**
	 * Cette méthode retourne l'attribut position du résultat de l'étudiant
	 * 
	 * 
	 * @return attribut position de l'étudiant sur son résultat
	 * @author Baptiste
	 */
	@Override
	public short getPositionEtudiant() {
		// appel interne au projet donc pas de méthode CORBA
		ResultatImpl res = (ResultatImpl) this.resultats();
		return res.position();
	}

	/**
	 * Cette méthode vérifie si un étudiant a la Licence entrée en paramètre
	 * 
	 * @return resultat de la vérification
	 * @author Baptiste
	 */
	public boolean checkLicence(Licence l) {
		ResultatImpl res1 = (ResultatImpl) this.resultats();
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
