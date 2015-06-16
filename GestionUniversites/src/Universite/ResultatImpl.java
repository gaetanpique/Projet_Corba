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
	private String codeObtention;
	private short position;
	
	public ResultatImpl(Licence l, float m, String c, short p){
		licence = l;
		moyenne = m;
		codeObtention = c;
		position = p;
	}
	
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

	@Override
	public short position() {
		return position;
	}

}
