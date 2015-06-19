package Universite;
import java.util.Calendar;

import Etudes.Licence;
import Etudes.LicenceHelper;
import Etudes.Proposition;
import Etudes.ResultatPOA;
import Util.UtilConnexion;


public class ResultatImpl extends ResultatPOA {

	private Licence licence;
	private float moyenne;
	private String codeObtention;
	private short position;
	
	public ResultatImpl()
	{
		
	}
	
	public ResultatImpl(String intituleLicence, float m, String c, short p, String numEtudiant){
		moyenne = m;
		codeObtention = c;
		position = p;
		
		UtilConnexion.connexionAuNammingService(this, "Result_" + numEtudiant);
		
		org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Licence_" + intituleLicence);
		this.licence = LicenceHelper.narrow(result);
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Result_" + numEtudiant + " r�f�renc� et op�rationnel.");
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
