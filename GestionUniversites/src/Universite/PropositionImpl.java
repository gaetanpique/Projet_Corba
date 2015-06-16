package Universite;

import java.util.ArrayList;
import java.util.Arrays;

import Etudes.EtudiantDejaInscritException;
import Etudes.Formation;
import Etudes.Licence;
import Etudes.Master;
import Etudes.PropositionPOA;
import Etudes.Resultat;
import Etudes.Universite;
import Etudes.prerequisDejaExistantException;

public class PropositionImpl extends PropositionPOA {
	
	private Formation _formation;
	private ArrayList<Licence> prerequis = new ArrayList<Licence>(); 
	private Universite universiteSource;
	private Master masterProposé;

	
	public PropositionImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PropositionImpl(Formation formation, Licence[] pr) {
		super();
		// TODO Auto-generated constructor stub
		this._formation = formation;
		this.prerequis = (ArrayList<Licence>) Arrays.asList(pr);
	}

	/**
	 * Constructeur de Proposition avec une ArrayList<Licence> pour les prérequis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(ArrayList<Licence> p, Universite u, Master m){
		prerequis = p;
		universiteSource = u;
		masterProposé = m;
	}
	
	/**
	 * Constructeur de Proposition avec Licence[] pour les prérequis
	 * 
	 * @author Baptiste
	 */
	public PropositionImpl(Licence[] p, Universite u, Master m){
		prerequis = (ArrayList<Licence>) Arrays.asList(p);
		universiteSource = u;
		masterProposé = m;
	}
	
	
	@Override
	public Universite universiteSource() {
		return universiteSource;
	}

	@Override
	public Master masterPropose() {
		return masterProposé;
	}
	
	@Override
	public Licence[] prerequis() {
		return _prerequis.toArray(new Licence[_prerequis.size()]);
}



	@Override
	public void addPrerequis(Licence l) throws prerequisDejaExistantException{
		// TODO Auto-generated method stub
		
	}

	}

