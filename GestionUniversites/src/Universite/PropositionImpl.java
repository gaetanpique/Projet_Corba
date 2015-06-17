package Universite;

import java.util.ArrayList;
import java.util.Collection;

import Util.UtilTraitements;
import Etudes.Licence;
import Etudes.Master;
import Etudes.Proposition;
import Etudes.PropositionPOA;
import Etudes.Universite;
import Etudes.prerequisDejaExistantException;

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
		prerequis = (ArrayList<Licence>) UtilTraitements.ToArray(p);
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

	@Override
	public void prerequis(Licence[] value) {
		prerequis.clear();
		prerequis.addAll((Collection<? extends Licence>) UtilTraitements.ToArray(value));		
	}

	/**
	 * Ajoute une licence � la liste des pr�requis d'une proposition
	 * 
	 * @exception prerequisDejaExiistantException : la licence en param�tre est d�j� pr�sente dans la liste
	 * @author Baptiste
	 */
	@Override
	public void addPrerequis(Licence l) throws prerequisDejaExistantException{
		if(prerequis.contains(l))
		{
			throw new prerequisDejaExistantException((Proposition) this);
		}
		else
		{
			prerequis.add(l);
		}
		
	}

	}

