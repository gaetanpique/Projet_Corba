package Etudes;

/**
 * Exception definition : EtudiantInconnuException
 * 
 * @author OpenORB Compiler
 */
public final class EtudiantInconnuException extends org.omg.CORBA.UserException
{
    /**
     * Exception member numEtudiantInconnu
     */
    public String numEtudiantInconnu;

    /**
     * Exception member nomUniversite
     */
    public String nomUniversite;

    /**
     * Default constructor
     */
    public EtudiantInconnuException()
    {
        super(EtudiantInconnuExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param numEtudiantInconnu numEtudiantInconnu exception member
     * @param nomUniversite nomUniversite exception member
     */
    public EtudiantInconnuException(String numEtudiantInconnu, String nomUniversite)
    {
        super(EtudiantInconnuExceptionHelper.id());
        this.numEtudiantInconnu = numEtudiantInconnu;
        this.nomUniversite = nomUniversite;
    }

    /**
     * Full constructor with fields initialization
     * @param numEtudiantInconnu numEtudiantInconnu exception member
     * @param nomUniversite nomUniversite exception member
     */
    public EtudiantInconnuException(String orb_reason, String numEtudiantInconnu, String nomUniversite)
    {
        super(EtudiantInconnuExceptionHelper.id() +" " +  orb_reason);
        this.numEtudiantInconnu = numEtudiantInconnu;
        this.nomUniversite = nomUniversite;
    }

}
