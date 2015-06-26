import Etudes.Rectorat;
import Etudes.Universite;


public class Phase2To3 {
	
	private MainTest main;
	
	public Phase2To3(MainTest main)
	{
		this.main = main;
		this.testerClassementEtudiants();
	}
	
	public void testerClassementEtudiants()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- testerClassementEtudiants ");
		System.out.println("- Passage de la phase 2 à la phase 3 (ou 3 à 4) : DEBUT ");

		Rectorat[] rectorats = this.main.ministere.getListRectorats();
		for (Rectorat r : rectorats)
		{
			Universite[] universites = r.getListUniversites();
			for (Universite u : universites)
			{
				u.classerVoeux();
			}
		}
		System.out.println("- Passage de la phase 2 à la phase 3 : FIN ");
	}
	
	

	
	
	
}
