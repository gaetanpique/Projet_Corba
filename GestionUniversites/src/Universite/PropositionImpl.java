package Universite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import Etudes.Licence;
import Etudes.Master;
import Etudes.MasterHelper;
import Etudes.PropositionPOA;
import Etudes.Universite;
import Util.UtilConnexion;
import Util.UtilTraitements;

public class PropositionImpl extends PropositionPOA {
	
	private ArrayList<Licence> prerequis = new ArrayList<Licence>(); 
	private Master masterPropose;
	private int nbPlaces;
	private UniversiteImpl proposant;
	/**
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les prérequis
	 * 
	 * @author Baptiste
	 */

	public PropositionImpl(ArrayList<Licence> p, UniversiteImpl u, String intituleMaster){
		this.prerequis = p;
		this.proposant = u;
		
		// Intialisation de l'orb
		UtilConnexion.connexionAuNammingService(this, "Proposition_" + u.nom() + "_" + intituleMaster);
				
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Master_" + intituleMaster);
		this.masterPropose = MasterHelper.narrow(result);

		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Proposition_" + u.nom() + "_" + intituleMaster + " référencé et opérationnel.");
	}
	/**
	 * Constructeur de Proposition avec Licence[] pour les prérequis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(Licence[] p, UniversiteImpl u, String intituleMaster){
		this((ArrayList<Licence>) UtilTraitements.ToArray(p), u, intituleMaster);
	}

	@Override
	public Master masterPropose() {
		return masterPropose;
	}
	
	@Override
	public Licence[] prerequis() {
		return prerequis.toArray(new Licence[prerequis.size()]);
	}
	
	@Override
	public void prerequis(Licence[] value) {
		prerequis.clear();
		prerequis.addAll((Collection<? extends Licence>) UtilTraitements.ToArray(value));		
	}

	@Override
	public String getId() {
		return "Proposition_" + proposant.nom() + "_" + masterPropose.intitule();
	}
	@Override
	public int nbPlaces() {
		return this.nbPlaces;
	}

	@Override
	public Universite proposant() {
		return this.proposant._this();
	}
}

