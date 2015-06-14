package Etudes;

/**
 * Exception definition : EtudiantDejaInscritException
 * 
 * @author OpenORB Compiler
 */
public final class EtudiantDejaInscritException extends org.omg.CORBA.UserException
{
    /**
     * Exception member numEtudiant
     */
    public String numEtudiant;

    /**
     * Default constructor
     */
    public EtudiantDejaInscritException()
    {
        super(EtudiantDejaInscritExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param numEtudiant numEtudiant exception member
     */
    public EtudiantDejaInscritException(String numEtudiant)
    {
        super(EtudiantDejaInscritExceptionHelper.id());
        this.numEtudiant = numEtudiant;
    }

    /**
     * Full constructor with fields initialization
     * @param numEtudiant numEtudiant exception member
     */
    public EtudiantDejaInscritException(String orb_reason, String numEtudiant)
    {
        super(EtudiantDejaInscritExceptionHelper.id() +" " +  orb_reason);
        this.numEtudiant = numEtudiant;
    }

}
