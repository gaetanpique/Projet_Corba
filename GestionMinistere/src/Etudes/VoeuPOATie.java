package Etudes;

/**
 * Interface definition : Voeu
 * 
 * @author OpenORB Compiler
 */
public class VoeuPOATie extends VoeuPOA
{

    //
    // Private reference to implementation object
    //
    private VoeuOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public VoeuPOATie(VoeuOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public VoeuPOATie(VoeuOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public VoeuOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(VoeuOperations delegate_)
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
     * Read accessor for universite attribute
     */
    public Etudes.Universite universite()
    {
        return _tie.universite();
    }

    /**
     * Read accessor for formation attribute
     */
    public Etudes.Master formation()
    {
        return _tie.formation();
    }

    /**
     * Operation valider
     */
    public void valider()
    {
        _tie.valider();
    }

    /**
     * Operation cloturer
     */
    public void cloturer()
    {
        _tie.cloturer();
    }

    /**
     * Operation accepter
     */
    public void accepter()
    {
        _tie.accepter();
    }

    /**
     * Operation refuser
     */
    public void refuser()
    {
        _tie.refuser();
    }

    /**
     * Operation refuserDefinitevement
     */
    public void refuserDefinitevement()
    {
        _tie.refuserDefinitevement();
    }

    /**
     * Operation majClassement
     */
    public void majClassement(short classement)
    {
        _tie.majClassement( classement);
    }

}
