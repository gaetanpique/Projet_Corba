package Etudes;

/**
 * Interface definition : Formation
 * 
 * @author OpenORB Compiler
 */
public class FormationPOATie extends FormationPOA
{

    //
    // Private reference to implementation object
    //
    private FormationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public FormationPOATie(FormationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public FormationPOATie(FormationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public FormationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(FormationOperations delegate_)
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

}
