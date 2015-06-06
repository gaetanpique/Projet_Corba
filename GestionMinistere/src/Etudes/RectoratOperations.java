package Etudes;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant);

    /**
     * Operation demanderConnexion
     */
    public boolean demanderConnexion(Etudes.Etudiant etudiant, String motDePasse);

    /**
     * Operation demanderInscription
     */
    public boolean demanderInscription(Etudes.Etudiant etudiant, String motDePasse);

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
