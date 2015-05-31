package Etudes;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public interface UniversiteOperations
{
    /**
     * Operation getEtudiants
     */
    public Etudes.Etudiant[] getEtudiants();

    /**
     * Operation demanderConnexion
     */
    public boolean demanderConnexion(String numEtudiant, String motDePasse);

    /**
     * Operation demanderInscription
     */
    public boolean demanderInscription(String numEtudiant, String motDePasse);

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Formation formation);

    /**
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis(Etudes.Formation formation)
        throws Etudes.PropositionDoesNotExist;

    /**
     * Operation creerProposition
     */
    public void creerProposition(Etudes.Formation nouvelleFormation, Etudes.Licence[] prerequis);

    /**
     * Operation majPrerequis
     */
    public void majPrerequis(Etudes.Formation formation, Etudes.Licence[] nouveauxPrerequis);

    /**
     * Operation getClassement
     */
    public short getClassement(Etudes.Etudiant sujet, Etudes.Licence formation)
        throws Etudes.pasDiplomeException;

}
