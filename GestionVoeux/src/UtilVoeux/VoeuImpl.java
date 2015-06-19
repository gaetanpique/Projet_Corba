package UtilVoeux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.omg.CORBA.ORB;

import Util.UtilTraitements;
import Etudes.EtatVoeu;
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
	private Etudes.EtatVoeu etatVoeu;
	
	public VoeuImpl(Proposition p, String numEtudiant, short positionVoeu)
	{
		this(p, numEtudiant, positionVoeu, EtatVoeu.initial);
	}
	
	public VoeuImpl(Proposition p, String numEtudiant, short positionVoeu, EtatVoeu etatVoeu) 
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
	//Pour la réponse de l'étudiant, on effectue un traitement que lors de la réponse de l'étudiant, 
	//sinon le voeu reste à "valide" et c'est lors de l'affichage que l'on determinera si l'étudiant est en attente
	//ou non, en comparant le classement de l'étudiant et le nombre de places dans la proposition
	
	/**
	 * Methode declenchee lors de la réponse de l'etudiant
	 */
	@Override
	public void reponseOUI() 
	{
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		this.etatVoeu = EtatVoeu.OUI;
		listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements.ToArray(etudiantCorrespondant.listeVoeux());
		for (VoeuImpl v : listeVoeuTemp)
		{
			if (!v.equals(this))
			{
				//Tous les autres voeux passent à NON car on a un "OUI" définitif
				v.etatVoeu = EtatVoeu.NON;
				
			}
		}
	}
	
	@Override
	public void reponseOUIMAIS() {
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		this.etatVoeu = EtatVoeu.OUIMAIS;
		listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements.ToArray(etudiantCorrespondant.listeVoeux());
		for (VoeuImpl v : listeVoeuTemp)
		{
			if (v.position> this.position)
			{
				//Les voeux moins biens classés passent à non (utile car on peut avoir plusieurs réponses positivesà un voeu)
				v.etatVoeu = EtatVoeu.NON;
			}
		}
		
	}


	@Override
	public void reponseNONMAIS() {
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		this.etatVoeu = EtatVoeu.NONMAIS;
		listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements.ToArray(etudiantCorrespondant.listeVoeux());
		for (VoeuImpl v : listeVoeuTemp)
		{
			if (v.position> this.position)
			{
				//Les voeux moins biens classés passent à non (utile car on peut avoir plusieurs réponses positivesà un voeu)
				v.etatVoeu = EtatVoeu.NON;
			}
			
		}
		
		
	}


	@Override
	public void reponseNON() 
	{
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		this.etatVoeu = EtatVoeu.NON;
		listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements.ToArray(etudiantCorrespondant.listeVoeux());
		for (VoeuImpl v : listeVoeuTemp)
		{
			if (!(v.equals(this)))
			{
				//Les voeux moins biens classés passent à non (utile car on peut avoir plusieurs réponses positivesà un voeu)
				v.etatVoeu = EtatVoeu.NON;
			}
			
		}
		
	}
	

	@Override
	public short classementEtudiant() {
		return this.classementEtudiant;
	}


	@Override
	public void classementEtudiant(short value) {
		this.classementEtudiant = value;
		
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

	@Override
	public Etudes.EtatVoeu etatVoeu() {
		return this.etatVoeu;
	}


	@Override
	public void etatVoeu(Etudes.EtatVoeu value) {
		this.etatVoeu = value;
		
	}





	@Override
	public void accepterCandidature() 
	{
		this.etatVoeu(EtatVoeu.valide);
		
	}


	@Override
	public void refuserCandidature() 
	{
		this.etatVoeu(EtatVoeu.nonValide);
		
	}

	


}
