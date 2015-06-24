import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Etudes.Formation;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.UtilVoeux;
import Etudes.UtilVoeuxHelper;
import Etudes.Voeu;


public class TestPostuler {
	
	private MainTest main;
	
	private UtilVoeux utilVoeux;
	
	private Formation formationChoisie;
	
	private Proposition propositionChoisie;
	
	private Proposition[] propositions;
	
	public TestPostuler(MainTest main)
	{
		this.main = main;
		this.testerRecupererListeFormations();
		this.testerRecupererUniversitesQuiProposentLaFormation(formationChoisie);
		this.testerRecupererUtilitaireVoeu();
		this.testerSoumettreVoeuOK();
	}
	
	public void testerRecupererListeFormations()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerRecupererListeFormations ");
		System.out.println("- Récupération de la liste des formations DEBUT ");
		main.formationsExistentes = main.ministere.getListFormations();
		
		for (Formation f : main.formationsExistentes)
		{
			System.out.println("- Formation : " + f.intitule());
		}
		this.formationChoisie = main.formationsExistentes[0];
		System.out.println("- Récupération de la liste des formations FIN ");
		System.out.println("- Choisi : " + formationChoisie.intitule());
	}
	
	public void testerRecupererUniversitesQuiProposentLaFormation(Formation f)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerRecupererUniversitesQuiProposentLaFormation ");
		System.out.println("- Récupération de la liste des universités qui proposent la formation : " + f.intitule() + " DEBUT ");
		this.propositions = main.ministere.getPropositionByFormation(f);
		System.out.println("- Nb propositions : " + this.propositions.length);
		for (Proposition p : this.propositions)
		{
			//System.out.println("- Propostion : " + p.proposant().nom() + "_" + p.masterPropose().intitule());
			System.out.println("- Propostion : " + p.getId());
		}
		this.propositionChoisie = this.propositions[0];
		System.out.println("- Récupération de la liste des propositions FIN ");
		System.out.println("- Choisi : " + propositionChoisie.proposant().nom() + "_" + propositionChoisie.masterPropose().intitule());
	}
	
	public void testerRecupererUtilitaireVoeu()
	{
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0], null);

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot;

			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb
					.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent("UtilVoeux", "");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantVoeux = nameRoot
					.resolve(nameToFind);
			
			System.out.println("Recuperation de l'utilitaire de voeux");
			// Casting de l'objet CORBA au type convertisseur euro
			this.utilVoeux = UtilVoeuxHelper.narrow(distantVoeux);

		} catch (InvalidName | NotFound | CannotProceed
				| org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}
	}
	
	public void testerSoumettreVoeuOK()
	{
		try {
			 Voeu[] voeuxTemp = new Voeu[5];
			for (int i = 0; i<5 && i<propositions.length; i++)
			{
				this.utilVoeux.soumettreVoeu(propositions[i], main.etudiantConnecte, i);
				System.out.println("Voeu n°"+i+" de l'étudiant "+main.etudiantConnecte.numEtudiant() + " créé");
			}
			
			voeuxTemp = main.etudiantConnecte.listeVoeux();
			for (int j = 0; j<voeuxTemp.length;j++)
			{
				//TODO Regler le probleme de l'ID pour proposition
				//TODO finir le cas nbre max atteint
				System.out.println(voeuxTemp[j].getId());
			}

		} catch (NombreMaxDeVoeuxAtteintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
