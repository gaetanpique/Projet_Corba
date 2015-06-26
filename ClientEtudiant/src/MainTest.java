import java.util.ArrayList;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Etudes.Etudiant;
import Etudes.Formation;
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.Proposition;
import Etudes.Rectorat;
import Etudes.UtilVoeux;
import Etudes.Voeu;

public class MainTest {
	
	public Ministere ministere;
	
	public Formation[] formationsExistentes;
	
	public String numEtudiantSaisi = "2345412";
	
	public Etudiant etudiantConnecte;
	
	public String motDePasseSaisi = "azerty";
	
	public Rectorat[] listRectorat;
	
	public Rectorat choisi;
	
	public UtilVoeux utilVoeux;
	
	public ArrayList<Proposition> allPropositions = new ArrayList<Proposition>();
	
	public ArrayList<Etudiant> allEtudiants = new ArrayList<Etudiant>();
	
	public static void main(String[] args) {
		new MainTest();
	}
	
	public MainTest()
	{
		this.seConnecter();
		this.testerRecupererRectorats();
		new TestInscription(this);
		new TestConnexion(this);
		new TestPostuler(this);
		this.afficherEtatFinPhase1AND2("Etat des voeux étudiants à la fin de la phase 1 : ");
		new Phase1To2(this);
		this.afficherEtatFinPhase1AND2("Etat des voeux étudiants à la fin de la phase 2 : ");
		new Phase2To3(this);
		this.afficherEtatFinPhase3AND4("Etat des voeux étudiants au début de la phase 3 : ");
		new Phase3To4(this);
		this.afficherEtatFinPhase3AND4("Etat des voeux étudiants à la fin de la phase 3 : ");
		new Phase4(this);
		this.afficherEtatFinPhase3AND4("Etat des voeux étudiants à la fin de la phase 4 : ");
		
	}
	
	private void afficherEtatFinPhase1AND2(String _instant) {
		System.out.println(_instant);
		System.out.println("------------------------------------------------- ");
		for (Etudiant e : allEtudiants)
		{
			System.out.println("Etudiant n°" + e.numEtudiant() + " : ");
			Voeu[] voeux = e.listeVoeux();
			
			for (Voeu v : voeux)
			{
				System.out.println(" - Voeu " + v.position() + " : " + v.getId() + " ; Etat : " + v.etatVoeu());
			}
		}
	}
	
	private void afficherEtatFinPhase3AND4(String _instant) {
		System.out.println(_instant);
		System.out.println("------------------------------------------------- ");
		for (Etudiant e : allEtudiants)
		{
			System.out.println("Etudiant n°" + e.numEtudiant() + " : ");
			Voeu[] voeux = utilVoeux.getMeilleurePropositionByEtudiant(e);
			
			for (Voeu v : voeux)
			{
				System.out.println(" - Voeu " + v.position() + " : " + v.getId() + " ; Etat : " + v.etatVoeu());
			}
		}
	}

	public void seConnecter()
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
			nameToFind[0] = new org.omg.CosNaming.NameComponent("Ministere", "");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantMinistere = nameRoot
					.resolve(nameToFind);

			// Casting de l'objet CORBA au type convertisseur euro
			this.ministere = MinistereHelper.narrow(distantMinistere);

		} catch (InvalidName | NotFound | CannotProceed
				| org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}
	}
	
	public void testerRecupererRectorats()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TesterRecupererRectorats() ");
		System.out.println("- Récupération de la liste des rectorats DEBUT ");
		this.listRectorat = ministere.getListRectorats();
		
		for (Rectorat r : listRectorat)
		{
			System.out.println("- Rectorat : " + r.nom());
		}
		this.choisi = this.listRectorat[0];
		System.out.println("- Récupération de la liste des rectorats FIN ");
		System.out.println("- Choisi : " + choisi.nom());
	}
	
	public void passagePhase1()
	{
		
	}
	
}
