package Etudes;

/**
 * Exception definition : diplomesDifferents
 * 
 * @author OpenORB Compiler
 */
public final class diplomesDifferents extends org.omg.CORBA.UserException
{
    /**
     * Exception member nomEtudiant
     */
    public String nomEtudiant;

    /**
     * Exception member nomDiplome
     */
    public String nomDiplome;

    /**
     * Exception member nomEtudiantDiff
     */
    public String nomEtudiantDiff;

    /**
     * Default constructor
     */
    public diplomesDifferents()
    {
        super(diplomesDifferentsHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param nomEtudiant nomEtudiant exception member
     * @param nomDiplome nomDiplome exception member
     * @param nomEtudiantDiff nomEtudiantDiff exception member
     */
    public diplomesDifferents(String nomEtudiant, String nomDiplome, String nomEtudiantDiff)
    {
        super(diplomesDifferentsHelper.id());
        this.nomEtudiant = nomEtudiant;
        this.nomDiplome = nomDiplome;
        this.nomEtudiantDiff = nomEtudiantDiff;
    }

    /**
     * Full constructor with fields initialization
     * @param nomEtudiant nomEtudiant exception member
     * @param nomDiplome nomDiplome exception member
     * @param nomEtudiantDiff nomEtudiantDiff exception member
     */
    public diplomesDifferents(String orb_reason, String nomEtudiant, String nomDiplome, String nomEtudiantDiff)
    {
        super(diplomesDifferentsHelper.id() +" " +  orb_reason);
        this.nomEtudiant = nomEtudiant;
        this.nomDiplome = nomDiplome;
        this.nomEtudiantDiff = nomEtudiantDiff;
    }

}
