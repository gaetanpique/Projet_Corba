package Ministere;

import java.util.Calendar;

import Etudes.Formation;
import Etudes.MinisterePOA;
import Etudes.Proposition;
import Etudes.Rectorat;

public class MinistereImpl extends MinisterePOA {

	@Override
	public Formation[] getListFormations() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListFormations()");
		return new Formation[1];
	}

	@Override
	public Rectorat[] getListRectorats() {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getListRectorats()");
		return new Rectorat[1];
	}

	@Override
	public Proposition[] getPropositionByFormation(Formation formation) {
		System.out.println(Calendar.getInstance().getTime().toString() + " : MinistereImpl.getPropositionByFormation()");
		return new Proposition[1];
	}

}
