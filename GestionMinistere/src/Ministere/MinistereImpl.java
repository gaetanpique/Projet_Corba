package Ministere;

import java.util.ArrayList;
import java.util.Calendar;

import Etudes.Formation;
import Etudes.MinisterePOA;
import Etudes.Proposition;
import Etudes.Rectorat;
import Util.UtilConnexion;

public class MinistereImpl extends MinisterePOA {
	
	private ArrayList<Rectorat> rectorats = new ArrayList<Rectorat>();
	
	private ArrayList<Formation> formations = new ArrayList<Formation>();  

	public MinistereImpl()
	{
		UtilConnexion.connexionAuNammingService(this, "Ministere");
			 
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant MinistereImpl référencé et opérationnel.");
			 
		// Lancement de l'ORB et mise en attente de requete
		UtilConnexion.runORB();
	}
	
	@Override
	public Formation[] getListFormations() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListFormations()");
		return new Formation[1];
	}

	@Override
	public Rectorat[] getListRectorats() {
		
		return this.rectorats.toArray(new Rectorat[this.rectorats.size()]);
	}

	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getPropositionByFormation()");
		return new Proposition[1];
	}

	@Override
	public void referencer(Rectorat rectoratConnecte) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.referencer(Rectorat)");
		this.rectorats.add(rectoratConnecte);
	}

	public void referencer(Formation formationReferencee) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.referencer(Formation)");
		this.formations.add(formationReferencee);
	}

	@Override
	public void dereferencer(Rectorat rectoratDeconnecte) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.dereferencer()");
		this.rectorats.remove(rectoratDeconnecte);
	}
	
	public static void main(String[] args) {
		new MinistereImpl();
	}
}
