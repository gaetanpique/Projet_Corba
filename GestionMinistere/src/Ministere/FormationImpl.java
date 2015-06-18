package Ministere;

import java.util.Calendar;

import org.omg.CORBA.ORB;

import Util.UtilConnexion;
import Etudes.Formation;
import Etudes.FormationPOA;

 class FormationImpl extends FormationPOA {

	 private String intitule;
	 
	 public FormationImpl(String intit){
		 this.intitule = intit;
		 
		 ORB orb = UtilConnexion.connexionAuNammingService(this, "Formation_" + this.intitule);
		 
		 System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Formation_" + this.intitule + " r�f�renc� et op�rationnel.");
				 
		 // Lancement de l'ORB et mise en attente de requete
		 orb.run();
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
	@Override
	public boolean _equals(Formation formation) {
		return (this.intitule().equals(formation.intitule()));
	}

	
}
