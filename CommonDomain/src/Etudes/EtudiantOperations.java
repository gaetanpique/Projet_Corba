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
     * Read accessor for listeVoeux attribute
     * @return the attribute value
     */
    public Etudes.Voeu[] listeVoeux();

    /**
     * Operation estMeilleurQue
     */
    public boolean estMeilleurQue(Etudes.Etudiant aComparer)
        throws Etudes.diplomesDifferentsException;

    /**
     * Operation getPositionEtudiant
     */
    public short getPositionEtudiant();

    /**
     * Operation getUniversite
     */
    public Etudes.Universite getUniversite();

}
