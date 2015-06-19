package Etudes;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public class UniversitePOATie extends UniversitePOA
{

    //
    // Private reference to implementation object
    //
    private UniversiteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public UniversitePOATie(UniversiteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public UniversitePOATie(UniversiteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public UniversiteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(UniversiteOperations delegate_)
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
     * Read accessor for listeDesPropositions attribute
     */
    public Etudes.Proposition[] listeDesPropositions()
    {
        return _tie.listeDesPropositions();
    }

    /**
     * Write accessor for listeDesPropositions attribute
     */
    public void listeDesPropositions(Etudes.Proposition[] value)
    {
        _tie.listeDesPropositions(value);
    }

    /**
     * Operation getEtudiants
     */
    public Etudes.Etudiant[] getEtudiants()
    {
        return _tie.getEtudiants();
    }

    /**
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant)
    {
        return _tie.getEtudiantByNumero( numEtudiant);
    }

    /**
     * Operation inscrire
     */
    public void inscrire(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException
    {
        _tie.inscrire( etudiant,  motDePasse);
    }

    /**
     * Operation connecter
     */
    public void connecter(Etudes.Etudiant numEtudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException
    {
        _tie.connecter( numEtudiant,  motDePasse);
    }

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition getPropositionByFormation(Etudes.Master formation)
    {
        return _tie.getPropositionByFormation( formation);
    }

    /**
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis(Etudes.Proposition p)
        throws Etudes.PropositionDoesNotExistException
    {
        return _tie.getPrerequis( p);
    }

    /**
     * Operation creerProposition
     */
    public void creerProposition(String intituleMaster, Etudes.Licence[] prerequis)
    {
        _tie.creerProposition( intituleMaster,  prerequis);
    }

    /**
     * Operation majPrerequis
     */
    public void majPrerequis(Etudes.Proposition p, Etudes.Licence[] nouveauxPrerequis)
        throws Etudes.PropositionDoesNotExistException
    {
        _tie.majPrerequis( p,  nouveauxPrerequis);
    }

    /**
     * Operation getPositionEtudiant
     */
    public short getPositionEtudiant(Etudes.Etudiant sujet, Etudes.Licence formation)
        throws Etudes.pasDiplomeException
    {
        return _tie.getPositionEtudiant( sujet,  formation);
    }

    /**
     * Operation checkLicenceEtudiant
     */
    public boolean checkLicenceEtudiant(Etudes.Etudiant e, Etudes.Licence l)
    {
        return _tie.checkLicenceEtudiant( e,  l);
    }

}
