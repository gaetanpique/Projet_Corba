import Etudes.Etudiant;
import Etudes.EtudiantDejaInscritException;
import Etudes.EtudiantInconnuException;


public class TestInscription {
	private MainTest main;
	
	public TestInscription(MainTest main)
	{
		this.main = main;
		this.testerInscriptionEtudiantNonExistant();
		this.testInscriptionOk();
		this.testerInscriptionEtudiantDejaInscrit();
	}
	
	public void testerInscriptionEtudiantNonExistant()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TesterInscriptionEtudiantNonExistant ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero("Mauvais Num�ro");
			System.out.println("- ERREUR : Etudiant r�cup�r�");
			main.choisi.demanderInscription(e, main.motDePasseSaisi);
			System.out.println("- ERREUR : Inscription r�ussie");
		} catch (EtudiantDejaInscritException e) {
			System.out.println("- ERREUR : EtudiantDejaInscritException ???");
		} catch (EtudiantInconnuException e) {
			System.out.println("- Test OK : EtudiantInconnuException");
		}
	}
	
	public void testerInscriptionEtudiantDejaInscrit()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TesterInscriptionEtudiantDejaInscrit ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero(main.numEtudiantSaisi);
			System.out.println("- Etudiant r�cup�r�");
			main.choisi.demanderInscription(e, main.motDePasseSaisi);
			System.out.println("- ERREUR : Inscription r�ussie");
		} catch (EtudiantDejaInscritException e) {
			System.out.println("- Test OK : EtudiantDejaInscritException");
		} catch (EtudiantInconnuException e) {
			System.out.println("- ERREUR : EtudiantInconnuException ???");
		}
	}
	
	public void testInscriptionOk()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TestInscriptionOk ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero(main.numEtudiantSaisi);
			System.out.println("- Etudiant r�cup�r�");
			main.choisi.demanderInscription(e, main.motDePasseSaisi);
			System.out.println("- Test OK : Inscription r�ussie");
		} catch (EtudiantDejaInscritException e) {
			System.out.println("- ERREUR : EtudiantDejaInscritException ???");
		} catch (EtudiantInconnuException e) {
			System.out.println("- ERREUR : EtudiantInconnuException ???");
		}
	}
	
}
