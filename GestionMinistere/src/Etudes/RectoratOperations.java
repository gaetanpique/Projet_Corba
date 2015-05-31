package Etudes;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Operation demanderConnexion
     */
    public boolean demanderConnexion(String numEtudiant, String motDePasse);

    /**
     * Operation demanderInscription
     */
    public boolean demanderInscription(String numEtudiant, String motDePasse);

    /**
     * Operation getListUniversites
     */
    public Etudes.Universite[] getListUniversites();

    /**
     * Operation getAccreditationsByUniversite
     */
    public Etudes.Formation[] getAccreditationsByUniversite(Etudes.Universite universite);

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Formation formation);

}
