package Universite;

import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantPOA;
import Etudes.Formation;
import Etudes.Proposition;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.diplomesDifferents;
import Etudes.diplomesDifferentsException;

 class EtudiantImpl extends EtudiantPOA {
	
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
	public boolean estMeilleurQue(Etudiant aComparer) throws diplomesDifferentsException {
		ResultatImpl res1 = (ResultatImpl) this.resultats();
		ResultatImpl res2 = (ResultatImpl) aComparer.resultats();
		if (!res1.getLicence()._equals(res2.getLicence()))
		{
			throw new diplomesDifferentsException();
		}
		else
		{
			return (res1.moyenne() > res2.moyenne());
		}
	}
	
	/**
	 * Cette m�thode initialise le mot de passe d'un �tudiant entr� en param�tre
	 * pr�requis : le mdp doit �tre null
	 * 
	 * @exception EtudiantDejaInscritException : �tudiant d�j� inscrit
	 * @author Baptiste
	 */
	public void inscrireEtudiant(String mdp) throws  EtudiantDejaInscritException{
		if (this.motDePasse == null)
			throw new EtudiantDejaInscritException(this.numero);
		else setMotDePasse(mdp);
	}
	
	/**
	 * Cette m�thode v�rifie si un r�sultat est valide pour une formation donn�e.
	 * 
	 * 
	 * @return validit� du r�sultat.
	 * @author Baptiste
	 */
	public boolean ResultatsValideForProposition(Proposition p){
		//R�sultat est dans le m�me projet donc on appelle la m�thode en local
		ResultatImpl r = (ResultatImpl)this.resultats();
		return r.isValideForProposition(p);
	}
}
