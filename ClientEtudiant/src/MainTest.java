import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Etudes.Etudiant;
import Etudes.Formation;
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.Rectorat;

public class MainTest {
	
	public Ministere ministere;
	
	public Formation[] formationsExistentes;
	
	public String numEtudiantSaisi = "012345";
	
	public Etudiant etudiantConnecte;
	
	public String motDePasseSaisi = "azerty";
	
	public Rectorat[] listRectorat;
	
	public Rectorat choisi;
	
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
	
	
	
}
