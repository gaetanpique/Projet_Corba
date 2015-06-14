package Etudes;

/**
 * Interface definition : Proposition
 * 
 * @author OpenORB Compiler
 */
public class PropositionPOATie extends PropositionPOA
{

    //
    // Private reference to implementation object
    //
    private PropositionOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public PropositionPOATie(PropositionOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public PropositionPOATie(PropositionOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public PropositionOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(PropositionOperations delegate_)
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
     * Operation isCompatible
     */
    public boolean isCompatible(Etudes.Resultat resultatEtudiant)
    {
        return _tie.isCompatible( resultatEtudiant);
    }

    /**
     * Read accessor for universiteSource attribute
     */
    public Etudes.Universite universiteSource()
    {
        return _tie.universiteSource();
    }

    /**
     * Read accessor for masterPropose attribute
     */
    public Etudes.Master masterPropose()
    {
        return _tie.masterPropose();
    }

    /**
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis()
    {
        return _tie.getPrerequis();
    }

}
