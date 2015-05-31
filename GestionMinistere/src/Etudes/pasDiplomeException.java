package Etudes;

/**
 * Exception definition : pasDiplomeException
 * 
 * @author OpenORB Compiler
 */
public final class pasDiplomeException extends org.omg.CORBA.UserException
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
     * Default constructor
     */
    public pasDiplomeException()
    {
        super(pasDiplomeExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param nomEtudiant nomEtudiant exception member
     * @param nomDiplome nomDiplome exception member
     */
    public pasDiplomeException(String nomEtudiant, String nomDiplome)
    {
        super(pasDiplomeExceptionHelper.id());
        this.nomEtudiant = nomEtudiant;
        this.nomDiplome = nomDiplome;
    }

    /**
     * Full constructor with fields initialization
     * @param nomEtudiant nomEtudiant exception member
     * @param nomDiplome nomDiplome exception member
     */
    public pasDiplomeException(String orb_reason, String nomEtudiant, String nomDiplome)
    {
        super(pasDiplomeExceptionHelper.id() +" " +  orb_reason);
        this.nomEtudiant = nomEtudiant;
        this.nomDiplome = nomDiplome;
    }

}
