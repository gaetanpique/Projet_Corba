package Ministere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.rmi.CORBA.UtilDelegate;

import Etudes.Formation;
import Etudes.Master;
import Etudes.MinisterePOA;
import Etudes.Proposition;
import Etudes.Rectorat;
import Util.DbConnection;
import Util.UtilConnexion;

public class MinistereImpl extends MinisterePOA {
	
	private ArrayList<Rectorat> rectorats = new ArrayList<Rectorat>();
	
	private ArrayList<FormationImpl> formations = new ArrayList<FormationImpl>();  

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
		ResultSet resultatSQL = DbConnection.selectIntoDB("formations", colonnes, "");
		try {
			while(resultatSQL.next())
			{
				new FormationImpl(resultatSQL.getString(1));
			}
			resultatSQL.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Formation[] getListFormations() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListFormations()");
		
		Formation[] resultat = new Formation[this.formations.size()];
		int cpt = 0;
		
		for (FormationImpl f : this.formations)
		{
			resultat[cpt] = f._this();
			cpt++;
		}
		
		return resultat;
	}

	@Override
	public Rectorat[] getListRectorats() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListRectorats()");
		return this.rectorats.toArray(new Rectorat[this.rectorats.size()]);
	}

	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getPropositionByFormation()");
		
		ArrayList<Proposition> resultat = new ArrayList<Proposition>();
		Proposition[] temp;
		
		for (Rectorat r : this.rectorats)
		{
			temp = r.getPropositionByFormation(formation); 
			
			for (Proposition p : temp)
			{
				resultat.add(p);
			}
		}
		
		return resultat.toArray(new Proposition[resultat.size()]);
	}

	@Override
	public void referencer(Rectorat rectoratConnecte) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.referencer(Rectorat)");
		this.rectorats.add(rectoratConnecte);
	}

	@Override
	public void dereferencer(Rectorat rectoratDeconnecte) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.dereferencer()");
		this.rectorats.remove(rectoratDeconnecte);
	}
	
	public static void main(String[] args) {
		DbConnection.connect("Ministere");
		new MinistereImpl();
	}
}
