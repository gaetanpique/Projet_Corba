package Universite;

import java.util.ArrayList;
import java.util.Collection;

import Util.UtilTraitements;
import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantPOA;
import Etudes.Licence;
import Etudes.Proposition;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.Voeu;
import Etudes.diplomesDifferentsException;

 class EtudiantImpl extends EtudiantPOA {
	
	private String numero;	
	private String motDePasse;
	private Resultat resultats;
	private Universite universite;
	private ArrayList<Voeu> listeVoeux;
	
	public EtudiantImpl (String numE, Resultat resE, Universite univE){
		this.numero = numE;
		this.resultats = resE;
		this.universite = univE;
	}

	@Override
	public Voeu[] listeVoeux() {
		return (Voeu[]) Util.UtilTraitements.ToTableau(listeVoeux);
	}
	
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

	/**
	 * Cette m�thode retourne l'attribut position du r�sultat de l'�tudiant
	 * 
	 * 
	 * @return attribut position de l'�tudiant sur son r�sultat
	 * @author Baptiste
	 */
	@Override
	public short getPositionEtudiant() {
		// appel interne au projet donc pas de m�thode CORBA
		ResultatImpl res = (ResultatImpl) this.resultats();
		return res.position();
	}
	
	/**
	 * Cette m�thode v�rifie si un �tudiant a la Licence entr�e en param�tre
	 * 
	 * @return resultat de la v�rification
	 * @author Baptiste
	 */
	public boolean checkLicence(Licence l){
		ResultatImpl res1 = (ResultatImpl) this.resultats();
		return (res1.getLicence()._equals(l));
	}

	@Override
	public void listeVoeux(Voeu[] value) {
		listeVoeux.clear();
		listeVoeux.addAll((Collection<? extends Voeu>) UtilTraitements.ToArray(value));	
	}
}
