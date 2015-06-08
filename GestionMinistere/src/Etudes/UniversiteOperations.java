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
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant);

    /**
     * Operation inscrire
     */
    public void inscrire(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnu;

    /**
     * Operation connecter
     */
    public void connecter(Etudes.Etudiant numEtudiant, String motDePasse)
        throws Etudes.EtudiantInconnu;

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition getPropositionByFormation(Etudes.Master formation);

    /**
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis(Etudes.Master formation)
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
