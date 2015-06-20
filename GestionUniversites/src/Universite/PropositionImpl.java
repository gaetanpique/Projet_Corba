package Universite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import Etudes.FormationHelper;
import Etudes.Licence;
import Etudes.LicenceHelper;
import Etudes.Master;
import Etudes.MasterHelper;
import Etudes.PropositionPOA;
import Etudes.Universite;

import Etudes.UniversiteHelper;
import Util.DbConnection;
import Util.UtilConnexion;
import Util.UtilTraitements;

public class PropositionImpl extends PropositionPOA {
	
	private ArrayList<Licence> prerequis = new ArrayList<Licence>(); 
	private Master masterPropose;
	private int nbPlaces;
	private UniversiteImpl universiteProposante;
	/**
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les prérequis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(UniversiteImpl u, String intituleMaster){
		initLicences();
		this.universiteProposante= u;
		// Intialisation de l'orb
		UtilConnexion.connexionAuNammingService(this, "Proposition_" + u.nom() + "_" + intituleMaster);
				
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Master_" + intituleMaster);
		this.masterPropose = MasterHelper.narrow(result);
	
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Proposition_" + u.nom() + "_" + intituleMaster + " référencé et opérationnel.");
	}
		
	public PropositionImpl(Licence[] prerequis, UniversiteImpl u,String intituleMaster) 
	{
		prerequis(prerequis);
		this.universiteProposante = u;
		// Intialisation de l'orb
		UtilConnexion.connexionAuNammingService(this, "Proposition_" + u.nom() + "_" + intituleMaster);
				
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Master_" + intituleMaster);
		this.masterPropose = MasterHelper.narrow(result);
	
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Proposition_" + u.nom() + "_" + intituleMaster + " référencé et opérationnel.");
	
	}

	public void initLicences() 
	{
		String[] colonnes = new String[1];
		colonnes[0]="intitulelicence";
		ResultSet resultatSQL;
			resultatSQL = DbConnection.selectIntoDB("prerequis", colonnes, "idproposition="+this.getId());
			try {
				
				while(resultatSQL.next())
				{
					org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_" +resultatSQL.getString(0));
					this.prerequis.add((Licence)FormationHelper.narrow(result));
				}
				
				resultatSQL.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	
	//-----------------GETTERS ANS SETTERS--------------------------------//

	@Override
	public Master masterPropose() {
		return masterPropose;
	}
	
	@Override
	public Licence[] prerequis() {
		return prerequis.toArray(new Licence[prerequis.size()]);
	}
	
	@Override
	public void prerequis(Licence[] value) {
		prerequis.clear();
		prerequis.addAll((Collection<? extends Licence>) UtilTraitements.ToArray(value));		
	}

	@Override
	public String getId() {
		return "Proposition_" + universiteProposante.nom() + "_" + masterPropose.intitule();
	}
	
	@Override
	public int nbPlaces() {
		return this.nbPlaces;
	}
	@Override
	public Universite proposant() {
		return this.universiteProposante._this();
	}

	/**
	 * Ajoute une licence à la liste des prérequis d'une proposition
	 * 
	 * @exception prerequisDejaExiistantException : la licence en paramètre est déjà présente dans la liste
	 * @author Baptiste
	 */
/*	@Override
	public void addPrerequis(Licence l) throws prerequisDejaExistantException{
		if(prerequis.contains(l))
		{
			throw new prerequisDejaExistantException((Proposition) this);
		}
		else
		{
			prerequis.add(l);
		}
		
	}*/

}

