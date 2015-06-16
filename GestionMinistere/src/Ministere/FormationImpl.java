package Ministere;

import Etudes.Formation;
import Etudes.FormationPOA;

 class FormationImpl extends FormationPOA {

	 private String intitule;
	 
	 public FormationImpl(String intit){
		 this.intitule = intit;
	 }
	 
	@Override
	public String intitule() {
		return this.intitule;
	}


	/**
	 * Cette m�thode compare les intitul�s de la formation et de celle pass�e en param�tre
	 * 
	 * @return true : intitul�s identiques / false : intitul�s diff�rents
	 * @author Baptiste
	 */
	public boolean _equals(Formation formation) {
		return (this.intitule().equals(formation.intitule()));
	}

	
}
