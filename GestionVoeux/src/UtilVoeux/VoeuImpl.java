package UtilVoeux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import Etudes.Etudiant;
import Etudes.Master;
import Etudes.Proposition;
import Etudes.Universite;
import Etudes.Voeu;
import Etudes.VoeuPOA;

public class VoeuImpl extends VoeuPOA 
{
	private Proposition propositionCorrespondante;
	private Etudiant etudiantCorrespondant;
	private short position;
	private String etatVoeu;
	
	public VoeuImpl() 
	{
		// TODO Auto-generated constructor stub
	}	
	
	
	public VoeuImpl(Proposition aSoumettre, Etudiant soumetteur, short positionVoeu) 
	{
		this.propositionCorrespondante = aSoumettre;
		this.etudiantCorrespondant = soumetteur;
		this.position = positionVoeu;
	}
	
	
	//-----------------GETTERS ANS SETTERS--------------------------------//
	

	@Override
	public String etatVoeu() 
	{
		return this.etatVoeu();
	}


	@Override
	public void etatVoeu(String value) 
	{
		this.etatVoeu = value;
		
	}

	@Override
	public short position() 
	{
		return position;
	}

	@Override
	public void position(short value) {
		this.position = value;
		
	}
	
	//-------------------READ ONLY ATTRIBUTES-------------------------------//
	
	/**
	 * @return the propositionCorrespondante
	 */
	@Override
	public Proposition propositionCorrespondante() 
	{
		return propositionCorrespondante;
	}

	@Override
	public Etudiant etudiantCorrespondant() 
	{
		return etudiantCorrespondant;
	}

	
	//---------------------------------METHODS-------------------------------//
	
	/**
	 * Methode declenchee lors de la réponse de l'etudiant
	 */
	@Override
	public void reponseOUI() 
	{
		ArrayList<Voeu> listeVoeuTemp = new ArrayList<Voeu>();
		this.etatVoeu("OUI");
		listeVoeuTemp = (ArrayList<Voeu>) Arrays.asList(etudiantCorrespondant.listeVoeux());
		for (Voeu v : listeVoeuTemp)
		{
			if (!v.equals(this))
			{
				v.reponseNON();
			}
		}
		
		
	}


	/**
	 * Methode declenchee lors de la réponse de l'etudiant
	 */
	@Override
	public void reponseOUIMAIS() 
	{
		this.etatVoeu("OUI MAIS");		
	}


	/**
	 * Methode declenchee lors de la réponse de l'etudiant
	 */
	@Override
	public void reponseNONMAIS() 
	{
		this.etatVoeu("NON MAIS");
	}


	/**
	 * Methode declenchee lors de la réponse de l'etudiant
	 */
	@Override
	public void reponseNON() 
	{
		this.etatVoeu("NON");
	}
	
	public void refuserCandidature() 
	{
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public void accepterCandidature() 
	{
		// TODO Auto-generated method stub
		
	}		
	
	@Override
	public void majClassement(short classement) 
	{
		// TODO Auto-generated method stub

	}

	


}
