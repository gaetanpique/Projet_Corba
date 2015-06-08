import Etudes.Etudiant;
import Etudes.EtudiantPOA;
import Etudes.Resultat;
import Etudes.diplomesDifferents;


public class EtudiantImpl extends EtudiantPOA {

	private Resultat resultats;

	@Override
	public Resultat resultats() {
		return resultats;
	}

	@Override
	public void resultats(Resultat value) {
		resultats = value;
	}

	@Override
	public boolean estMeilleurQue(Etudiant aComparer) throws diplomesDifferents {
		ResultatImpl res1 = (ResultatImpl)this.resultats();
		ResultatImpl res2 = (ResultatImpl)aComparer.resultats();
		
		if (!res1.getLicence().equals(res2.getLicence()))
				throw new diplomesDifferents();
		return (res1.moyenne() > res2.moyenne());
	}

}
