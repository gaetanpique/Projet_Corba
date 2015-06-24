package Universite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import Etudes.Formation;
import Etudes.FormationHelper;
import Etudes.Licence;
import Etudes.MasterHelper;
import Etudes.PropositionPOA;
import Etudes.Universite;
import Etudes.UniversiteHelper;
import Util.DbConnection;
import Util.UtilConnexion;
import Util.UtilTraitements;

public class PropositionImpl extends PropositionPOA {
	
	private ArrayList<Formation> prerequis = new ArrayList<Formation>(); 
	private Formation masterPropose;
	private int nbPlaces;
	private UniversiteImpl universiteProposante;
	/**
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les
	 * prérequis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(UniversiteImpl u, String intituleMaster){
		this.universiteProposante= u;
		// Intialisation de l'orb

				
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_" + intituleMaster);
		this.masterPropose = FormationHelper.narrow(result);
		
		UtilConnexion.connexionAuNammingService(this, this.getId());
		initLicences();
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Proposition_" + u.nom() + "_" + intituleMaster + " référencé et opérationnel.");
	}

	public PropositionImpl(Licence[] prerequis, UniversiteImpl u, String intituleMaster) {
		try {
			prerequis(prerequis);
			this.universiteProposante = u;
			// Intialisation de l'orb
			UtilConnexion.connexionAuNammingService(this, "Proposition_" + u.nom() + "_" + intituleMaster);

			org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_" + intituleMaster);
			this.masterPropose = FormationHelper.narrow(result);

			System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Proposition_" + u.nom() + "_" + intituleMaster + " référencé et opérationnel.");

			insertIntoDB();
			System.out.println("PropositionImpl : Insertion dans BD OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initLicences() 
	{
		String[] colonnes = new String[1];
		colonnes[0]="intitulelicence";
		ResultSet resultatSQL;
			resultatSQL = DbConnection.selectIntoDB("prerequis", colonnes, "idproposition='"+this.getId()+"'");
			try {
				
				while(resultatSQL.next())
				{
					org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_" +resultatSQL.getString(1));
					this.prerequis.add(FormationHelper.narrow(result));
				}
				
				resultatSQL.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}


	// -----------------GETTERS ANS SETTERS--------------------------------//

	@Override
	public Formation masterPropose() {
		return masterPropose;
	}

	@Override
	public Licence[] prerequis() {
		return prerequis.toArray(new Licence[prerequis.size()]);
	}

	@Override
	public void prerequis(Licence[] value) {
		prerequis.clear();
		DbConnection.deleteIntoDB("prerequis", "idproposition = '" + getId()
				+ "'");
		// prerequis.addAll((Collection<? extends Licence>) UtilTraitements
		// .ToArray(value));
		for (Licence l : value) {
			prerequis.add(l);
			insertPrerequisIntoDB(getId(), l.intitule());
			System.out.println("Prerequis : Insertion dans BD OK");
		}
	}

	@Override
	public String getId() {
		return "p_" + universiteProposante.nom() + "_" + masterPropose.intitule();
	}

	@Override
	public int nbPlaces() {
		return this.nbPlaces;
	}

	@Override
	public Universite proposant() {
		return this.universiteProposante._this();
	}

	public void insertIntoDB() {
		String[] colonnes = new String[2];
		String[] valeurs = new String[2];

		colonnes[0] = "idproposition";
		colonnes[1] = "nbplaces";

		valeurs[0] = this.getId();
		valeurs[1] = String.valueOf(this.nbPlaces());

		DbConnection.insertIntoDB("etudiants", colonnes, valeurs);

	}

	private void insertPrerequisIntoDB(String id_prop, String intituleLicence) {
		String[] colonnes = new String[2];
		String[] valeurs = new String[2];

		colonnes[0] = "intitulelicence";
		colonnes[1] = "idproposition";

		valeurs[0] = intituleLicence;
		valeurs[1] = id_prop;

		DbConnection.insertIntoDB("etudiants", colonnes, valeurs);
	}
}
