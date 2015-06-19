package Etudes;

/**
 * Exception definition : NombreMaxDeVoeuxAtteintException
 * 
 * @author OpenORB Compiler
 */
public final class NombreMaxDeVoeuxAtteintException extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public NombreMaxDeVoeuxAtteintException()
    {
        super(NombreMaxDeVoeuxAtteintExceptionHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public NombreMaxDeVoeuxAtteintException(String orb_reason)
    {
        super(NombreMaxDeVoeuxAtteintExceptionHelper.id() +" " +  orb_reason);
    }

}
