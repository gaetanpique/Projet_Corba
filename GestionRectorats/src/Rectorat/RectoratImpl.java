package Rectorat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.EtudiantPasInscritException;
import Etudes.Formation;
<<<<<<< Upstream, based on origin/master
=======
import Etudes.FormationHelper;
import Etudes.Master;
>>>>>>> 9ec8cc6 Connexions Ã  la BDD = Done (HOPE)
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.MotDePasseErroneException;
import Etudes.Proposition;
import Etudes.RectoratPOA;
import Etudes.Universite;
import Util.DbConnection;
import Util.UtilConnexion;

public class RectoratImpl extends RectoratPOA {
	
	private ArrayList<Universite> universites = new ArrayList<Universite>();
	
	private HashMap<Universite, ArrayList<Formation>> accreditations = new HashMap<Universite, ArrayList<Formation>>();
	
	private String nom;
	
	private Ministere ministere;
	
	public static void main(String[] args) {
		new RectoratImpl(args[0]);
	}

	public RectoratImpl(String nom)
	{
		super();
		this.nom = nom;

		UtilConnexion.connexionAuNammingService(this, "Rectorat_" + this.nom);
		
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Ministere");
		this.ministere = MinistereHelper.narrow(result);

		this.ministere.referencer(this._this());
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Rectorat_" + this.nom + " référencé et opérationnel.");
		UtilConnexion.runORB();
		initFormations();
	}

	private void initFormations()
	{
		String[] colonnes = new String[1];
		colonnes[0]="intituleformation";
		ResultSet resultatSQL;
		ArrayList<Formation> arrayFormationTemp = new ArrayList<Formation>();
		for (Universite u : this.universites)
		{

			resultatSQL = DbConnection.selectIntoDB("accreditation", colonnes, "nomuniv="+u.nom().toLowerCase());
			try {
				
				while(resultatSQL.next())
				{
					org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_"+ resultatSQL.getString(0));
					arrayFormationTemp.add(FormationHelper.narrow(result));
				}
				accreditations.put(u,arrayFormationTemp);
				resultatSQL.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//-----------------GETTERS ANS SETTERS--------------------------------//
		/**
	 * Cette méthode retourne l'ensemble des universités qui dépendent de ce rectorat
	 * 
	 * @return Universite[] Un tableau des unviersités
	 * @author Gaetan
	 */
	@Override
	public Universite[] getListUniversites() {
		return this.universites.toArray(new Universite[this.universites.size()]);
	}
	
	
	/**
	 * Cette méthode retourne les formations de Master pour lesquelles l'université en question à une accréditation
	 * 
	 * Pré-condition : L'université doit dépendre de ce rectorat
	 * 
	 * @param universite Universite L'université pour lesquelles on veut les accréditations
	 * @return Formation[] La liste des accréditations
	 * @author Gaetan
	 */
	@Override
	public Formation[] getAccreditationsByUniversite(Universite universite) {
		return this.accreditations.get(universite).toArray(new Formation[this.accreditations.get(universite).size()]);
	}


	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public String getId() {
		return  "Rectorat_" + this.nom;
	}

	
	//-----------------METHODS--------------------------------//
	
	/**
	 * Cette méthode recherche l'étudiant correspondant au numéro demandé
	 * 
	 * @param String numEtudiant Le numéro de l'étudiant recherché
	 * @return Etudiant L'étudiant si il appartient à ce rectorat, null si il n'a pas été trouvé
	 * @author Gaetan
	 */
	@Override
	public Etudiant getEtudiantByNumero(String numEtudiant) throws EtudiantInconnuException {
		Etudiant result = null;

		for (Universite u : this.universites)
		{
			result = u.getEtudiantByNumero(numEtudiant);
			if (result != null)
			{
				break;
			}
		}
		
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".getEtudiantByNumero(" + numEtudiant + ") :");
		
		if (result == null)
		{
			throw new EtudiantInconnuException(numEtudiant, "");
		}
		else
		{
			return result;
		}
	}

	/**
	 * Cette méthode vérifie une demande de connexion.
	 * 
	 * Pré-conditions : L'étudiant doit être inscrit dans une université de ce rectorat
	 * 
	 * @param etudiant Etudiant L'étudiant qui éssait de se connecter
	 * @param motDePasse String Le mot de passe entré lors de la demande de connexion
	 * @throws EtudiantInconnu Si il n'est pas inscrit, ou ne dépend pas de ce rectorat
	 * @author Gaetan
	 * @throws EtudiantInconnuException 
	 */
	@Override
	public void demanderConnexion(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException, EtudiantPasInscritException, MotDePasseErroneException {
		Universite univDeLetudiant = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		if (univDeLetudiant == null)
		{
			throw new EtudiantInconnuException();
		}
		else
		{
			univDeLetudiant.connecter(etudiant, motDePasse);
		}
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".demanderConnexion() :");
	}

	/**
	 * Cette méthode traite une demande d'inscription. Vérifie dans un premier que l'étudiant n'est pas déjà inscrit,
	 * puis l'inscrit si il ne l'était pas.
	 * 
	 * Pré-conditions : L'étudiant doit avoir étudié dans une des universités de ce rectorat, et ne doit pas être inscrit
	 * 
	 * @param etudiant Etudiant L'étudiant qui essait de s'inscrire
	 * @param motDePasse String Le mot de passe qu'il a saisi
	 * @throws EtudiantInconnu Si l'étudiant ne fait pas parti de ce rectorat, ou si il est déjà inscrit
	 * @author Gaetan
	 * @throws EtudiantDejaInscritException 
	 */
	@Override
	public void demanderInscription(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException, EtudiantDejaInscritException {
		Universite univDinscription = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		//univDinscription == null <=> étudiant ne fait pas partie de ce rectorat
		if (univDinscription == null)
		{
			throw new EtudiantInconnuException();
		}
		else
		{
			try {
				univDinscription.inscrire(etudiant, motDePasse);
			} catch (EtudiantInconnuException e) {
				System.out.println("ERREUR : Etudiant n°" + e.numEtudiantInconnu + " inconnu de l'université " + e.nomUniversite);
				throw e;
			}
		}
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".demanderInscription() :");
	}
	
	@Override
	public void referencer(Universite universiteConnecte) {
		this.universites.add(universiteConnecte);
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".referencer() :");
	}

	@Override
	public void dereferencer(Universite universiteDeconnecte) {
		this.universites.remove(universiteDeconnecte);
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".dereferencer() :");
	}


	/**
	 * Cette méthode retourne toutes les propositions des universités qui dépendent de ce rectorat pour la formation demandée
	 * 
	 * @param formation Master La formation pour laquelle on veut récupérer les propositions
	 * @return Proposition[] Les propositions des universités de ce rectorat pour la formation passée en paramètre
	 * @author Gaetan
	 */
	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".getPropositionByFormation() :");
		ArrayList<Proposition> resultat = new ArrayList<Proposition>();
		Proposition temp;
		
		for (Universite u : this.universites)
		{
			temp = u.getPropositionByFormation(formation);

			if (u.getPropositionByFormation(formation) != null)
			{
				resultat.add(temp);
			}
		}
		
		return resultat.toArray(new Proposition[resultat.size()]);
	}


}
