package Etudes;

/**
 * Exception definition : NombreMaxDeVoeuxAtteint
 * 
 * @author OpenORB Compiler
 */
public final class NombreMaxDeVoeuxAtteint extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public NombreMaxDeVoeuxAtteint()
    {
        super(NombreMaxDeVoeuxAtteintHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public NombreMaxDeVoeuxAtteint(String orb_reason)
    {
        super(NombreMaxDeVoeuxAtteintHelper.id() +" " +  orb_reason);
    }

}
