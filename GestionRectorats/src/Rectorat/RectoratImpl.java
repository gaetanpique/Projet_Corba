package Rectorat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Policy;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Etudes.Etudiant;
import Etudes.EtudiantInconnuException;
import Etudes.Formation;
import Etudes.Master;
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.Proposition;
import Etudes.RectoratPOA;
import Etudes.Universite;

class RectoratImpl extends RectoratPOA {
	
	private ORB orb;
	
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
		// Intialisation de l'orb
		this.orb = org.omg.CORBA.ORB.init(new String[0], null);

		this.enregisterDansPOA();
		this.referencerAupresDuMinistere();
		
		this.orb.run();
	}
	
	private void referencerAupresDuMinistere() {
		try {
			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper
					.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent("Ministere", "");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantMinistere = nameRoot.resolve(nameToFind);

			// Casting de l'objet CORBA au type convertisseur euro
			this.ministere = MinistereHelper.narrow(distantMinistere);
			
			this.ministere.referencer(this._this());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enregisterDansPOA() {
		try {
			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			Policy[] rectoratPOAPolicies = { rootPOA.create_lifespan_policy(LifespanPolicyValue.PERSISTENT) };
			POA rectoratPOA = rootPOA.create_POA("Rectorat_POA", rootPOA.the_POAManager(), rectoratPOAPolicies);
			rectoratPOA.activate_object(this);

			// Activer le POA manager
			rectoratPOA.the_POAManager().activate();

			 // Enregistrement dans le service de nommage
			 // Recuperation du naming service 
			 NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			 // Construction du nom a enregistrer
			 org.omg.CosNaming.NameComponent[] nameToRegister = new  org.omg.CosNaming.NameComponent[1]; 
			 nameToRegister[0] = new org.omg.CosNaming.NameComponent("Rectorat_" + this.nom,"");

			 // Enregistrement de l'objet CORBA dans le service de noms
			 nameRoot.rebind(nameToRegister,rectoratPOA.servant_to_reference(this));

			 System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Rectorat_" + this.nom + " référencé et opérationnel.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cette méthode recherche l'étudiant correspondant au numéro demandé
	 * 
	 * @param String numEtudiant Le numéro de l'étudiant recherché
	 * @return Etudiant L'étudiant si il appartient à ce rectorat, null si il n'a pas été trouvé
	 * @author Gaetan
	 */
	@Override
	public Etudiant getEtudiantByNumero(String numEtudiant) {
		Etudiant result = null;
		System.out.println("TEST DE COMMIT");
		
		for (Universite u : this.universites)
		{
			result = u.getEtudiantByNumero(numEtudiant);
			if (result != null)
			{
				break;
			}
		}
		
		return result;
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
	public void demanderConnexion(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException{
		Universite univDeLetudiant = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		if (univDeLetudiant == null)
		{
			throw new EtudiantInconnuException();
		}
		else
		{
			univDeLetudiant.connecter(etudiant, motDePasse);
		}
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
	 */
	@Override
	public void demanderInscription(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException {
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
	}
	
	@Override
	public void referencer(Universite universiteConnecte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dereferencer(Universite universiteDeconnecte) {
		// TODO Auto-generated method stub
		
	}

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

	/**
	 * Cette méthode retourne toutes les propositions des universités qui dépendent de ce rectorat pour la formation demandée
	 * 
	 * @param formation Master La formation pour laquelle on veut récupérer les propositions
	 * @return Proposition[] Les propositions des universités de ce rectorat pour la formation passée en paramètre
	 * @author Gaetan
	 */
	@Override
	public Proposition[] getPropositionByFormation(Master formation) {
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

	@Override
	public String nom() {
		return this.nom;
	}

	
}
