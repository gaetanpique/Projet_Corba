package Universite;
import java.util.ArrayList;

import Etudes.EtudiantDejaInscritException;
import Etudes.Formation;
import Etudes.Licence;
import Etudes.Proposition;
import Etudes.ResultatPOA;


 class ResultatImpl extends ResultatPOA {

	private Licence licence;
	private float moyenne;
	private Proposition proposition;
	private String codeObtention;
	
	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	@Override
	public String codeObtention() {
		return codeObtention;
	}

	@Override
	public float moyenne() {
		return moyenne;
	}


	/**
	 * Cette méthode vérifie si la licence du résultat est présente 
	 * dans la liste des licences prérequises de la proposition en paramètre
	 * 
	 * @return true : licence présente dans les prérequis. false : licence non présente
	 * @author Baptiste
	 */
	public boolean isValideForProposition(Proposition proposition) {
		PropositionImpl p = (PropositionImpl)proposition;
		Licence[] liste = p.prerequis();
		for(int i = 0 ; i < liste.length ; i++){
		//comparaison par référence à vérifier
			if (liste[i] == this.getLicence())
//		//comparaison par contenu
//			if (liste[i].equals(this.getLicence()))
				return true;
		}		
		return false;
	}

	@Override
	public short position() {
		// TODO Auto-generated method stub
		return 0;
	}

}
