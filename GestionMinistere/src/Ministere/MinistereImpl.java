package Ministere;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Policy;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Etudes.Formation;
import Etudes.MinisterePOA;
import Etudes.Proposition;
import Etudes.Rectorat;
import Etudes.RectoratHelper;

public class MinistereImpl extends MinisterePOA {
	
	private ORB orb;
	
	private ArrayList<Rectorat> rectorats = new ArrayList<Rectorat>();

	public MinistereImpl()
	{
		try {
			// Intialisation de l'ORB
			this.orb = ORB.init(new String[0], null);

			// Recuperation du POA
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.activate_object(this);

			// Activer le POA manager
			rootPOA.the_POAManager().activate();
			
			 // Enregistrement dans le service de nommage
			 // Recuperation du naming service 
			 NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
			 
			 // Construction du nom a enregistrer
			 org.omg.CosNaming.NameComponent[] nameToRegister = new  org.omg.CosNaming.NameComponent[1]; 
			 nameToRegister[0] = new org.omg.CosNaming.NameComponent("Ministere","");
			 
			 // Enregistrement de l'objet CORBA dans le service de noms
			 nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(this));
			 
			 System.out.println(Calendar.getInstance().getTime().toString() + " : Servant MinistereImpl référencé et opérationnel.");
			 
			// Lancement de l'ORB et mise en attente de requete
			this.orb.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Formation[] getListFormations() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListFormations()");
		return new Formation[1];
	}

	@Override
	public Rectorat[] getListRectorats() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListRectorats() :");
		return this.rectorats.toArray(new Rectorat[this.rectorats.size()]);
	}

	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getPropositionByFormation()");
		return new Proposition[1];
	}

	@Override
	public void referencer(Rectorat rectoratConnecte) {
		this.rectorats.add(rectoratConnecte);
	}

	

	@Override
	public void dereferencer(Rectorat rectoratDeconnecte) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.deconnexion()");
		this.rectorats.remove(rectoratDeconnecte);
	}
	
	public static void main(String[] args) {
		new MinistereImpl();
	}
}
