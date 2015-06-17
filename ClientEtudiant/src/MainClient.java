import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Etudes.EtudiantInconnuException;
import Etudes.Ministere;
import Etudes.MinistereHelper;
import Etudes.Rectorat;

public class MainClient {
	
	private Ministere ministere;
	
	private String numEtudiantSaisi = "012345";
	
	private String motDePasseSaisi = "azerty";
	
	public static void main(String[] args) {
		new MainClient();
	}
	
	public MainClient()
	{
		this.seConnecter();
		
		Rectorat[] rectoratsAccessibles = ministere.getListRectorats();
		
		Rectorat choisi = rectoratsAccessibles[0];
		
		System.out.println("Choisi : " + choisi.nom());
		
		try {
			choisi.demanderConnexion(choisi.getEtudiantByNumero(this.numEtudiantSaisi), this.motDePasseSaisi);
			System.out.println("Connexion réussie");
		} catch (EtudiantInconnuException e) {
			System.out.println("ERREUR : L'étudiant numéro " + e.numEtudiantInconnu + " n'est pas connu du rectorat " + e.nomUniversite + ".");
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
}
