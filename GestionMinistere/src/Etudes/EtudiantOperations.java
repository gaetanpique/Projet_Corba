package Etudes;

/**
 * Interface definition : Etudiant
 * 
 * @author OpenORB Compiler
 */
public interface EtudiantOperations
{
    /**
     * Read accessor for resultats attribute
     * @return the attribute value
     */
    public Etudes.Resultat resultats();

    /**
     * Write accessor for resultats attribute
     * @param value the attribute value
     */
    public void resultats(Etudes.Resultat value);

    /**
     * Operation estMeilleurQue
     */
    public boolean estMeilleurQue(Etudes.Etudiant aComparer)
        throws Etudes.diplomesDifferents;

    /**
     * Operation getUniversite
     */
    public Etudes.Universite getUniversite();

}
