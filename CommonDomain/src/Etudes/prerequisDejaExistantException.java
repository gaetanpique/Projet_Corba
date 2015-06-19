package Etudes;

/**
 * Exception definition : prerequisDejaExistantException
 * 
 * @author OpenORB Compiler
 */
public final class prerequisDejaExistantException extends org.omg.CORBA.UserException
{
    /**
     * Exception member proposition
     */
    public Etudes.Proposition proposition;

    /**
     * Default constructor
     */
    public prerequisDejaExistantException()
    {
        super(prerequisDejaExistantExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param proposition proposition exception member
     */
    public prerequisDejaExistantException(Etudes.Proposition proposition)
    {
        super(prerequisDejaExistantExceptionHelper.id());
        this.proposition = proposition;
    }

    /**
     * Full constructor with fields initialization
     * @param proposition proposition exception member
     */
    public prerequisDejaExistantException(String orb_reason, Etudes.Proposition proposition)
    {
        super(prerequisDejaExistantExceptionHelper.id() +" " +  orb_reason);
        this.proposition = proposition;
    }

}
