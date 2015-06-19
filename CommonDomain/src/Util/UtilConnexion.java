package Util;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.Servant;

public class UtilConnexion {
	public static ORB connexionAuNammingService(Servant objetAReferencer, String _nomAReferencer)
	{
		try {
			ORB orb = ORB.init(new String[0], null);

			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.activate_object(objetAReferencer);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();

			// Enregistrement dans le service de nommage
			// Recuperation du naming service
			NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(_nomAReferencer, "");

			// Enregistrement de l'objet CORBA dans le service de noms
			nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(objetAReferencer));

			return orb;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static org.omg.CORBA.Object getObjetDistant(String _nomReference)
	{
		try {
			ORB orb = ORB.init(new String[0], null);

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot;

			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(_nomReference,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantObjet = nameRoot.resolve(nameToFind);

			return distantObjet;

		} catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
			return null;
		}
	}
}
