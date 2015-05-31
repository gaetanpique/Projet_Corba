package Etudes;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public interface MinistereOperations
{
    /**
     * Operation getListFormations
     */
    public Etudes.Formation[] getListFormations();

    /**
     * Operation getListRectorats
     */
    public Etudes.Rectorat[] getListRectorats();

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Formation formation);

}
