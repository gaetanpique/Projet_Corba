package Universite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantPOA;
import Etudes.Proposition;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.Voeu;
import Util.DbConnection;
import Util.UtilConnexion;

public class EtudiantImpl extends EtudiantPOA {

	private String numero;
	private String motDePasse;
	private ArrayList<ResultatImpl> resultats;
	private UniversiteImpl universite;
	private ArrayList<Voeu> listeVoeux;

	public EtudiantImpl(String numE, ArrayList<ResultatImpl> resE,
			UniversiteImpl univE) {
		this(numE, univE, null);
	}

	public EtudiantImpl(String numE, UniversiteImpl univE, String motDePasse) {
		try {
			this.numero = numE;
			this.universite = univE;
			this.motDePasse = motDePasse;
			this.listeVoeux = new ArrayList<Voeu>();
			this.resultats = new ArrayList<ResultatImpl>();
			initResultats();

			UtilConnexion.connexionAuNammingService(this, "Etu_" + this.numero);

			this.universite.referencer(this);

			System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Etudiant_" + this.numero + " référencé et opérationnel.");

			//insertIntoDB();
			//System.out.println("EtudiantImpl : Insertion dans BD OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initResultats()
	{
		String[] colonnes = new String[1];
		colonnes[0]="*";
		ResultSet resultatSQL;
			resultatSQL = DbConnection.selectIntoDB("resultats", colonnes, "numetudiant='"+this.numero+"'");
			try {
				
				while(resultatSQL.next())
				{
					this.resultats.add(new ResultatImpl(resultatSQL.getString(2).toLowerCase(), resultatSQL.getFloat(4), resultatSQL.getInt(3), resultatSQL.getString(6).toLowerCase(), resultatSQL.getInt(5), resultatSQL.getString(1).toLowerCase()));
				}
				
				resultatSQL.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	// -----------------GETTERS ANS SETTERS--------------------------------//
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public Voeu[] listeVoeux() {
		Voeu[] result = new Voeu[this.listeVoeux.size()];
		int cpt=0;
		
		for (Voeu v : this.listeVoeux)
		{
			result[cpt] = v;
			cpt++;
		}
		
		return result;
	}

	public Resultat[] resultats() {
		Resultat[] resultat = new Resultat[resultats.size()];
		int cpt = 0;
		for (ResultatImpl r : resultats) {
			resultat[cpt] = r._this();
			cpt++;
		}
		return resultat;
	}

	@Override
	public Universite getUniversite() {
		System.out.println(Calendar.getInstance().getTime().toString()
				+ " : Etudiant_" + this.numero + ".getUniversite()");
		return universite._this();
	}

	@Override
	public String numEtudiant() {
		return this.numero;
	}

	// -----------------METHODS--------------------------------//
	/**
	 * Compare la moyenne des semestres de deux étudiants. En cas d'égalité, on
	 * compare leur position au dernier semestre
	 * 
	 * @return false si l'étudiant en paramètre est meilleur, true sinon
	 * @author BAPeTISTE
	 */
	@Override
	public boolean estMeilleurQue(Etudiant aComparer) {
		Etudiant e = aComparer;
		float moy1 = this.getMoyenneLicenceEtudiant();
		float moy2 = e.getMoyenneLicenceEtudiant();

		// si moyennes égales, on compare la position da l'élève dans la
		// promotion
		if (moy1 == moy2) {
			return (this.resultats()[this.resultats().length - 1].position() > e
					.resultats()[this.resultats().length - 1].position());
		} else
			return (moy1 > moy2);
	}

	/**
	 * Calcule la moyenne de tous les semestres d'un étudiant (les résultats
	 * contenus dans la liste "resultats"
	 * 
	 * @return float représentant la moyenne des semestre
	 * @author BAPeTISTE
	 */
	public float getMoyenneLicenceEtudiant() {
		float moy = 0;
		for (ResultatImpl r : this.resultats) {
			moy += r.moyenne();
		}
		return (moy / this.resultats.size());
	}

	/**
	 * Cette méthode initialise le mot de passe d'un étudiant entré en paramètre
	 * prérequis : le mdp doit être null
	 * 
	 * @exception EtudiantDejaInscritException
	 *                : étudiant déjà inscrit
	 * @author Baptiste
	 */
	public void inscrireEtudiant(String mdp)
			throws EtudiantDejaInscritException {
		if (this.motDePasse != null)
			throw new EtudiantDejaInscritException(this.numero);
		else
			this.motDePasse = mdp;
	}

	/**
	 * Cette méthode vérifie si un résultat est valide pour une formation
	 * donnée.
	 * 
	 * 
	 * @return validité du résultat.
	 * @author Baptiste
	 */
	@Override
	public boolean ResultatsValideForProposition(Proposition p) {
		// Résultat est dans le même projet donc on appelle la méthode en local
		System.out.println("Entrée dans la méthode Etudiant.ResultatValideForProposition avec la proposition : "+p.getId());
		ResultatImpl r = resultats.get(0);

		return r.isValideForProposition(p);
	}

	/**
	 * Ajoute un voeu à la lite des voeux de l'étudiant (listeVoeux)
	 * 
	 * @author BAPeTISTE
	 */
	@Override
	public void addVoeuEtudiant(Voeu v)  {
		this.listeVoeux.add(v);
	}

	public void insertIntoDB() {
		String[] colonnes = new String[2];
		String[] valeurs = new String[2];

		colonnes[0] = "numetudiant";
		colonnes[1] = "mdp";

		valeurs[0] = this.numEtudiant();
		valeurs[1] = this.motDePasse;

		DbConnection.insertIntoDB("etudiants", colonnes, valeurs);

	}

}
