package UtilVoeux;

import Etudes.Etudiant;
import Etudes.Master;
import Etudes.Proposition;
import Etudes.Universite;
import Etudes.VoeuPOA;

public class VoeuImpl extends VoeuPOA 
{
	private Proposition propositionCorrespondante;
	private Etudiant etudiantCorrespondant;
	private short position;
	
	public VoeuImpl() {
		// TODO Auto-generated constructor stub
	}
	//-----------------GETTERS ANS SETTERS--------------------------------//
	


	@Override
	public short position() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void position(short value) {
		this.position = value;
		
	}
	
	//-------------------READ ONLY ATTRIBUTES-------------------------------//
	
	/**
	 * @return the propositionCorrespondante
	 */
	@Override
	public Proposition propositionCorrespondante() {
		// TODO Auto-generated method stub
		return propositionCorrespondante;
	}

	@Override
	public Etudiant etudiantCorrespondant() {
		// TODO Auto-generated method stub
		return etudiantCorrespondant;
	}

	
	//---------------------------------METHODS-------------------------------//

	@Override
	public void valider() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cloturer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accepter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refuser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refuserDefinitevement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void majClassement(short classement) {
		// TODO Auto-generated method stub

	}





}
