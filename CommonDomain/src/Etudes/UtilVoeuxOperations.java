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
    public void soumettreVoeu(Etudes.Proposition aSoumettre, Etudes.Etudiant soumetteur, short position)
        throws Etudes.NombreMaxDeVoeuxAtteintException;

    /**
     * Operation getVoeuxByEtudiant
     */
    public Etudes.Voeu[] getVoeuxByEtudiant(Etudes.Etudiant etudiant);

    /**
     * Operation getVoeuxByUniversite
     */
    public Etudes.Voeu[] getVoeuxByUniversite(Etudes.Universite universite);

    /**
     * Operation getVoeuxByRectorat
     */
    public Etudes.Voeu[] getVoeuxByRectorat(Etudes.Rectorat rectoratConcerne);

    /**
     * Operation classerVoeuxParProposition
     */
    public void classerVoeuxParProposition(Etudes.Proposition p);

    /**
     * Operation classerVoeuxParUniversite
     */
    public void classerVoeuxParUniversite(Etudes.Universite u);

}
