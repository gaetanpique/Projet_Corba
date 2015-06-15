package UtilVoeux;

import java.util.ArrayList;

import Etudes.Etudiant;
import Etudes.NombreMaxDeVoeuxAtteint;
import Etudes.Proposition;
import Etudes.Rectorat;
import Etudes.Universite;
import Etudes.UtilVoeuxPOA;
import Etudes.Voeu;

class UtilVoeux extends UtilVoeuxPOA{
	
	private ArrayList<VoeuImpl> listeVoeux = new ArrayList<VoeuImpl>();
	private VoeuImpl voeuCourant;

	public UtilVoeux()  {
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public Etudes.Voeu[] getMeilleurePropositionByEtudiant(Etudiant etudiant) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Cette méthode crée un nouveau Voeu dans la "Base"
	 * 
	 * 
	 * @param La proposition et l'etudiant qui constituent le voeu
	 * @return void 
	 * @author Merwan
	 */
	@Override
	public void soumettreVoeu(Proposition aSoumettre, Etudiant soumetteur) throws NombreMaxDeVoeuxAtteint 
	{
		// TODO Auto-generated method stub
		if ()
		{
			
		}
		else
		{
			throw new NombreMaxDeVoeuxAtteint();
		}
		
	}
	
	/**
	 * Cette méthode renvoie une liste de voeux concernant un etudiant
	 * 
	 * 
	 * @param Etudiant dont on recherche les voeux
	 * @return Voeu[] La liste de voeux concernant l'etudiant
	 * @author Merwan
	 */
	@Override
	public Etudes.Voeu[] getVoeuxByEtudiant(Etudiant etudiant) {
		ArrayList<Voeu> arrayVoeuxTemp = new ArrayList<Voeu>();
		
		for (int i =0; i< listeVoeux.size();i++) 
		{
			if (listeVoeux.get(i).etudiantCorrespondant().equals(etudiant))
			{
				arrayVoeuxTemp.add((Voeu) listeVoeux.get(i));
			}
				
		}
		
		return arrayVoeuxTemp.toArray(new Voeu[arrayVoeuxTemp.size()]);
	}

	
	/**
	 * Cette méthode renvoie une liste de voeux concernant une universite
	 * 
	 * 
	 * @param Universite dont on recherche les voeux
	 * @return Voeu[] La liste de voeux concernant l'universite
	 * @author Merwan
	 */
	@Override
	public Voeu[] getVoeuxByUniversite(Universite _universite) 
	{
		ArrayList<Voeu> arrayVoeuxTemp = new ArrayList<Voeu>();
		
		for (int i =0; i< listeVoeux.size();i++) 
		{
			if (listeVoeux.get(i).propositionCorrespondante().universiteSource().equals(_universite))
			{
				arrayVoeuxTemp.add((Voeu) listeVoeux.get(i));
			}
				
		}
		
		return arrayVoeuxTemp.toArray(new Voeu[arrayVoeuxTemp.size()]);
	}


}
