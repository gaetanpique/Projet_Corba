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

    /**
     * Operation referencer
     */
    public void referencer(Etudes.Rectorat nomRectoratConnecte);

    /**
     * Operation dereferencer
     */
    public void dereferencer(Etudes.Rectorat rectoratDeconnecte);

}
