package Etudes;

/**
 * Interface definition : Licence
 * 
 * @author OpenORB Compiler
 */
public class LicencePOATie extends LicencePOA
{

    //
    // Private reference to implementation object
    //
    private LicenceOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public LicencePOATie(LicenceOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public LicencePOATie(LicenceOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public LicenceOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(LicenceOperations delegate_)
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
     * Read accessor for intitule attribute
     */
    public String intitule()
    {
        return _tie.intitule();
    }

    /**
     * Operation _equals
     */
    public boolean _equals(Etudes.Formation f)
    {
        return _tie._equals( f);
    }

}
