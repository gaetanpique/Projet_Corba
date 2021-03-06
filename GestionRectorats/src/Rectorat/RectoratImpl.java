package Rectorat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import Etudes.EtatsVoeu;
import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantInconnu;
import Etudes.EtudiantInconnuException;
import Etudes.EtudiantPasInscritException;
import Etudes.Formation;
import Etudes.FormationHelper;
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.MotDePasseErroneException;
import Etudes.Proposition;
import Etudes.RectoratPOA;
import Etudes.Universite;
import Etudes.UtilVoeux;
import Etudes.UtilVoeuxHelper;
import Etudes.Voeu;
import Util.DbConnection;
import Util.UtilConnexion;

public class RectoratImpl extends RectoratPOA {
	
	private ArrayList<Universite> universites = new ArrayList<Universite>();
	
	private HashMap<Universite, ArrayList<Formation>> accreditations = new HashMap<Universite, ArrayList<Formation>>();
	
	private String nom;
	
	private Ministere ministere;
	
	public static void main(String[] args) {
		DbConnection.connect(args[1]);
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
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Rectorat_" + this.nom + " r�f�renc� et op�rationnel.");
		UtilConnexion.runORB();
	}

	//-----------------GETTERS ANS SETTERS--------------------------------//
		/**
	 * Cette m�thode retourne l'ensemble des universit�s qui d�pendent de ce rectorat
	 * 
	 * @return Universite[] Un tableau des unviersit�s
	 * @author Gaetan
	 */
	@Override
	public Universite[] getListUniversites() {
		return this.universites.toArray(new Universite[this.universites.size()]);
	}
	
	
	/**
	 * Cette m�thode retourne les formations de Master pour lesquelles l'universit� en question � une accr�ditation
	 * 
	 * Pr�-condition : L'universit� doit d�pendre de ce rectorat
	 * 
	 * @param universite Universite L'universit� pour lesquelles on veut les accr�ditations
	 * @return Formation[] La liste des accr�ditations
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
	 * Cette m�thode recherche l'�tudiant correspondant au num�ro demand�
	 * 
	 * @param String numEtudiant Le num�ro de l'�tudiant recherch�
	 * @return Etudiant L'�tudiant si il appartient � ce rectorat, null si il n'a pas �t� trouv�
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
	 * Cette m�thode v�rifie une demande de connexion.
	 * 
	 * Pr�-conditions : L'�tudiant doit �tre inscrit dans une universit� de ce rectorat
	 * 
	 * @param etudiant Etudiant L'�tudiant qui �ssait de se connecter
	 * @param motDePasse String Le mot de passe entr� lors de la demande de connexion
	 * @throws EtudiantInconnu Si il n'est pas inscrit, ou ne d�pend pas de ce rectorat
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
	 * Cette m�thode traite une demande d'inscription. V�rifie dans un premier que l'�tudiant n'est pas d�j� inscrit,
	 * puis l'inscrit si il ne l'�tait pas.
	 * 
	 * Pr�-conditions : L'�tudiant doit avoir �tudi� dans une des universit�s de ce rectorat, et ne doit pas �tre inscrit
	 * 
	 * @param etudiant Etudiant L'�tudiant qui essait de s'inscrire
	 * @param motDePasse String Le mot de passe qu'il a saisi
	 * @throws EtudiantInconnu Si l'�tudiant ne fait pas parti de ce rectorat, ou si il est d�j� inscrit
	 * @author Gaetan
	 * @throws EtudiantDejaInscritException 
	 */
	@Override
	public void demanderInscription(Etudiant etudiant, String motDePasse) throws EtudiantInconnuException, EtudiantDejaInscritException {
		Universite univDinscription = this.universites.get(this.universites.indexOf(etudiant.getUniversite()));
		
		//univDinscription == null <=> �tudiant ne fait pas partie de ce rectorat
		if (univDinscription == null)
		{
			throw new EtudiantInconnuException();
		}
		else
		{
			try {
				univDinscription.inscrire(etudiant, motDePasse);
			} catch (EtudiantInconnuException e) {
				System.out.println("ERREUR : Etudiant n�" + e.numEtudiantInconnu + " inconnu de l'universit� " + e.nomUniversite);
				throw e;
			}
		}
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".demanderInscription() :");
	}
	
	@Override
	public void referencer(Universite universiteConnecte) {
		this.universites.add(universiteConnecte);
		
		String[] colonnes = new String[1];
		colonnes[0]="intituleformation";
		ResultSet resultatSQL;
		ArrayList<Formation> arrayFormationTemp = new ArrayList<Formation>();

		resultatSQL = DbConnection.selectIntoDB("accreditations", colonnes, "nomuniv='"+universiteConnecte.nom().toLowerCase()+"'");
		try {
			
			while(resultatSQL.next())
			{
				org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Formation_"+ resultatSQL.getString(1));
				arrayFormationTemp.add(FormationHelper.narrow(result));
				System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".accrediationRecup�r�e : " + arrayFormationTemp.get(arrayFormationTemp.size()-1).intitule());
			}
			accreditations.put(universiteConnecte,arrayFormationTemp);
			resultatSQL.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".referencer() :");
	}

	@Override
	public void dereferencer(Universite universiteDeconnecte) {
		this.universites.remove(universiteDeconnecte);
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".dereferencer() :");
	}


	/**
	 * Cette m�thode retourne toutes les propositions des universit�s qui d�pendent de ce rectorat pour la formation demand�e
	 * 
	 * @param formation Master La formation pour laquelle on veut r�cup�rer les propositions
	 * @return Proposition[] Les propositions des universit�s de ce rectorat pour la formation pass�e en param�tre
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

	@Override
	public void validerCandidatures()
	{
		System.out.println(Calendar.getInstance().getTime().toString() + " : Rectorat_ " + this.nom + ".validerCondidatures() :");
		Voeu[] voeux = this.getUtilVoeux().getVoeuxByRectorat(this._this());
		
		for (Voeu v : voeux)
		{
			if (v.etudiantCorrespondant().ResultatsValideForProposition(v.propositionCorrespondante()))
			{
				v.modifierEtatVoeu(EtatsVoeu.valide);
				System.out.println("VALIDE");
			}
			else
			{
				v.modifierEtatVoeu(EtatsVoeu.nonValide);
				System.out.println("-");
			}
		}
	}
	
	public UtilVoeux getUtilVoeux()
	{
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("UtilVoeux");
		return UtilVoeuxHelper.narrow(result);
	}

}
