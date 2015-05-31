package Etudes;

/**
 * Exception definition : PropositionDoesNotExist
 * 
 * @author OpenORB Compiler
 */
public final class PropositionDoesNotExist extends org.omg.CORBA.UserException
{
    /**
     * Exception member nonProposee
     */
    public Etudes.Formation nonProposee;

    /**
     * Default constructor
     */
    public PropositionDoesNotExist()
    {
        super(PropositionDoesNotExistHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param nonProposee nonProposee exception member
     */
    public PropositionDoesNotExist(Etudes.Formation nonProposee)
    {
        super(PropositionDoesNotExistHelper.id());
        this.nonProposee = nonProposee;
    }

    /**
     * Full constructor with fields initialization
     * @param nonProposee nonProposee exception member
     */
    public PropositionDoesNotExist(String orb_reason, Etudes.Formation nonProposee)
    {
        super(PropositionDoesNotExistHelper.id() +" " +  orb_reason);
        this.nonProposee = nonProposee;
    }

}
