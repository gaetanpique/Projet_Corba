package Etudes;

/**
 * Interface definition : Proposition
 * 
 * @author OpenORB Compiler
 */
public interface PropositionOperations
{
    /**
     * Read accessor for masterPropose attribute
     * @return the attribute value
     */
    public Etudes.Master masterPropose();

    /**
     * Read accessor for prerequis attribute
     * @return the attribute value
     */
    public Etudes.Licence[] prerequis();

    /**
     * Write accessor for prerequis attribute
     * @param value the attribute value
     */
    public void prerequis(Etudes.Licence[] value);

    /**
     * Operation addPrerequis
     */
    public void addPrerequis(Etudes.Licence l)
        throws Etudes.prerequisDejaExistantException;

}
