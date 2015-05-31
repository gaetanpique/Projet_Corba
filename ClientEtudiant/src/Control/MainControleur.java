package Control;

import Etudes.Ministere;
import Etudes.MinistereHelper;

public class MainControleur {
	public static void main(String args[]) {

		try {

			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper
					.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent("Ministere", "");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantMinistere = nameRoot
					.resolve(nameToFind);

			// Casting de l'objet CORBA au type convertisseur euro
			Ministere ministere = MinistereHelper.narrow(distantMinistere);

			ministere.getListFormations();
			ministere.getListRectorats();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
