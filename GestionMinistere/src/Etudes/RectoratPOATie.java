package Etudes;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class RectoratPOATie extends RectoratPOA
{

    //
    // Private reference to implementation object
    //
    private RectoratOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public RectoratOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(RectoratOperations delegate_)
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
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant)
    {
        return _tie.getEtudiantByNumero( numEtudiant);
    }

    /**
     * Operation demanderConnexion
     */
    public void demanderConnexion(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnu
    {
        _tie.demanderConnexion( etudiant,  motDePasse);
    }

    /**
     * Operation demanderInscription
     */
    public void demanderInscription(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnu
    {
        _tie.demanderInscription( etudiant,  motDePasse);
    }

    /**
     * Operation getListUniversites
     */
    public Etudes.Universite[] getListUniversites()
    {
        return _tie.getListUniversites();
    }

    /**
     * Operation getAccreditationsByUniversite
     */
    public Etudes.Formation[] getAccreditationsByUniversite(Etudes.Universite universite)
    {
        return _tie.getAccreditationsByUniversite( universite);
    }

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Master formation)
    {
        return _tie.getPropositionByFormation( formation);
    }

}
