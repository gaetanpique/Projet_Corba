package Etudes;

/**
 * Interface definition : Proposition
 * 
 * @author OpenORB Compiler
 */
public interface PropositionOperations
{
    /**
     * Operation isCompatible
     */
    public boolean isCompatible(Etudes.Resultat resultatEtudiant);

    /**
     * Read accessor for universiteSource attribute
     * @return the attribute value
     */
    public Etudes.Universite universiteSource();

    /**
     * Read accessor for masterPropose attribute
     * @return the attribute value
     */
    public Etudes.Master masterPropose();

    /**
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis();

}
