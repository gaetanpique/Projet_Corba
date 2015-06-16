package Universite;

import java.util.ArrayList;
import java.util.Arrays;

import Etudes.EtudiantDejaInscritException;
import Etudes.Licence;
import Etudes.Master;
import Etudes.PropositionPOA;
import Etudes.Resultat;
import Etudes.Universite;

public class PropositionImpl extends PropositionPOA {
	
	private ArrayList<Licence> prerequis = new ArrayList<Licence>(); 
	private Universite universiteSource;
	private Master masterPropos�;

	/**
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les pr�requis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(ArrayList<Licence> p, Universite u, Master m){
		prerequis = p;
		universiteSource = u;
		masterPropos� = m;
	}
	
	/**
	 * Constructeur de Proposition avec Licence[] pour les pr�requis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(Licence[] p, Universite u, Master m){
		prerequis = (ArrayList<Licence>) Arrays.asList(p);
		universiteSource = u;
		masterPropos� = m;
	}
	
	
	@Override
	public Universite universiteSource() {
		return universiteSource;
	}

	@Override
	public Master masterPropose() {
		return masterPropos�;
	}
	
	@Override
	public Licence[] prerequis() {
		return prerequis.toArray(new Licence[prerequis.size()]);
}
	}





