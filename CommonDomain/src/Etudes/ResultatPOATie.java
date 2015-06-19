package Etudes;

/**
 * Interface definition : Resultat
 * 
 * @author OpenORB Compiler
 */
public class ResultatPOATie extends ResultatPOA
{

    //
    // Private reference to implementation object
    //
    private ResultatOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ResultatPOATie(ResultatOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ResultatPOATie(ResultatOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ResultatOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ResultatOperations delegate_)
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
     * Read accessor for codeObtention attribute
     */
    public String codeObtention()
    {
        return _tie.codeObtention();
    }

    /**
     * Read accessor for moyenne attribute
     */
    public float moyenne()
    {
        return _tie.moyenne();
    }

    /**
     * Read accessor for position attribute
     */
    public short position()
    {
        return _tie.position();
    }

}
