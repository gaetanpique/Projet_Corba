package Etudes;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public class MinisterePOATie extends MinisterePOA
{

    //
    // Private reference to implementation object
    //
    private MinistereOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public MinisterePOATie(MinistereOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public MinisterePOATie(MinistereOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public MinistereOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(MinistereOperations delegate_)
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
     * Operation getListFormations
     */
    public Etudes.Formation[] getListFormations()
    {
        return _tie.getListFormations();
    }

    /**
     * Operation getListRectorats
     */
    public Etudes.Rectorat[] getListRectorats()
    {
        return _tie.getListRectorats();
    }

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Formation formation)
    {
        return _tie.getPropositionByFormation( formation);
    }

}
