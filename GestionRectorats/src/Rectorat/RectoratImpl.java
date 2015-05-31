package Rectorat;

import Etudes.Formation;
import Etudes.Proposition;
import Etudes.RectoratPOA;
import Etudes.Universite;

public class RectoratImpl extends RectoratPOA {

	@Override
	public boolean demanderConnexion(String numEtudiant, String motDePasse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean demanderInscription(String numEtudiant, String motDePasse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Universite[] getListUniversites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation[] getAccreditationsByUniversite(Universite universite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		// TODO Auto-generated method stub
		return null;
	}

}
