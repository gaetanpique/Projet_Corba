package Etudes;

/**
 * Interface definition : Resultat
 * 
 * @author OpenORB Compiler
 */
public interface ResultatOperations
{
    /**
     * Read accessor for codeObtention attribute
     * @return the attribute value
     */
    public String codeObtention();

    /**
     * Read accessor for moyenne attribute
     * @return the attribute value
     */
    public float moyenne();

    /**
     * Write accessor for moyenne attribute
     * @param value the attribute value
     */
    public void moyenne(float value);

    /**
     * Operation isValideForFormation
     */
    public boolean isValideForFormation(Etudes.Formation formation);

}
