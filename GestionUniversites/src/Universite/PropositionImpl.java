package Universite;

import java.util.ArrayList;

import Etudes.Licence;
import Etudes.Master;
import Etudes.PropositionPOA;
import Etudes.Resultat;
import Etudes.Universite;

public class PropositionImpl extends PropositionPOA {
	
//	� d�clarer dans l'IDL
//	private ArrayList<Licence> prerequis = new ArrayList<Licence>(); 

	@Override
	public boolean isCompatible(Resultat resultatEtudiant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Universite universiteSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Master masterPropose() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* a d�clarer dans l'IDL
	public Licence[] getPrerequis()
	{
		return this.prerequis.toArray(new Licence[this.prerequis.size()]);
	}
*/
}
