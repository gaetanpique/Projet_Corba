import Etudes.Etudiant;
import Etudes.Formation;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.Rectorat;
import Etudes.Universite;
import Etudes.UtilVoeuxHelper;
import Etudes.Voeu;
import Etudes.VoeuDejaCreeException;
import Util.UtilConnexion;


public class TestPostuler {
	
	private MainTest main;
	
	private Formation formationChoisie;
	
	private Proposition propositionChoisie;
	
	
	
	public TestPostuler(MainTest main)
	{
		this.main = main;
		this.testerRecupererListeFormations(0);
		this.testerRecupererUniversitesQuiProposentLaFormation(formationChoisie);
		this.testerRecupererUtilitaireVoeu();
		this.testerSoumettreTousVoeux();
		this.testerSoumettreNbMaxAtteint();
	}
	
	public void testerRecupererListeFormations(int i)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerRecupererListeFormations ");
		System.out.println("- Récupération de la liste des formations DEBUT ");
		main.formationsExistentes = main.ministere.getListFormations();
		
		for (Formation f : main.formationsExistentes)
		{
			System.out.println("- Formation : " + f.intitule());
		}
		this.formationChoisie = main.formationsExistentes[i];
		System.out.println("- Récupération de la liste des formations FIN ");
		System.out.println("- Choisi : " + formationChoisie.intitule());
	}
	
	public void testerRecupererUniversitesQuiProposentLaFormation(Formation f)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerRecupererUniversitesQuiProposentLaFormation ");
		System.out.println("- Récupération de la liste des universités qui proposent la formation : " + f.intitule() + " DEBUT ");
		Proposition[] propositions = main.ministere.getPropositionByFormation(f);
		System.out.println("- Nb propositions : " + propositions.length);
		for (Proposition p : propositions)
		{
			//System.out.println("- Propostion : " + p.proposant().nom() + "_" + p.masterPropose().intitule());
			System.out.println("- Propostion : " + p.getId());
		}
		this.propositionChoisie = propositions[0];
		System.out.println("- Récupération de la liste des propositions FIN ");
		System.out.println("- Choisi : " + propositionChoisie.proposant().nom() + "_" + propositionChoisie.masterPropose().intitule());
	}
	
	public void testerRecupererUtilitaireVoeu()
	{
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("UtilVoeux");

		System.out.println("Recuperation de l'utilitaire de voeux");
		this.main.utilVoeux = UtilVoeuxHelper.narrow(result);

	}
	
	public void testerSoumettreTousVoeux()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerSoumettreTousVoeux ");
		System.out.println("- DEBUT ");
		
		int numProp;
		
		try {
			this.getAllEtudiants();
			this.getAllPropositions();
			
			int cptEtudiant = 0;
			int cptVoeux = 0;
			
			for (Etudiant e : this.main.allEtudiants)
			{
				cptEtudiant++;
				Voeu[] voeux = this.main.utilVoeux.getVoeuxByEtudiant(e);
				System.out.println("Etat initial des voeux de l'étudiant " + e.numEtudiant() + " : " + voeux.length);
				while (voeux.length < 5)
				{
					try {
						numProp = (int)(Math.random() * ((this.main.allPropositions.size() - 0)));
						System.out.println("Etudiant demandant : " + e.numEtudiant() + " ; NumProp : " + numProp + " ; Proposition demandée : " + this.main.allPropositions.get(numProp).getId());
						this.main.utilVoeux.soumettreVoeu(this.main.allPropositions.get(numProp), e, this.main.utilVoeux.getVoeuxByEtudiant(e).length+1);
						cptVoeux++;
					} catch (VoeuDejaCreeException e1) {
						//On catch des voeux déjà créés puisque choisis aléatoirements
					}
					
					voeux = this.main.utilVoeux.getVoeuxByEtudiant(e);
				}
			}
			
			System.out.println("- FIN : OK - Nb Etudiants : " + cptEtudiant + " ; NbVoeuxCréés : " + cptVoeux);
		} catch (NombreMaxDeVoeuxAtteintException e) {
			System.out.println("- ERREUR : NombreMaxDeVoeuxAtteintException");
		}
	}
	
	private void getAllEtudiants()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- getAllEtudiants ");
		System.out.println("- DEBUT ");
		Rectorat[] rectorats = this.main.ministere.getListRectorats();
		for (Rectorat r : rectorats)
		{
			Universite[] universites = r.getListUniversites();
			for (Universite u : universites)
			{
				Etudiant[] etudiants = u.getEtudiants();
				for (Etudiant e : etudiants)
				{
					this.main.allEtudiants.add(e);
				}
			}
		}
		System.out.println("- FIN ");
	}
	
	private void getAllPropositions()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- getAllPropositions ");
		System.out.println("- DEBUT ");
		Rectorat[] rectorats = this.main.ministere.getListRectorats();
		for (Rectorat r : rectorats)
		{
			Universite[] universites = r.getListUniversites();
			for (Universite u : universites)
			{
				Proposition[] propositions = u.listeDesPropositions();
				for (Proposition p : propositions)
				{
					this.main.allPropositions.add(p);
				}
			}
		}
		System.out.println("- FIN ");
	}
	
	public void testerSoumettreNbMaxAtteint()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerSoumettreNbMaxAtteint ");
		try
		{
			try {
				this.main.utilVoeux.soumettreVoeu(this.main.allPropositions.get(0), this.main.allEtudiants.get(0), 5);
			} catch (VoeuDejaCreeException e) {
				try {
					this.main.utilVoeux.soumettreVoeu(this.main.allPropositions.get(0), this.main.allEtudiants.get(1), 5);
				} catch (VoeuDejaCreeException e1) {
					System.out.println("- PAS DE CHANCE : T'es tombé deux fois sur des voeux déjà demandé");
				}
			}
			
		} catch (NombreMaxDeVoeuxAtteintException e) {
			System.out.println("- OK : NombreMaxDeVoeuxAtteintException");
		}
		
	}
}
