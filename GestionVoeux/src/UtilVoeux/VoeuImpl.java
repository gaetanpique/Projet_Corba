package UtilVoeux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.omg.CORBA.ORB;

import Util.UtilTraitements;
import Etudes.Etudiant;
import Etudes.EtudiantHelper;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.Voeu;
import Etudes.VoeuPOA;
import Etudes.diplomesDifferentsException;
import Util.UtilConnexion;
 
public class VoeuImpl extends VoeuPOA  implements Comparable<Voeu>
{
	private Proposition propositionCorrespondante;
	private Etudiant etudiantCorrespondant;
	private short classementEtudiant;
	private short position;
	private String etatVoeu;
	
	public VoeuImpl(Proposition p, String numEtudiant, short positionVoeu) 
	{
		this(p, numEtudiant, positionVoeu, "initial");
	}
	
	public VoeuImpl(Proposition p, String numEtudiant, short positionVoeu, String etatVoeu) 
	{
		try {
			this.propositionCorrespondante = p;
			this.position = positionVoeu;
			this.etatVoeu = etatVoeu;

			org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Etu_" + numEtudiant);
			this.etudiantCorrespondant = EtudiantHelper.narrow(result);

			ORB orb = UtilConnexion.connexionAuNammingService(this, "Voeu_"	+ numEtudiant + "_" + p.masterPropose().intitule());

			this.etudiantCorrespondant.addVoeuEtudiant(this._this());

			System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Voeu_" + numEtudiant + "_"	+ p.masterPropose().intitule() + " référencé et opérationnel.");
			orb.run();
		} catch (NombreMaxDeVoeuxAtteintException e) {
			e.printStackTrace();
		}
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
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		this.etatVoeu("OUI");
		listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements.ToArray(etudiantCorrespondant.listeVoeux());
		//TODO Remplacer la methode asList par la methode correspondant dans Util
		for (VoeuImpl v : listeVoeuTemp)
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
		//TODO les voeux en dessous passent a "non"
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
		this.etatVoeu("PREREQUIS NOK");
		
	}
		
	@Override
	public void accepterCandidature() 
	{
		this.etatVoeu("PREREQUIS");
		
	}		

	@Override
	public short classementEtudiant() {
		return this.classementEtudiant;
	}


	@Override
	public void classementEtudiant(short value) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void majClassement(short classement) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * Cette méthode compare l'etudiant du voeu courant avec celui du voeu passé en paramètre
	 * 
	 * @param Voeu v le Voeu concerné
	 * @return rep entier indiquant le resultat de la comparaison (-1 moins bon, 0 égaux, 1 meilleur)
	 * @author Memer
	 * 
	 */
	@Override
	public int compareTo(Voeu v) 
	{
		int rep = 0;
		try {
			if (this.etudiantCorrespondant.estMeilleurQue(v.etudiantCorrespondant()))
			{
				rep = 1;
			}
			else
			{
				rep = -1;
			}
		} catch (diplomesDifferentsException e) {
			System.out.println("Exception dans la methode CompareTo de VoeuImpl :");
			e.printStackTrace();
		}
		return rep;
	}

	


}
