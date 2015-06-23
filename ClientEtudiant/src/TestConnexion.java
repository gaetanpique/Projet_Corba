import Etudes.Etudiant;
import Etudes.EtudiantInconnuException;
import Etudes.EtudiantPasInscritException;
import Etudes.MotDePasseErroneException;


public class TestConnexion {
	private MainTest main;
	
	private String numEtudiantNonInscrit = "2345412";
	
	public TestConnexion(MainTest main)
	{
		this.main = main;
		this.testerConnexionEtudiantNonInscrit();
		this.testerConnexionEtudiantNonExistant();
		this.testerConnexionEtudiantMotDePasseEronne();
		this.testConnexionOk();
	}
	
	public void testerConnexionEtudiantNonExistant()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TesterConnexionEtudiantNonExistant ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero("Mauvais Numéro");
			System.out.println("- ERREUR : Etudiant récupéré");
			main.choisi.demanderConnexion(e, main.motDePasseSaisi);
			System.out.println("- ERREUR : Connexion réussie");
		} catch (EtudiantInconnuException e) {
			System.out.println("- Test OK : EtudiantInconnuException");
		} catch (EtudiantPasInscritException e1) {
			System.out.println("- ERREUR : EtudiantPasInscritException ???");
		} catch (MotDePasseErroneException e1) {
			System.out.println("- ERREUR : MotDePasseErroneException ???");
		}
	}
	
	public void testerConnexionEtudiantNonInscrit()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TesterConnexionEtudiantNonInscrit ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero(this.numEtudiantNonInscrit);
			System.out.println("- Etudiant récupéré");
			main.choisi.demanderConnexion(e, main.motDePasseSaisi);
			System.out.println("- ERREUR : Connexion réussie");
		} catch (EtudiantInconnuException e) {
			System.out.println("- ERREUR : EtudiantInconnuException ???");
		} catch (EtudiantPasInscritException e1) {
			System.out.println("- Test OK : EtudiantPasInscritException");
		} catch (MotDePasseErroneException e1) {
			System.out.println("- ERREUR : MotDePasseErroneException ???");
		}
	}
	
	public void testerConnexionEtudiantMotDePasseEronne()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TesterConnexionEtudiantMotDePasseEronne ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero(main.numEtudiantSaisi);
			System.out.println("- Etudiant récupéré");
			main.choisi.demanderConnexion(e, "Mauvais MDP");
			System.out.println("- ERREUR : Connexion réussie");
		} catch (EtudiantInconnuException e) {
			System.out.println("- ERREUR : EtudiantInconnuException ???");
		} catch (EtudiantPasInscritException e1) {
			System.out.println("- ERREUR : EtudiantPasInscritException ???");
		} catch (MotDePasseErroneException e1) {
			System.out.println("- Test OK : MotDePasseErroneException");
		}
	}
	
	public void testConnexionOk()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("- TestConnexionOk ");
		
		try {
			Etudiant e = main.choisi.getEtudiantByNumero(main.numEtudiantSaisi);
			System.out.println("- Etudiant récupéré");
			main.choisi.demanderConnexion(e, main.motDePasseSaisi);
			System.out.println("- Test OK : Connexion réussie");
			main.etudiantConnecte = e;
		} catch (EtudiantInconnuException e) {
			System.out.println("- ERREUR : EtudiantInconnuException ???");
		} catch (EtudiantPasInscritException e1) {
			System.out.println("- ERREUR : EtudiantPasInscritException ???");
		} catch (MotDePasseErroneException e1) {
			System.out.println("- ERREUR : MotDePasseErroneException ???");
		}
	}
}
