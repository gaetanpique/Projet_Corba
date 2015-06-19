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
     * Read accessor for propositionCorrespondante attribute
     */
    public Etudes.Proposition propositionCorrespondante()
    {
        return _tie.propositionCorrespondante();
    }

    /**
     * Read accessor for etudiantCorrespondant attribute
     */
    public Etudes.Etudiant etudiantCorrespondant()
    {
        return _tie.etudiantCorrespondant();
    }

    /**
     * Read accessor for position attribute
     */
    public short position()
    {
        return _tie.position();
    }

    /**
     * Write accessor for position attribute
     */
    public void position(short value)
    {
        _tie.position(value);
    }

    /**
     * Read accessor for classementEtudiant attribute
     */
    public short classementEtudiant()
    {
        return _tie.classementEtudiant();
    }

    /**
     * Write accessor for classementEtudiant attribute
     */
    public void classementEtudiant(short value)
    {
        _tie.classementEtudiant(value);
    }

    /**
     * Read accessor for etatVoeu attribute
     */
    public String etatVoeu()
    {
        return _tie.etatVoeu();
    }

    /**
     * Write accessor for etatVoeu attribute
     */
    public void etatVoeu(String value)
    {
        _tie.etatVoeu(value);
    }

    /**
     * Operation reponseOUI
     */
    public void reponseOUI()
    {
        _tie.reponseOUI();
    }

    /**
     * Operation reponseOUIMAIS
     */
    public void reponseOUIMAIS()
    {
        _tie.reponseOUIMAIS();
    }

    /**
     * Operation reponseNONMAIS
     */
    public void reponseNONMAIS()
    {
        _tie.reponseNONMAIS();
    }

    /**
     * Operation reponseNON
     */
    public void reponseNON()
    {
        _tie.reponseNON();
    }

    /**
     * Operation accepterCandidature
     */
    public void accepterCandidature()
    {
        _tie.accepterCandidature();
    }

    /**
     * Operation refuserCandidature
     */
    public void refuserCandidature()
    {
        _tie.refuserCandidature();
    }

    /**
     * Operation majClassement
     */
    public void majClassement(short classement)
    {
        _tie.majClassement( classement);
    }

}
