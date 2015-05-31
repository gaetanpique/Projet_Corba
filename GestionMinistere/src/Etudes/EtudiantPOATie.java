package Etudes;

/**
 * Interface definition : Etudiant
 * 
 * @author OpenORB Compiler
 */
public class EtudiantPOATie extends EtudiantPOA
{

    //
    // Private reference to implementation object
    //
    private EtudiantOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EtudiantPOATie(EtudiantOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EtudiantPOATie(EtudiantOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EtudiantOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EtudiantOperations delegate_)
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
     * Read accessor for resultats attribute
     */
    public Etudes.Resultat resultats()
    {
        return _tie.resultats();
    }

    /**
     * Write accessor for resultats attribute
     */
    public void resultats(Etudes.Resultat value)
    {
        _tie.resultats(value);
    }

    /**
     * Operation estMeilleurQue
     */
    public boolean estMeilleurQue(Etudes.Etudiant aComparer)
        throws Etudes.diplomesDifferents
    {
        return _tie.estMeilleurQue( aComparer);
    }

}
