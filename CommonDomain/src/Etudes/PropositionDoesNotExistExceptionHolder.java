package Etudes;

/**
 * Holder class for : PropositionDoesNotExistException
 * 
 * @author OpenORB Compiler
 */
final public class PropositionDoesNotExistExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PropositionDoesNotExistException value
     */
    public Etudes.PropositionDoesNotExistException value;

    /**
     * Default constructor
     */
    public PropositionDoesNotExistExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PropositionDoesNotExistExceptionHolder(Etudes.PropositionDoesNotExistException initial)
    {
        value = initial;
    }

    /**
     * Read PropositionDoesNotExistException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PropositionDoesNotExistExceptionHelper.read(istream);
    }

    /**
     * Write PropositionDoesNotExistException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PropositionDoesNotExistExceptionHelper.write(ostream,value);
    }

    /**
     * Return the PropositionDoesNotExistException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PropositionDoesNotExistExceptionHelper.type();
    }

}
