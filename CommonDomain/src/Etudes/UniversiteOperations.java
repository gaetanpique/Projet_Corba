package Etudes;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public interface UniversiteOperations
{
    /**
     * Read accessor for listeDesPropositions attribute
     * @return the attribute value
     */
    public Etudes.Proposition[] listeDesPropositions();

    /**
     * Write accessor for listeDesPropositions attribute
     * @param value the attribute value
     */
    public void listeDesPropositions(Etudes.Proposition[] value);

    /**
     * Operation getEtudiants
     */
    public Etudes.Etudiant[] getEtudiants();

    /**
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant);

    /**
     * Operation inscrire
     */
    public void inscrire(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException;

    /**
     * Operation connecter
     */
    public void connecter(Etudes.Etudiant numEtudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException;

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition getPropositionByFormation(Etudes.Master formation);

    /**
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis(Etudes.Proposition p)
        throws Etudes.PropositionDoesNotExistException;

    /**
     * Operation creerProposition
     */
    public void creerProposition(String intituleMaster, Etudes.Licence[] prerequis);

    /**
     * Operation majPrerequis
     */
    public void majPrerequis(Etudes.Proposition p, Etudes.Licence[] nouveauxPrerequis)
        throws Etudes.PropositionDoesNotExistException;

    /**
     * Operation getPositionEtudiant
     */
    public short getPositionEtudiant(Etudes.Etudiant sujet, Etudes.Licence formation)
        throws Etudes.pasDiplomeException;

    /**
     * Operation checkLicenceEtudiant
     */
    public boolean checkLicenceEtudiant(Etudes.Etudiant e, Etudes.Licence l);

}
