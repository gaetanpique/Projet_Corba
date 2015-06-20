package Ministere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.rmi.CORBA.UtilDelegate;

import Etudes.Formation;
import Etudes.MinisterePOA;
import Etudes.Proposition;
import Etudes.Rectorat;
import Util.DbConnection;
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
		initFormations();
		
	}
	
	private void initFormations()
	{
		String[] colonnes = new String[1];
		colonnes[0]="*";
		ResultSet resultatSQL = DbConnection.selectIntoDB("formation", colonnes, "");
		try {
			while(resultatSQL.next())
			{
				new FormationImpl(resultatSQL.getString(0));
			}
			resultatSQL.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
