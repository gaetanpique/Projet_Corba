package Universite;

import Etudes.Etudiant;
import Etudes.EtudiantPOA;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.diplomesDifferents;

public class EtudiantImpl extends EtudiantPOA {
	
	private String numero;
	
	private String motDePasse;

	@Override
	public Resultat resultats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resultats(Resultat value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estMeilleurQue(Etudiant aComparer) throws diplomesDifferents {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Universite getUniversite() {
		// TODO Auto-generated method stub
		return null;
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

}
