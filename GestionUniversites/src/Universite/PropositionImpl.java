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
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les
	 * pr�requis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(UniversiteImpl u, String intituleMaster) {
		try {
			initLicences();
			this.universiteProposante = u;
			// Intialisation de l'orb
			UtilConnexion.connexionAuNammingService(this,
					"Proposition_" + u.nom() + "_" + intituleMaster);

			org.omg.CORBA.Object result = UtilConnexion
					.getObjetDistant("Master_" + intituleMaster);
			this.masterPropose = MasterHelper.narrow(result);

			System.out.println(Calendar.getInstance().getTime().toString()
					+ " : Servant Proposition_" + u.nom() + "_"
					+ intituleMaster + " r�f�renc� et op�rationnel.");

			insertIntoDB();
			System.out.println("EtudiantImpl : Insertion dans BD OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PropositionImpl(Licence[] prerequis, UniversiteImpl u,
			String intituleMaster) {
		try {
			prerequis(prerequis);
			this.universiteProposante = u;
			// Intialisation de l'orb
			UtilConnexion.connexionAuNammingService(this,
					"Proposition_" + u.nom() + "_" + intituleMaster);

			org.omg.CORBA.Object result = UtilConnexion
					.getObjetDistant("Master_" + intituleMaster);
			this.masterPropose = MasterHelper.narrow(result);

			System.out.println(Calendar.getInstance().getTime().toString()
					+ " : Servant Proposition_" + u.nom() + "_"
					+ intituleMaster + " r�f�renc� et op�rationnel.");

			insertIntoDB();
			System.out.println("PropositionImpl : Insertion dans BD OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initLicences() {
		String[] colonnes = new String[1];
		colonnes[0] = "intitulelicence";
		ResultSet resultatSQL;
		resultatSQL = DbConnection.selectIntoDB("prerequis", colonnes,
				"idproposition=" + this.getId());
		try {

			while (resultatSQL.next()) {
				org.omg.CORBA.Object result = UtilConnexion
						.getObjetDistant("Formation_"
								+ resultatSQL.getString(0));
				this.prerequis.add((Licence) FormationHelper.narrow(result));
			}

			resultatSQL.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	// -----------------GETTERS ANS SETTERS--------------------------------//

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
		return "Proposition_" + universiteProposante.nom() + "_"
				+ masterPropose.intitule();
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
	 * Ajoute une licence � la liste des pr�requis d'une proposition
	 * 
	 * @exception prerequisDejaExiistantException
	 *                : la licence en param�tre est d�j� pr�sente dans la liste
	 * @author Baptiste
	 */
	/*
	 * @Override public void addPrerequis(Licence l) throws
	 * prerequisDejaExistantException{ if(prerequis.contains(l)) { throw new
	 * prerequisDejaExistantException((Proposition) this); } else {
	 * prerequis.add(l); }
	 * 
	 * }
	 */

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
