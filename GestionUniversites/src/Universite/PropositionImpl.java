package Universite;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import Etudes.Licence;
import Etudes.Master;
import Etudes.MasterHelper;
import Etudes.Proposition;
import Etudes.PropositionPOA;
import Etudes.Universite;
import Etudes.UniversiteHelper;
import Etudes.prerequisDejaExistantException;
import Util.UtilConnexion;
import Util.UtilTraitements;

public class PropositionImpl extends PropositionPOA {
	
	private ArrayList<Licence> prerequis = new ArrayList<Licence>(); 
	private Master masterPropose;
	private int nbPlaces;
	private Universite universiteProposante;
	/**
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les pr�requis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(ArrayList<Licence> p, String nomUniversite, String intituleMaster){
		prerequis = p;

		// Intialisation de l'orb
		UtilConnexion.connexionAuNammingService(this, "Proposition_" + nomUniversite + "_" + intituleMaster);
				
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Master_" + intituleMaster);
		this.masterPropose = MasterHelper.narrow(result);
		
		org.omg.CORBA.Object result1 = UtilConnexion.getObjetDistant("Universite_" + intituleMaster);
		this.universiteProposante = UniversiteHelper.narrow(result1);
		
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Proposition_" + nomUniversite + "_" + intituleMaster + " r�f�renc� et op�rationnel.");
	}
	/**
	 * Constructeur de Proposition avec Licence[] pour les pr�requis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(Licence[] p, String nomUniversite, String intituleMaster){
		this((ArrayList<Licence>) UtilTraitements.ToArray(p), nomUniversite, intituleMaster);
	}	
	
	//-----------------GETTERS ANS SETTERS--------------------------------//


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
		return "Proposition_" + universiteProposante.nom() + "_" + masterPropose.intitule();
	}
	@Override
	public int nbPlaces() {
		return this.nbPlaces;
	}

	/**
	 * Ajoute une licence � la liste des pr�requis d'une proposition
	 * 
	 * @exception prerequisDejaExiistantException : la licence en param�tre est d�j� pr�sente dans la liste
	 * @author Baptiste
	 */
/*	@Override
	public void addPrerequis(Licence l) throws prerequisDejaExistantException{
		if(prerequis.contains(l))
		{
			throw new prerequisDejaExistantException((Proposition) this);
		}
		else
		{
			prerequis.add(l);
		}
		
	}*/
}

