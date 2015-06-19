package Etudes;

/**
 * Exception definition : diplomesDifferentsException
 * 
 * @author OpenORB Compiler
 */
public final class diplomesDifferentsException extends org.omg.CORBA.UserException
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
    public diplomesDifferentsException()
    {
        super(diplomesDifferentsExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param nomEtudiant nomEtudiant exception member
     * @param nomDiplome nomDiplome exception member
     * @param nomEtudiantDiff nomEtudiantDiff exception member
     */
    public diplomesDifferentsException(String nomEtudiant, String nomDiplome, String nomEtudiantDiff)
    {
        super(diplomesDifferentsExceptionHelper.id());
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
    public diplomesDifferentsException(String orb_reason, String nomEtudiant, String nomDiplome, String nomEtudiantDiff)
    {
        super(diplomesDifferentsExceptionHelper.id() +" " +  orb_reason);
        this.nomEtudiant = nomEtudiant;
        this.nomDiplome = nomDiplome;
        this.nomEtudiantDiff = nomEtudiantDiff;
    }

}
