package Etudes;

/**
 * Exception definition : PropositionDoesNotExistException
 * 
 * @author OpenORB Compiler
 */
public final class PropositionDoesNotExistException extends org.omg.CORBA.UserException
{
    /**
     * Exception member nonProposee
     */
    public Etudes.Formation nonProposee;

    /**
     * Default constructor
     */
    public PropositionDoesNotExistException()
    {
        super(PropositionDoesNotExistExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param nonProposee nonProposee exception member
     */
    public PropositionDoesNotExistException(Etudes.Formation nonProposee)
    {
        super(PropositionDoesNotExistExceptionHelper.id());
        this.nonProposee = nonProposee;
    }

    /**
     * Full constructor with fields initialization
     * @param nonProposee nonProposee exception member
     */
    public PropositionDoesNotExistException(String orb_reason, Etudes.Formation nonProposee)
    {
        super(PropositionDoesNotExistExceptionHelper.id() +" " +  orb_reason);
        this.nonProposee = nonProposee;
    }

}
