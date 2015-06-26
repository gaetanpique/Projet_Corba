import Etudes.EtatsVoeu;
import Etudes.Etudiant;
import Etudes.Rectorat;
import Etudes.Universite;
import Etudes.Voeu;


public class Phase3To4 {

	private MainTest main;


	public Phase3To4(MainTest main)
	{
		this.main = main;
		this.testerReponseEtudiant();
	}
	
	
	public void testerReponseEtudiant()
	{
		
			System.out.println("--------------------------------------------------");
			System.out.println("- testerReponseEtudiant ");
			System.out.println("- Reponse des etudiants : DEBUT ");
			Rectorat[] rectorats = this.main.ministere.getListRectorats();
			for (Rectorat r : rectorats)
			{
				Universite[] universites = r.getListUniversites();
				for (Universite u : universites)
				{
					Etudiant[] etudiants = u.getEtudiants();
					for (Etudiant e : etudiants)
					{
						Voeu[] voeux  = main.utilVoeux.getMeilleurePropositionByEtudiant(e);
						for (Voeu v : voeux)
						{	
							if (v.etatVoeu().value() == EtatsVoeu.accepte.value())
							{
								switch (v.position())
								{
								case 1:
									v.modifierEtatVoeu(EtatsVoeu.OUI);
									break;
								case 2:
								case 3:
									v.modifierEtatVoeu(EtatsVoeu.OUIMAIS);
									break;
								case 4:
									v.modifierEtatVoeu(EtatsVoeu.NONMAIS);
									break;
								case 5:
									v.modifierEtatVoeu(EtatsVoeu.NON);
									break;
									
								
								}
								break;
							}
							
						}
					}
				}
			}
			System.out.println("- Reponse des etudiants : FIN ");
			
			
			
			
	}


}
