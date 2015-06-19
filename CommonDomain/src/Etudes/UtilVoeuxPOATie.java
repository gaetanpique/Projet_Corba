package Etudes;

/**
 * Interface definition : UtilVoeux
 * 
 * @author OpenORB Compiler
 */
public class UtilVoeuxPOATie extends UtilVoeuxPOA
{

    //
    // Private reference to implementation object
    //
    private UtilVoeuxOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public UtilVoeuxPOATie(UtilVoeuxOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public UtilVoeuxPOATie(UtilVoeuxOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public UtilVoeuxOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(UtilVoeuxOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation getMeilleurePropositionByEtudiant
     */
    public Etudes.Voeu[] getMeilleurePropositionByEtudiant(Etudes.Etudiant etudiant)
    {
        return _tie.getMeilleurePropositionByEtudiant( etudiant);
    }

    /**
     * Operation soumettreVoeu
     */
    public void soumettreVoeu(Etudes.Proposition aSoumettre, Etudes.Etudiant soumetteur, short position)
        throws Etudes.NombreMaxDeVoeuxAtteintException
    {
        _tie.soumettreVoeu( aSoumettre,  soumetteur,  position);
    }

    /**
     * Operation getVoeuxByEtudiant
     */
    public Etudes.Voeu[] getVoeuxByEtudiant(Etudes.Etudiant etudiant)
    {
        return _tie.getVoeuxByEtudiant( etudiant);
    }

    /**
     * Operation getVoeuxByUniversite
     */
    public Etudes.Voeu[] getVoeuxByUniversite(Etudes.Universite universite)
    {
        return _tie.getVoeuxByUniversite( universite);
    }

    /**
     * Operation getVoeuxByRectorat
     */
    public Etudes.Voeu[] getVoeuxByRectorat(Etudes.Rectorat rectoratConcerne)
    {
        return _tie.getVoeuxByRectorat( rectoratConcerne);
    }

    /**
     * Operation classerVoeuxParProposition
     */
    public void classerVoeuxParProposition(Etudes.Proposition p)
    {
        _tie.classerVoeuxParProposition( p);
    }

    /**
     * Operation classerVoeuxParUniversite
     */
    public void classerVoeuxParUniversite(Etudes.Universite u)
    {
        _tie.classerVoeuxParUniversite( u);
    }

}
