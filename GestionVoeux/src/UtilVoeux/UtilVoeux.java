package UtilVoeux;

import java.util.ArrayList;
import java.util.Collection;

import Etudes.Etudiant;
import Etudes.NombreMaxDeVoeuxAtteint;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.Universite;
import Etudes.UtilVoeuxPOA;
import Etudes.Voeu;
import Util.UtilTraitements;

class UtilVoeux extends UtilVoeuxPOA{

	private ArrayList<VoeuImpl> listeVoeux = new ArrayList<VoeuImpl>();

	public UtilVoeux()  
	{
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 * Cette methode retourne la liste des meilleures propositions pour l'etudiant concerne
	 * Par meilleure proposition on entends, le meilleur voeu ayant été acceté, et les voeux 
	 * qui sont mieux positionnés que celui-ci
	 * @param Etudiant etudiant l'étudiant concerné
	 * @return un tableau de voeux
	 * @author Memer	 
	 * 
	 */
	@Override
	public Etudes.Voeu[] getMeilleurePropositionByEtudiant(Etudiant etudiant) 
	{
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		ArrayList<VoeuImpl> listeMeilleurVoeu = new ArrayList<VoeuImpl>();
		boolean meilleurVoeuTrouve = false;
		
		for (VoeuImpl v : listeVoeux)
		{

			if (v.etudiantCorrespondant().equals(etudiant))
			{
				listeVoeuTemp.add(v);
			}

		}
		
		listeVoeuTemp = getListeVoeuxOrdonnee(listeVoeuTemp);
		for (VoeuImpl v : listeVoeuTemp)
		{

			if (v.etatVoeu().equals("Accepte"))
				{
					meilleurVoeuTrouve = true;
					listeMeilleurVoeu.add(v);
				}
			else if (!meilleurVoeuTrouve);
			{
				listeMeilleurVoeu.add(v);
			}
		}
		return (Voeu[]) UtilTraitements.ToTableau(listeMeilleurVoeu);
	}
	
	/**
	 * Cette methode trie une arraylist de Voeux par leur position
	 * @param listeAOrdonner (assez explicite non ?)
	 * @return La liste ordonnée
	 * @author Memer
	 */
	public ArrayList<VoeuImpl> getListeVoeuxOrdonnee(ArrayList<VoeuImpl> listeAOrdonner)
	{
		VoeuImpl voeuTemp;
		boolean permut;
		 
		    do
		    {
		        // hypothèse : le tableau est trié
		        permut=false;
		        for (int i =0;i<listeAOrdonner.size()-1;i++)
		        {
		            // Teste si 2 éléments successifs sont dans le bon ordre ou non
		            if (listeAOrdonner.get(i).position()> listeAOrdonner.get(i+1).position())
		            {
		            	voeuTemp=listeAOrdonner.get(i);
		            	listeAOrdonner.set(i, listeAOrdonner.get(i+1));
		            	listeAOrdonner.set(i+1, voeuTemp);
		                permut=true;
		            }
		        }
		    }
		    while(permut);
		 return listeAOrdonner;
	}

	/**
	 * Cette méthode crée un nouveau Voeu dans la "Base"
	 * 
	 * 
	 * @param La proposition et l'etudiant qui constituent le voeu
	 * @return void
	 * @throws NombreMaxDeVoeuxAtteint l'etudiant peut en avoir maximum 5 
	 * @author Merwan
	 */
	@Override
	public void soumettreVoeu(Proposition aSoumettre, Etudiant soumetteur, short positionVoeu) throws NombreMaxDeVoeuxAtteintException 
	{
		Integer cpt=0;

  	for (VoeuImpl v : listeVoeux)
		{
			if (v.etudiantCorrespondant().equals(soumetteur)) {cpt++;};
		}

		if (cpt <5) 
		{
			VoeuImpl leVoeu = new VoeuImpl(aSoumettre, soumetteur,positionVoeu);
			soumetteur.addVoeuEtudiant(leVoeu._this());
			listeVoeux.add(leVoeu);
			
		}
		else
		{
			throw new NombreMaxDeVoeuxAtteintException();
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
				//TODO verifier que le point equals fonctionne
			{
				arrayVoeuxTemp.add(listeVoeux.get(i)._this());
			}

		}

		return (Voeu[]) UtilTraitements.ToTableau(arrayVoeuxTemp);
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

		return (Voeu[]) UtilTraitements.ToTableau(arrayVoeuxTemp);
	}

	/**
	 * Cette méthode permet de retourner un tableau de voeu concernant les universites d'un rectorat
	 * Elle parcourt les universite d'un rectorat pour ensuite recuperer les voeux de chacune d'elles 
	 * @param Rectorat rectoratConcerne : le rectorat en question
	 * @return Voeu[] : le tableau des voeux concernant le rectorat
	 * @author Memer
	 */
	@Override
	public Voeu[] getVoeuxByRectorat(Rectorat rectoratConcerne) 
	{
		
		ArrayList<Universite> arrayUniversiteTemp = new ArrayList<Universite>();
		ArrayList<Voeu> arrayVoeuTemp = new ArrayList<Voeu>();
		arrayUniversiteTemp = (ArrayList<Universite>) UtilTraitements.ToArray(rectoratConcerne.getListUniversites());
		
		
		for ( int i = 0; i < arrayUniversiteTemp.size()-1; i++)
		{
			arrayVoeuTemp.addAll(arrayVoeuTemp.size(), (Collection<? extends Voeu>) UtilTraitements.ToArray(this.getVoeuxByUniversite(arrayUniversiteTemp.get(i))));
			//Cette manipulation permet de transformer le tableau fourni par voeu en arraylist puis de la caster
			//pour l'ajouter a la fin de l'arraylist
			
		}
		
		return (Voeu[]) UtilTraitements.ToTableau(arrayVoeuTemp);
			
	}




}
