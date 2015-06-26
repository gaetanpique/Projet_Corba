import Etudes.Rectorat;


public class Phase1To2 {
	private MainTest main;
	public Phase1To2(MainTest main)
	{
		this.main = main;
		this.testerPrerequisVoeux();
	}
	
	public void testerPrerequisVoeux()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerPrerequisVoeux ");
		System.out.println("- Passage de la phase 1 à la phase 2 : DEBUT ");

		Rectorat[] rectorats = this.main.ministere.getListRectorats();
		for (Rectorat r : rectorats)
		{
			r.validerCandidatures();
		}
		System.out.println("- Passage de la phase 1 à la phase 2 : FIN ");
	}

}
