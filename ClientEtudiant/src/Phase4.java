
	import Etudes.EtatsVoeu;
	import Etudes.Etudiant;
	import Etudes.Rectorat;
	import Etudes.Universite;
	import Etudes.Voeu;


	public class Phase4 {

		private MainTest main;


		public Phase4(MainTest main)
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
						u.classerVoeux();
						Etudiant[] etudiants = u.getEtudiants();
						for (Etudiant e : etudiants)
						{
							Voeu[] voeux  = main.utilVoeux.getMeilleurePropositionByEtudiant(e);
							for (Voeu v : voeux)
							{	

								if (v.classable())
								{
									v.modifierEtatVoeu(EtatsVoeu.OUI);
									break;
								}
								
								
							}
								
						}
					}
				}
				System.out.println("- Reponse des etudiants : FIN ");
			}
				
				
				
				
				
}


	


