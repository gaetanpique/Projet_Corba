package Universite;

import Etudes.Etudiant;
import Etudes.EtudiantPOA;
import Etudes.Formation;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.diplomesDifferents;

public class EtudiantImpl extends EtudiantPOA {
	
	private String numero;	
	private String motDePasse;
	private Resultat resultats;
	private Universite universite;

	@Override
	public Resultat resultats() {
		return resultats;
	}

	@Override
	public void resultats(Resultat value) {
		resultats = value;
	}
	

	@Override
	public Universite getUniversite() {
		return universite;
	}
	
	public String getNumero()
	{
		return this.numero;
	}
	
	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Override
	public boolean estMeilleurQue(Etudiant aComparer) throws diplomesDifferents {
		Resultat res1 = this.resultats();
		Resultat res2 = aComparer.resultats();
		
		if (!res1. licence().equals(res2.getLicence()))
				throw new diplomesDifferents();
		return (res1.moyenne() > res2.moyenne());
	}
	
	/**
	 * Cette méthode vérifie si un étudiant est déjà inscrit ou pas (mdp vide ou non).
	 * Sinon, mdp est initialisé
	 * 
	 * @exception ErrEtudiantInscrit : étudiant déjà inscrit
	 * @author Baptiste
	 */
	public void inscrireEtudiant(String mdp) throws  EtudiantDejaInscritException{
		if (this.motDePasse.equals(""))
			throw new EtudiantDejaInscritException(this);
		else setMotDePasse(mdp);
	}
	
	/**
	 * Cette méthode vérifie si un résultat est valide pour une formation donnée.
	 * 
	 * 
	 * @return validité du résultat.
	 * @author Baptiste
	 */
	public boolean ResultatsValideForFormation(Formation f){
		return this.resultats().isValideForFormation(f);
	}
}
