package Universite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import Etudes.Licence;
import Etudes.LicenceHelper;
import Etudes.Proposition;
import Etudes.ResultatPOA;
import Util.DbConnection;
import Util.UtilConnexion;


public class ResultatImpl extends ResultatPOA {

	private Licence licence;
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
		
		UtilConnexion.connexionAuNammingService(this, "Result_" + numEtudiant);
		
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Licence_" + intituleLicence);
		this.licence = LicenceHelper.narrow(result);
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Result_" + numEtudiant + " référencé et opérationnel.");
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
					new ResultatImpl(resultatSQL.getString(1),resultatSQL.getFloat(3),resultatSQL.getInt(2),resultatSQL.getString(5),resultatSQL.getInt(4),resultatSQL.getString(0));
				}
				
				resultatSQL.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	
	private void initFormations()
	{

	}
	//-----------------GETTERS ANS SETTERS--------------------------------//



	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
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
	 * Cette méthode vérifie si la licence du résultat est présente 
	 * dans la liste des licences prérequises de la proposition en paramètre
	 * 
	 * @return true : licence présente dans les prérequis. false : licence non présente
	 * @author Baptiste
	 */
	public boolean isValideForProposition(Proposition proposition) {
		PropositionImpl p = (PropositionImpl)proposition;
		Licence[] liste = p.prerequis();
		for(int i = 0 ; i < liste.length ; i++){
		//comparaison par référence à vérifier
			if (liste[i] == this.getLicence())
//		//comparaison par contenu
//			if (liste[i].equals(this.getLicence()))
				return true;
		}		
		return false;
	}



}
