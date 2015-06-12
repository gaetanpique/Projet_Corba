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
    public void demanderConnexion(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnu;

    /**
     * Operation demanderInscription
     */
    public void demanderInscription(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnu;

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
