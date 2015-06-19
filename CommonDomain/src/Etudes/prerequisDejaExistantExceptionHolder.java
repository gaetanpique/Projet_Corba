package Etudes;

/**
 * Holder class for : prerequisDejaExistantException
 * 
 * @author OpenORB Compiler
 */
final public class prerequisDejaExistantExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal prerequisDejaExistantException value
     */
    public Etudes.prerequisDejaExistantException value;

    /**
     * Default constructor
     */
    public prerequisDejaExistantExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public prerequisDejaExistantExceptionHolder(Etudes.prerequisDejaExistantException initial)
    {
        value = initial;
    }

    /**
     * Read prerequisDejaExistantException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = prerequisDejaExistantExceptionHelper.read(istream);
    }

    /**
     * Write prerequisDejaExistantException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        prerequisDejaExistantExceptionHelper.write(ostream,value);
    }

    /**
     * Return the prerequisDejaExistantException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return prerequisDejaExistantExceptionHelper.type();
    }

}
