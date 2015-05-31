package Etudes;

/**
 * Holder class for : pasDiplomeException
 * 
 * @author OpenORB Compiler
 */
final public class pasDiplomeExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal pasDiplomeException value
     */
    public Etudes.pasDiplomeException value;

    /**
     * Default constructor
     */
    public pasDiplomeExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public pasDiplomeExceptionHolder(Etudes.pasDiplomeException initial)
    {
        value = initial;
    }

    /**
     * Read pasDiplomeException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = pasDiplomeExceptionHelper.read(istream);
    }

    /**
     * Write pasDiplomeException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        pasDiplomeExceptionHelper.write(ostream,value);
    }

    /**
     * Return the pasDiplomeException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return pasDiplomeExceptionHelper.type();
    }

}
