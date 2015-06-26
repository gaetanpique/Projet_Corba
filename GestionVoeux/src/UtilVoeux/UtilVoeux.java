package UtilVoeux;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import Etudes.EtatsVoeu;
import Etudes.Etudiant;
import Etudes.NombreMaxDeVoeuxAtteint;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.PropositionHelper;
import Etudes.Rectorat;
import Etudes.Universite;
import Etudes.UtilVoeuxPOA;
import Etudes.Voeu;
import Etudes.VoeuDejaCreeException;
import Etudes.diplomesDifferentsException;
import Util.DbConnection;
import Util.UtilConnexion;

public class UtilVoeux extends UtilVoeuxPOA {

	private ArrayList<VoeuImpl> listeVoeux = new ArrayList<VoeuImpl>();

	public UtilVoeux() throws NombreMaxDeVoeuxAtteintException, VoeuDejaCreeException  
	{
		initVoeux();
		UtilConnexion.connexionAuNammingService(this, "UtilVoeux");
		 
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant UtilVoeux référencé et opérationnel.");
			 
		// Lancement de l'ORB et mise en attente de requete
		UtilConnexion.runORB();
	}


	public void initVoeux() throws NombreMaxDeVoeuxAtteintException, VoeuDejaCreeException
	{
		Proposition p;
		String[] colonnes = new String[1];
		colonnes[0]="*";
		ResultSet resultatSQL;
			resultatSQL = DbConnection.selectIntoDB("voeux", colonnes, "");
			try {
				
				while(resultatSQL.next())
				{
						org.omg.CORBA.Object result = UtilConnexion.getObjetDistant(resultatSQL.getString(2));
						p= PropositionHelper.narrow(result);
						
						listeVoeux.add(new VoeuImpl(p,resultatSQL.getString(1),resultatSQL.getInt(3),EtatsVoeu.from_int(resultatSQL.getInt(2))));
						
				}
				
				resultatSQL.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	/**
	 * 
	 * Cette methode retourne la liste des meilleures propositions pour l'etudiant concerne
	 * Par meilleure proposition on entends, le meilleur voeu ayant été acceté, et les voeux 
	 * qui sont mieux positionnés que celui-ci
	 * @param Etudiant etudiant l'étudiant concerné
	 * @return un tableau de voeux
	 * @author Memer	 
	 * 
	 */
	@Override
	public Etudes.Voeu[] getMeilleurePropositionByEtudiant(Etudiant etudiant) 
	{
		Voeu[] listeVoeuTemp = new Voeu[5];
		int cpt=0;
		for (VoeuImpl v : listeVoeux)
		{
			if (v.etudiantCorrespondant().numEtudiant().equals(etudiant.numEtudiant()))
			{
				listeVoeuTemp[cpt] = v._this();
				cpt++;
			}
		}

		listeVoeuTemp = ordonnerListeVoeuxByPosition(listeVoeuTemp);
		
		ArrayList<Voeu> listeMeilleurVoeu = new ArrayList<Voeu>();
		cpt=0;
		for (Voeu v : listeVoeuTemp)
		{
			listeMeilleurVoeu.add(v);
			cpt++;
			//if (v.etatVoeu() == EtatsVoeu.accepte)
			if(v.classable())
			{
				break;
			}
		}
		
		listeVoeuTemp = listeMeilleurVoeu.toArray(new Voeu[listeMeilleurVoeu.size()]);
		
		return listeVoeuTemp;
	}
	
	/**
	 * Cette methode trie une arraylist de Voeux par leur position
	 * @param listeAOrdonner (assez explicite non ?)
	 * @return La liste ordonnée
	 * @author Memer
	 */
	private Voeu[] ordonnerListeVoeuxByPosition(Voeu[] listeAOrdonner)
	{
		Voeu voeuTemp;
		boolean permut = true;
		long p1, p2;

			// hypothèse : le tableau est trié
			permut=false;
			for (int i = 0 ; i < listeAOrdonner.length-2 ; i++)
			{
				for (int j =listeAOrdonner.length-1;i<j;j--)
				{
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				p1 = listeAOrdonner[j].position();
				p2 = listeAOrdonner[j-1].position();
				if (p1 < p2)
				{
					voeuTemp=listeAOrdonner[j-1];
					listeAOrdonner[j-1] = listeAOrdonner[j];
					listeAOrdonner[j] = voeuTemp;
				}
				}
			}
		

		return listeAOrdonner;
	}
	


	@Override
	public Voeu[] ordonnerListeVoeux(Voeu[] listeAOrdonner) {
		Voeu voeuTemp;
		boolean permut = true;
		boolean test;

		while (permut)
		{
			// hypothèse : le tableau est trié
			permut=false;
			for (int i = 0 ; i < listeAOrdonner.length-2 ; i++)
			{
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				try {
					test= listeAOrdonner[i].etudiantCorrespondant().estMeilleurQue(listeAOrdonner[i+1].etudiantCorrespondant());
					if (test)
					{
						voeuTemp=listeAOrdonner[i];
						listeAOrdonner[i] = listeAOrdonner[i+1];
						listeAOrdonner[i+1] = voeuTemp;
						permut=true;
					}
				} catch (diplomesDifferentsException e) {
					e.printStackTrace();
				}
			}
		}

		return listeAOrdonner;
	}

	/**
	 * Cette méthode crée un nouveau Voeu dans la "Base"
	 * 
	 * 
	 * @param La proposition et l'etudiant qui constituent le voeu
	 * @return void
	 * @throws NombreMaxDeVoeuxAtteint l'etudiant peut en avoir maximum 5 
	 * @author Merwan
	 * @throws VoeuDejaCreeException 
	 */
	@Override
	public void soumettreVoeu(Proposition aSoumettre, Etudiant soumetteur, int positionVoeu) throws NombreMaxDeVoeuxAtteintException, VoeuDejaCreeException 
	{	
		if (soumetteur.listeVoeux().length==5)
		{
			throw new NombreMaxDeVoeuxAtteintException();
		}
		else
		{
			Voeu[] temp = soumetteur.listeVoeux();
			for (Voeu v : temp) {
				String idNewVoeu = "Voeu_" + soumetteur.numEtudiant() + "_" + aSoumettre.getId();
				System.out.println("IdConstruite : "+ idNewVoeu);
				System.out.println("IdDejaDansLetudiant : "+v.getId());
				if (idNewVoeu.equals(v.getId())) {
					throw new VoeuDejaCreeException(aSoumettre.getId(),	soumetteur.numEtudiant());
				}
			}

		}

		listeVoeux.add(new VoeuImpl(aSoumettre, soumetteur.numEtudiant(),positionVoeu));

		System.out.println( "Longeur tableau etudiant apres appel constructeur Voeuimpl : " + soumetteur.listeVoeux().length);


	}

	/**
	 * Cette méthode renvoie une liste de voeux concernant un etudiant
	 * 
	 * 
	 * @param Etudiant dont on recherche les voeux
	 * @return Voeu[] La liste de voeux concernant l'etudiant
	 * @author Merwan
	 */
	@Override
	public Etudes.Voeu[] getVoeuxByEtudiant(Etudiant etudiant) {
		Voeu[] result;
		ArrayList<VoeuImpl> temp = new ArrayList<VoeuImpl>();
		for (VoeuImpl v : this.listeVoeux) 
		{
			if (v.etudiantCorrespondant().numEtudiant().equals(etudiant.numEtudiant()))
			{
				temp.add(v);
			}

		}
		
		result = new Voeu[temp.size()];
		int cpt=0;
		for (VoeuImpl v : temp)
		{
			result[cpt] = v._this();
			cpt++;
		}

		return result;
	}


	/**
	 * Cette méthode renvoie une liste de voeux concernant une universite
	 * 
	 * 
	 * @param Universite dont on recherche les voeux
	 * @return Voeu[] La liste de voeux concernant l'universite
	 * @author Merwan
	 */
	@Override
	public Voeu[] getVoeuxByUniversite(Universite _universite) 
	{
		ArrayList<Voeu> arrayVoeuxTemp = new ArrayList<Voeu>();
		System.out.println("Entrée dans la methode utilVoeux.getVoeuxByUniversite universite en parametre : " + _universite.nom());
		
		Proposition[] propositions = _universite.listeDesPropositions();
		for (VoeuImpl v : this.listeVoeux)
		{
			for (Proposition p : propositions)
			{
				if(p.getId().equals(v.propositionCorrespondante().getId()))
				{
					arrayVoeuxTemp.add(v._this());
				}
			}
		}
		
		Voeu[] result = new Voeu[arrayVoeuxTemp.size()];
		int cpt = 0;
		for (Voeu v : arrayVoeuxTemp)
		{
			result[cpt] = v;
			cpt++;
		}
		
		System.out.println("Taille de la liste de voeux récupérée : " + result.length);
		return result;
	}
	
	@Override
	public Voeu[] getVoeuxByProposition(Proposition p) {
		ArrayList<Voeu> arrayVoeuxTemp = new ArrayList<Voeu>();
		System.out.println("Entrée dans la methode utilVoeux.getVoeuxByProposition : " + p.getId());
		
		for (VoeuImpl v : this.listeVoeux)
		{
			if(p.getId().equals(v.propositionCorrespondante().getId()))
			{
				arrayVoeuxTemp.add(v._this());
			}
		}
		
		Voeu[] result = new Voeu[arrayVoeuxTemp.size()];
		int cpt = 0;
		for (Voeu v : arrayVoeuxTemp)
		{
			result[cpt] = v;
			cpt++;
		}
		
		System.out.println("Taille de la liste de voeux récupérée : " + result.length);
		return result;
	}


	/**
	 * Cette méthode permet de retourner un tableau de voeu concernant les universites d'un rectorat
	 * Elle parcourt les universite d'un rectorat pour ensuite recuperer les voeux de chacune d'elles 
	 * @param Rectorat rectoratConcerne : le rectorat en question
	 * @return Voeu[] : le tableau des voeux concernant le rectorat
	 * @author Memer
	 */
	@Override
	public Voeu[] getVoeuxByRectorat(Rectorat rectoratConcerne) 
	{
		System.out.println("Entrée dans la methode utilVoeux.getVoeuxByRectorat");
		ArrayList<Voeu> arrayVoeuxTemp = new ArrayList<Voeu>();
		
		Universite[] universites = rectoratConcerne.getListUniversites();

		for (Universite u : universites)
		{
			for (Voeu v : this.getVoeuxByUniversite(u))
			{
				arrayVoeuxTemp.add(v);
			}
		}
		
		Voeu[] result = new Voeu[arrayVoeuxTemp.size()];
		int cpt = 0;
		for (Voeu v : arrayVoeuxTemp)
		{
			result[cpt] = v;
			cpt++;
		}
		
		return result;
	}

	
	public static void main(String[] args) throws NombreMaxDeVoeuxAtteintException, VoeuDejaCreeException {
		DbConnection.connect("Voeu");
		new UtilVoeux();
	}


}
	
