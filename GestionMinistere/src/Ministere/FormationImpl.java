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
	 * Cette méthode compare les intitulés de la formation et de celle passée en paramètre
	 * 
	 * @return true : intitulés identiques / false : intitulés différents
	 * @author Baptiste
	 */
	public boolean _equals(Formation formation) {
		return (this.intitule().equals(formation.intitule()));
	}

	
}
