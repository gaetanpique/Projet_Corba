package Etudes;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public class MasterPOATie extends MasterPOA
{

    //
    // Private reference to implementation object
    //
    private MasterOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public MasterPOATie(MasterOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public MasterPOATie(MasterOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public MasterOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(MasterOperations delegate_)
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
     * Read accessor for intitule attribute
     */
    public String intitule()
    {
        return _tie.intitule();
    }

}
