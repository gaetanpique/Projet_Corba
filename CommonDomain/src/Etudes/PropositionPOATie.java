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
     * Read accessor for masterPropose attribute
     */
    public Etudes.Master masterPropose()
    {
        return _tie.masterPropose();
    }

    /**
     * Read accessor for prerequis attribute
     */
    public Etudes.Licence[] prerequis()
    {
        return _tie.prerequis();
    }

    /**
     * Write accessor for prerequis attribute
     */
    public void prerequis(Etudes.Licence[] value)
    {
        _tie.prerequis(value);
    }

    /**
     * Operation addPrerequis
     */
    public void addPrerequis(Etudes.Licence l)
        throws Etudes.prerequisDejaExistantException
    {
        _tie.addPrerequis( l);
    }

}
