package Universite;
import Etudes.Licence;
import Etudes.Proposition;
import Etudes.ResultatPOA;


public class ResultatImpl extends ResultatPOA {

	private Licence licence;
	private float moyenne;
	private Proposition proposition;
	
	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	@Override
	public String codeObtention() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float moyenne() {
		return moyenne;
	}

	@Override
	public void moyenne(float value) {
		moyenne = value;
	}

	@Override
	public boolean betterThenPrerequis(Proposition aComparer) {
		return false;
	}

}
