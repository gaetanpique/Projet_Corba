package Etudes;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Read accessor for nom attribute
     * @return the attribute value
     */
    public String nom();

    /**
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant);

    /**
     * Operation demanderConnexion
     */
    public void demanderConnexion(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException;

    /**
     * Operation demanderInscription
     */
    public void demanderInscription(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException;

    /**
     * Operation referencer
     */
    public void referencer(Etudes.Universite universiteConnecte);

    /**
     * Operation dereferencer
     */
    public void dereferencer(Etudes.Universite universiteDeconnecte);

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
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Master formation);

}
