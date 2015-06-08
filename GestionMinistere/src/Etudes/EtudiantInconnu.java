package Etudes;

/**
 * Exception definition : EtudiantInconnu
 * 
 * @author OpenORB Compiler
 */
public final class EtudiantInconnu extends org.omg.CORBA.UserException
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
    public EtudiantInconnu()
    {
        super(EtudiantInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param numEtudiantInconnu numEtudiantInconnu exception member
     * @param nomUniversite nomUniversite exception member
     */
    public EtudiantInconnu(String numEtudiantInconnu, String nomUniversite)
    {
        super(EtudiantInconnuHelper.id());
        this.numEtudiantInconnu = numEtudiantInconnu;
        this.nomUniversite = nomUniversite;
    }

    /**
     * Full constructor with fields initialization
     * @param numEtudiantInconnu numEtudiantInconnu exception member
     * @param nomUniversite nomUniversite exception member
     */
    public EtudiantInconnu(String orb_reason, String numEtudiantInconnu, String nomUniversite)
    {
        super(EtudiantInconnuHelper.id() +" " +  orb_reason);
        this.numEtudiantInconnu = numEtudiantInconnu;
        this.nomUniversite = nomUniversite;
    }

}
