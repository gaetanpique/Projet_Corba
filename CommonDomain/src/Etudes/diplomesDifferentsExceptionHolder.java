package Etudes;

/**
 * Holder class for : diplomesDifferentsException
 * 
 * @author OpenORB Compiler
 */
final public class diplomesDifferentsExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal diplomesDifferentsException value
     */
    public Etudes.diplomesDifferentsException value;

    /**
     * Default constructor
     */
    public diplomesDifferentsExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public diplomesDifferentsExceptionHolder(Etudes.diplomesDifferentsException initial)
    {
        value = initial;
    }

    /**
     * Read diplomesDifferentsException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = diplomesDifferentsExceptionHelper.read(istream);
    }

    /**
     * Write diplomesDifferentsException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        diplomesDifferentsExceptionHelper.write(ostream,value);
    }

    /**
     * Return the diplomesDifferentsException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return diplomesDifferentsExceptionHelper.type();
    }

}
