package Rectorat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.omg.CORBA.ORB;

import Etudes.Etudiant;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.Formation;
import Etudes.Master;
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.Proposition;
import Etudes.RectoratPOA;
import Etudes.Universite;
import Util.UtilConnexion;

class RectoratImpl extends RectoratPOA {
	
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

		ORB orb = UtilConnexion.connexionAuNammingService(this, "Rectorat_" + this.nom);
		
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Ministere");
		this.ministere = MinistereHelper.narrow(result);

		this.ministere.referencer(this._this());
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Rectorat_" + this.nom + " référencé et opérationnel.");
		orb.run();
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
		
		for (Universite u : this.universites)
		{
			result = u.getEtudiantByNumero(numEtudiant);
			if (result != null)
			{
				break;
			}
		}
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".getEtudiantByNumero(" + numEtudiant + ") :");
		
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
