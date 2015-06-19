package Etudes;

/**
 * Holder class for : NombreMaxDeVoeuxAtteintException
 * 
 * @author OpenORB Compiler
 */
final public class NombreMaxDeVoeuxAtteintExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal NombreMaxDeVoeuxAtteintException value
     */
    public Etudes.NombreMaxDeVoeuxAtteintException value;

    /**
     * Default constructor
     */
    public NombreMaxDeVoeuxAtteintExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NombreMaxDeVoeuxAtteintExceptionHolder(Etudes.NombreMaxDeVoeuxAtteintException initial)
    {
        value = initial;
    }

    /**
     * Read NombreMaxDeVoeuxAtteintException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NombreMaxDeVoeuxAtteintExceptionHelper.read(istream);
    }

    /**
     * Write NombreMaxDeVoeuxAtteintException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NombreMaxDeVoeuxAtteintExceptionHelper.write(ostream,value);
    }

    /**
     * Return the NombreMaxDeVoeuxAtteintException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NombreMaxDeVoeuxAtteintExceptionHelper.type();
    }

}
