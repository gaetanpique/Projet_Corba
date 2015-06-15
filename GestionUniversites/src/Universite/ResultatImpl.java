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
	
	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	@Override
	public String codeObtention() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float moyenne() {
		return moyenne;
	}

	@Override
	public void moyenne(float value) {
		moyenne = value;
	}

	/**
	 * Cette m�thode v�rifie si la licence du r�sultat est pr�sente 
	 * dans la liste des licences pr�requises de la proposition en param�tre
	 * 
	 * @return true : licence pr�sente dans les pr�requis. false : licence non pr�sente
	 * @author Baptiste
	 */
	public boolean isValideForProposition(Proposition proposition) {
		PropositionImpl p = (PropositionImpl)proposition;
		Licence[] liste = p.prerequis();
		for(int i = 0 ; i < liste.length ; i++){
		//comparaison par r�f�rence � v�rifier
			if (liste[i] == this.getLicence())
//		//comparaison par contenu
//			if (liste[i].equals(this.getLicence()))
				return true;
		}		
		return false;
	}

}
