package Universite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import Etudes.Formation;
import Etudes.FormationHelper;
import Etudes.Proposition;
import Etudes.ResultatPOA;
import Util.DbConnection;
import Util.UtilConnexion;


public class ResultatImpl extends ResultatPOA {

	private Formation licence;
	private float moyenne;
	private String codeObtention;
	private int position;
	private int numSemestre;
	
	public ResultatImpl()
	{
		
	}
	
	public ResultatImpl(String intituleLicence, float m,int n, String c, int p, String numEtudiant){
		this.moyenne = m;
		this.codeObtention = c;
		this.position = p;
		this.numSemestre = n ;
		
		UtilConnexion.connexionAuNammingService(this, "Result_" + numEtudiant+"_"+numSemestre);
		
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_" + intituleLicence);
		this.licence = FormationHelper.narrow(result);
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Result_" + numEtudiant + " r�f�renc� et op�rationnel.");
	}
		
	public ResultatImpl(String numEtudiant,int numS) 
	{
		String[] colonnes = new String[1];
		colonnes[0]="*";
		ResultSet resultatSQL;

			resultatSQL = DbConnection.selectIntoDB("resultats", colonnes, "numetudiant="+numEtudiant.toLowerCase()+"AND numsemestre="+numS);
			try {
				
				while(resultatSQL.next())
				{		
					new ResultatImpl(resultatSQL.getString(2).toLowerCase(),resultatSQL.getFloat(4),resultatSQL.getInt(3),resultatSQL.getString(6).toLowerCase(),resultatSQL.getInt(5),resultatSQL.getString(1).toLowerCase());
				}
				
				resultatSQL.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	
	//-----------------GETTERS ANS SETTERS--------------------------------//



	public Formation getLicence() {
		return licence;
	}

	public void setLicence(Formation licence) {
		this.licence = licence;
	}

	@Override
	public String codeObtention() {
		return codeObtention;
	}

	@Override
	public float moyenne() {
		return moyenne;
	}
	
	@Override
	public int position() {
		return position;
	}

	//-----------------METHODS--------------------------------//

	/**
	 * Cette m�thode v�rifie si la licence du r�sultat est pr�sente 
	 * dans la liste des licences pr�requises de la proposition en param�tre
	 * 
	 * @return true : licence pr�sente dans les pr�requis. false : licence non pr�sente
	 * @author Baptiste
	 */
	public boolean isValideForProposition(Proposition proposition) {
		System.out.println("Entr�e dans la methode resultatImpl.isValideForPropositon : " + proposition.getId() + " ; " + this.licence.intitule());
		
		Formation[] liste = proposition.prerequis();
		for(Formation f : liste) {
			if (f.intitule().equals(this.getLicence().intitule()))
			{
				System.out.println("TRUE");
				return true;
			}
		}		
		System.out.println("FALSE");
		//Aucun pr�requis ne correspond � sa formation
		return false;
	}

}
