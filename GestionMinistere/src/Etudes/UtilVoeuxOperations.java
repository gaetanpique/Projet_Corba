package Etudes;

/**
 * Interface definition : UtilVoeux
 * 
 * @author OpenORB Compiler
 */
public interface UtilVoeuxOperations
{
    /**
     * Operation getMeilleurePropositionByEtudiant
     */
    public Etudes.Voeu[] getMeilleurePropositionByEtudiant(Etudes.Etudiant etudiant);

    /**
     * Operation soumettreVoeu
     */
    public void soumettreVoeu(Etudes.Proposition aSoumettre, Etudes.Etudiant soumetteur)
        throws Etudes.NombreMaxDeVoeuxAtteint;

    /**
     * Operation getVoeuxByEtudiant
     */
    public Etudes.Voeu[] getVoeuxByEtudiant(Etudes.Etudiant etudiant);

    /**
     * Operation getVoeuxByUniversite
     */
    public Etudes.Voeu[] getVoeuxByUniversite(Etudes.Universite etudiant);

    /**
     * Operation getVoeuxByRectorat
     */
    public Etudes.Voeu[] getVoeuxByRectorat(Etudes.Rectorat rectorat);

}
