package UtilVoeux;

import java.util.ArrayList;
import java.util.Calendar;

import Etudes.EtatsVoeu;
import Etudes.Etudiant;
import Etudes.EtudiantHelper;
import Etudes.NombreMaxDeVoeuxAtteintException;
import Etudes.Proposition;
import Etudes.Voeu;
import Etudes.VoeuPOA;
import Etudes.diplomesDifferentsException;
import Etudes.EtatsVoeu;
import Util.DbConnection;
import Util.UtilConnexion;
import Util.UtilTraitements;

public class VoeuImpl extends VoeuPOA implements Comparable<Voeu> {
	private Proposition propositionCorrespondante;
	private Etudiant etudiantCorrespondant;
	private int position;
	private Etudes.EtatsVoeu etatVoeu;

	public VoeuImpl(Proposition p, String numEtudiant, int positionVoeu) {
		this(p, numEtudiant, positionVoeu, EtatsVoeu.initial);
	}

	public VoeuImpl(Proposition p, String numEtudiant, int positionVoeu,
			EtatsVoeu etatVoeu) {
		try {
			this.propositionCorrespondante = p;
			this.position = positionVoeu;
			this.etatVoeu = etatVoeu;
			
			System.out.println("Construction du voeu");
			org.omg.CORBA.Object result = UtilConnexion.getObjetDistant("Etu_"
					+ numEtudiant);
			this.etudiantCorrespondant = EtudiantHelper.narrow(result);
			System.out.println("1");
			UtilConnexion.connexionAuNammingService(this, "Voeu_" + numEtudiant
					+ "_");
			System.out.println("2");
			this.etudiantCorrespondant.addVoeuEtudiant(this._this());
			System.out.println("3");
			
			System.out.println(Calendar.getInstance().getTime().toString()
					+ " : Servant Voeu_" + numEtudiant + "_"
					+ p.masterPropose().intitule()
					+ " référencé et opérationnel.");
			

		} catch (NombreMaxDeVoeuxAtteintException e) {
			e.printStackTrace();
		}
	}

	// -----------------GETTERS ANS SETTERS--------------------------------//

	@Override
	public int position() {
		return position;
	}

	@Override
	public void position(int value) {
		this.position = value;
		String[] colonnes = new String[1];
		colonnes[0] = "position";
		String[] valeurs = new String[1];
		valeurs[0] = String.valueOf(value);

		DbConnection.updateIntoDB("Voeu", colonnes, valeurs, "numetudiant = '"
				+ etudiantCorrespondant.numEtudiant()
				+ "' and idproposition = '"
				+ propositionCorrespondante().getId() + "'");
	}

	@Override
	public Etudes.EtatsVoeu etatVoeu() {
		return this.etatVoeu;
	}

	@Override
	public void etatVoeu(EtatsVoeu value) {
		this.etatVoeu = value;
		String[] colonnes = new String[1];
		colonnes[0] = "etatvoeu";
		String[] valeurs = new String[1];
		valeurs[0] = String.valueOf(value);

		DbConnection.updateIntoDB("Voeu", colonnes, valeurs, "numetudiant = '"
				+ etudiantCorrespondant.numEtudiant()
				+ "' and idproposition = '"
				+ propositionCorrespondante().getId() + "'");
	}

	@Override
	public String getId() {
		return "Voeu_" + etudiantCorrespondant.numEtudiant() + "_"
				+ propositionCorrespondante.getId();
	}

	// -------------------READ ONLY ATTRIBUTES-------------------------------//

	/**
	 * @return the propositionCorrespondante
	 */
	@Override
	public Proposition propositionCorrespondante() {
		return propositionCorrespondante;
	}

	@Override
	public Etudiant etudiantCorrespondant() {
		return etudiantCorrespondant;
	}

	// ---------------------------------METHODS-------------------------------//

	/**
	 * Methode modifiant l'état du voeu concerné
	 *
	 * @param la
	 *            classe "enum" créée par l'IDL (avec la valeur correspondante)
	 * @author Memer
	 */
	@Override
	public void modifierEtatVoeu(EtatsVoeu nouvelEtat) {
		ArrayList<VoeuImpl> listeVoeuTemp = new ArrayList<VoeuImpl>();
		switch (nouvelEtat.value()) {
		case EtatsVoeu._nonValide:
		case EtatsVoeu._valide:
		case EtatsVoeu._cloture:
			this.etatVoeu(nouvelEtat);
			break;
		case EtatsVoeu._OUI:
		case EtatsVoeu._NON:
			this.etatVoeu(nouvelEtat);
			listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements
					.ToArray(etudiantCorrespondant.listeVoeux());
			for (VoeuImpl v : listeVoeuTemp) {
				if (!v.equals(this)) {
					v.etatVoeu(EtatsVoeu.NON);
				}
			}
			break;
		case EtatsVoeu._OUIMAIS:
		case EtatsVoeu._NONMAIS:
			this.etatVoeu(nouvelEtat);
			listeVoeuTemp = (ArrayList<VoeuImpl>) UtilTraitements
					.ToArray(etudiantCorrespondant.listeVoeux());
			for (VoeuImpl v : listeVoeuTemp) {
				if (v.position() > this.position()) {
					v.etatVoeu(EtatsVoeu.NON);
				}
			}
			break;
		}
	}

	/**
	 * 
	 * Cette méthode compare l'etudiant du voeu courant avec celui du voeu passé
	 * en paramètre
	 * 
	 * @param Voeu
	 *            v le Voeu concerné
	 * @return rep entier indiquant le resultat de la comparaison (-1 moins bon,
	 *         0 égaux, 1 meilleur)
	 * @author Memer
	 * 
	 */
	@Override
	public int compareTo(Voeu v) {
		int rep = 0;
		try {
			if (this.etudiantCorrespondant.estMeilleurQue(v
					.etudiantCorrespondant())) {
				rep = 1;
			} else {
				rep = -1;
			}
		} catch (diplomesDifferentsException e) {
			System.out
					.println("Exception dans la methode CompareTo de VoeuImpl :");
			e.printStackTrace();
		}
		return rep;
	}

	/**
	 * Methode qui permet de determiner si un voeu doit rester dans le
	 * classement ou peut en être sorti selon son etat
	 * 
	 * @return booleen indiquant le "statut" du voeu
	 * @author Memer
	 */
	public boolean classable() {
		switch (etatVoeu.value()) {
		case EtatsVoeu._initial:
			return true;
		case EtatsVoeu._nonValide:
			return false;
		case EtatsVoeu._valide:
			return true;
		case EtatsVoeu._cloture:
			return true;
		case EtatsVoeu._OUI:
			return true;
		case EtatsVoeu._OUIMAIS:
			return true;
		case EtatsVoeu._NON:
			return false;
		case EtatsVoeu._NONMAIS:
			return false;

		}
		return true;
	}
}
