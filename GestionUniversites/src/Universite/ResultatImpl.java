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
		
		System.out.println(Calendar.getInstance().getTime().toString() + " : Servant Result_" + numEtudiant + " référencé et opérationnel.");
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
		return position;
	}

}
