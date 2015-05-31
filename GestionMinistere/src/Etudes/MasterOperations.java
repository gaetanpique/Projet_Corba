package Etudes;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public interface MasterOperations extends Etudes.FormationOperations
{
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

}
