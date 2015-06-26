package Universite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import Etudes.EtatsVoeu;
import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.EtudiantPasInscritException;
import Etudes.Formation;
import Etudes.Licence;
import Etudes.MotDePasseErroneException;
import Etudes.Proposition;
import Etudes.PropositionDoesNotExist;
import Etudes.PropositionDoesNotExistException;
import Etudes.Rectorat;
import Etudes.RectoratHelper;
import Etudes.UniversitePOA;
import Etudes.UtilVoeux;
import Etudes.UtilVoeuxHelper;
import Etudes.Voeu;
import Etudes.formationDejaProposeeException;
import Util.DbConnection;
import Util.UtilConnexion;

public class UniversiteImpl extends UniversitePOA {

	private String nom;

	private Rectorat rectoratDappartenance;

	private ArrayList<EtudiantImpl> etudiants;

	private ArrayList<PropositionImpl> listeDesPropositions;
	
	private UtilVoeux utilVoeu;

	public static void main(String[] args) {
		DbConnection.connect(args[2]);
		new UniversiteImpl(args[0], args[1]);

	}

	public UniversiteImpl(String _nomUniversite, String _nomRectoratReference) {
		super();
		this.nom = _nomUniversite;
		this.etudiants = new ArrayList<EtudiantImpl>();
		this.listeDesPropositions = new ArrayList<PropositionImpl>();
		initEtudiants();
		initPropositions();
		// Intialisation de l'orb
		UtilConnexion.connexionAuNammingService(this, "Universite_" + this.nom);

		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Rectorat_"
				+ _nomRectoratReference);
		this.rectoratDappartenance = RectoratHelper.narrow(result);

		this.rectoratDappartenance.referencer(this._this());

		System.out.println(Calendar.getInstance().getTime().toString()
				+ " : Servant Universite_" + this.nom
				+ " référencé et opérationnel.");

		UtilConnexion.runORB();
	}

	private void initEtudiants() {
		String[] colonnes = new String[2];
		colonnes[0] = "numetudiant";
		colonnes[1] = "mdp";
		ResultSet resultatSQL;

		resultatSQL = DbConnection.selectIntoDB("etudiants", colonnes, "");
		try {
			
			while(resultatSQL.next())
			{
				new EtudiantImpl(resultatSQL.getString(1),this,resultatSQL.getString(2));
			}
			
			resultatSQL.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void initPropositions()
	{
		String[] colonnes = new String[1];
		String nomMaster;
		colonnes[0] = "*";
		ResultSet resultatSQL;
		resultatSQL = DbConnection.selectIntoDB("propositions", colonnes, "");

		try {
			while (resultatSQL.next()) {
				nomMaster = resultatSQL.getString(1).split("_")[2];
				listeDesPropositions.add(new PropositionImpl(this, nomMaster, Integer.parseInt(resultatSQL.getString(2))));
			}

			resultatSQL.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// -----------------GETTERS ANS SETTERS--------------------------------//

	@Override
	public Proposition[] listeDesPropositions() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : UniversiteImpl.getListPropositions()");
		
		Proposition[] resultat = new Proposition[this.listeDesPropositions.size()];
		int cpt = 0;
		
		for (PropositionImpl p : this.listeDesPropositions)
		{
			resultat[cpt] = p._this();
			cpt++;
		}
		return resultat;
	}

	@Override
	public void listeDesPropositions(Proposition[] value) {
		for (Proposition p : value)
		{
			this.listeDesPropositions.add((PropositionImpl) p);
		}
	}

	/**
	 * Cette méthode retourne la liste des étudiants qui ont étudié au sein de
	 * cette université
	 * 
	 * @return Etudiant[] Un tableau des étudiants
	 * @author Gaetan
	 */
	@Override
	public Etudiant[] getEtudiants() {
		Etudiant[] result = new Etudiant[this.etudiants.size()];
		int cpt=0;
		for (EtudiantImpl e : this.etudiants)
		{
			result[cpt] = e._this();
			cpt++;
		}
		
		return result;
	}

	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public String getId() {
		return "Universite_" + this.nom;
	}

	// -----------------METHODS--------------------------------//
	/**
	 * Cette méthode l'étudiant correspondant au numéro demandé. Si aucun
	 * n'étudiant de cette université ne porte ce numéro, retourne null
	 * 
	 * @param String
	 *            numEtudiant La numéro de l'étudiant recherché
	 * @return Etudiant L'étudiant recherché si il appartient à cette
	 *         université, null sinon
	 * @author Gaetan
	 */
	@Override
	public Etudiant getEtudiantByNumero(String numEtudiant) {
		System.out.println(Calendar.getInstance().getTime().toString()
				+ " : Universite_" + this.nom + ".getEtudiantByNumero("
				+ numEtudiant + ")");

		Etudiant result = null;

		for (EtudiantImpl e : this.etudiants) {
			if (e.numEtudiant().equals(numEtudiant)) {
				result = e._this();
				break;
			}
		}

		return result;
	}

	/**
	 * Cette méthode inscrit un étudiant en lui attribuant le mot de passe passé
	 * en paramètre
	 * 
	 * @param Etudiant
	 *            etudiant L'étudiant à inscrire
	 * @param String
	 *            motDePasse Le mot de passe à lui attribuer
	 * @throws EtudiantInconnu
	 *             Si l'étudiant est déjà inscrit, ou qu'il ne fait pas parti de
	 *             cette université
	 * @author Gaetan
	 */
	@Override
	public void inscrire(Etudiant etudiant, String motDePasse)
			throws EtudiantDejaInscritException, EtudiantInconnuException {
		EtudiantImpl etudiantAInscrire = null;

		for (EtudiantImpl e : this.etudiants) {
			if (e.numEtudiant().equals(etudiant.numEtudiant())) {
				etudiantAInscrire = e;
				break;
			}
		}
		if (etudiantAInscrire == null) {
			throw new EtudiantInconnuException(
					((EtudiantImpl) etudiant).numEtudiant(), this.nom);
		} else {
			etudiantAInscrire.inscrireEtudiant(motDePasse);
		}
	}

	/**
	 * Cette méthode connecte un étudiant. Elle vérifie le mot de passe passé en
	 * paramètre
	 * 
	 * @param Etudiant
	 *            etudiant L'étudiant à connecter
	 * @param String
	 *            motDePasse Le mot de passe saisit lors de la tentative
	 *            d'inscription
	 * @throws EtudiantInconnu
	 *             Si le mot de passe est incorrect, ou que l'étudiant ne fait
	 *             pas parti de cette université
	 * @author Gaetan
	 */
	@Override
	public void connecter(Etudiant etudiant, String motDePasse)
			throws EtudiantInconnuException, EtudiantPasInscritException,
			MotDePasseErroneException {
		EtudiantImpl etudiantAConnecter = null;

		for (EtudiantImpl e : this.etudiants) {
			if (e.numEtudiant().equals(etudiant.numEtudiant())) {
				etudiantAConnecter = e;
				break;
			}
		}

		if (etudiantAConnecter == null) {
			throw new EtudiantInconnuException(etudiant.numEtudiant(), this.nom);
		} else {
			if (etudiantAConnecter.getMotDePasse() == null) {
				throw new EtudiantPasInscritException(etudiant.numEtudiant());
			} else {
				if (!etudiantAConnecter.getMotDePasse().equals(motDePasse)) {
					throw new MotDePasseErroneException(etudiant.numEtudiant());
				}
			}
		}
	}

	/**
	 * Cette méthode retourne la proposition de formation faite par l'université
	 * pour le master demandé
	 * 
	 * @param formation
	 *            Master Le master pour lequel on cherche une proposition
	 * @return Proposition La proposition correspondant au master demandé, null
	 *         si il n'est pas proposé
	 * @author Gaetan
	 */
	@Override
	public Proposition getPropositionByFormation(Formation formation) {
		System.out.println(Calendar.getInstance().getTime().toString()
				+ " : Universite_" + this.nom + ".getPropositionByFormation()");
		for (PropositionImpl p : this.listeDesPropositions) {
			if (p.masterPropose().intitule().equals(formation.intitule())) {
				return p._this();
			}
		}

		return null;
	}

	/**
	 * Retourne la ou les licences prérequises si le master est proposé par
	 * cette université
	 * 
	 * Pré-condition : L'université doit proposé ce Master
	 * 
	 * @param formation
	 *            Master Le master pour lequel on demande les prérequis
	 * @return Licence[] La liste des licences prérequise pour postuler
	 * @author Gaetan
	 * @throws PropositionDoesNotExist
	 */
	@Override
	public Formation[] getPrerequis(Proposition p)
			throws PropositionDoesNotExistException {
		PropositionImpl proposition = (PropositionImpl) p;

		if (proposition == null) {
			throw new PropositionDoesNotExistException(p.masterPropose());
		} else {
			return proposition.prerequis();
		}
	}

	/**
	 * Effectue une proposition de formation
	 * 
	 * @param nouvelleFormation
	 *            Master Le master proposé
	 * @param prerequis
	 *            Licence[] L'ensemeble des formations prérequisent
	 * @param universite
	 *            Universite l'universite de la proposition
	 * @author Thibaut
	 */
	@Override
	public void creerProposition(String intituleMaster, Licence[] prerequis)
			throws formationDejaProposeeException {

		// test si la formation existe deja
		for (PropositionImpl p : this.listeDesPropositions) {
			if (p.masterPropose().intitule().equals(intituleMaster)) {
				throw new formationDejaProposeeException();
			} else {
				// crée un nouvelle proposition de formation
				this.listeDesPropositions.add(new PropositionImpl(prerequis,
						this, intituleMaster));
			}
		}
	}

	/**
	 * Effectue une proposition de formation
	 * 
	 * @param proposition
	 *            Proposition Le master de la proposition
	 * @param nouveauxPrerequis
	 *            Licence[] La nouvelle liste de prérequis
	 * @author Thibaut
	 */
	@Override
	public void majPrerequis(Proposition proposition,
			Licence[] nouveauxPrerequis)
			throws PropositionDoesNotExistException {
		// test si la formation existe deja
		PropositionImpl p = (PropositionImpl) proposition;

		if (p == null) {
			throw new PropositionDoesNotExistException();
		} else {
			p.prerequis(nouveauxPrerequis);
		}

	}

	/**
	 * Cette méthode permet de classer tous les voeux associés à une proposition particulière
	 * @param Proposition p : La proposition en question
	 * @return void
	 * @author Memer
	 */
	@Override
	public void classerVoeux()
	{
		System.out.println(Calendar.getInstance().getTime().toString() + " : Universite_" + this.nom + ".classerVoeux()");
		Voeu[] voeux;
		ArrayList<Voeu> voeuTemp = new ArrayList<Voeu>();
		Voeu[] voeuxClassables;
		for (PropositionImpl p : this.listeDesPropositions)
		{
			voeux = this.getUtilVoeux().getVoeuxByProposition(p._this());
			for (Voeu v : voeux)
			{
				if (v.classable())
				{
					voeuTemp.add(v);
				}
			}
			
			voeuxClassables = voeuTemp.toArray(new Voeu[voeuTemp.size()]);
			voeuxClassables = this.getUtilVoeux().ordonnerListeVoeux(voeuxClassables);
			
			//Parcours de l'arrayList triée pour donner le classement du voeu égale à son index+1
			for (int i = 0 ; i < voeuxClassables.length ; i++)
			{
				System.out.println("Nb places : " + p.nbPlaces());
				if ( i+1 < p.nbPlaces())
				{
					voeuxClassables[i].etatVoeu(EtatsVoeu.accepte);
					System.out.println("Voeu " + voeuxClassables[i].getId() + " accepté.");
				}
				else
				{
					voeuxClassables[i].etatVoeu(EtatsVoeu.enAttente);
					System.out.println("Voeu " + voeuxClassables[i].getId() + " en attente.");
				}
			}
		}
	}
	
	private UtilVoeux getUtilVoeux()
	{
		if (this.utilVoeu == null) {
			org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("UtilVoeux");
			this.utilVoeu = UtilVoeuxHelper.narrow(result);
		}
		
		return this.utilVoeu;
	}

	public void referencer(EtudiantImpl etudiantAAjouter) {
		this.etudiants.add(etudiantAAjouter);
		System.out.println(Calendar.getInstance().getTime().toString()
				+ " : Universite_ " + this.nom + ".referencer(EtudiantImpl) :");

	}
	

}
