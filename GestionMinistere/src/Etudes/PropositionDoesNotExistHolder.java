package Etudes;

/**
 * Holder class for : PropositionDoesNotExist
 * 
 * @author OpenORB Compiler
 */
final public class PropositionDoesNotExistHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PropositionDoesNotExist value
     */
    public Etudes.PropositionDoesNotExist value;

    /**
     * Default constructor
     */
    public PropositionDoesNotExistHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PropositionDoesNotExistHolder(Etudes.PropositionDoesNotExist initial)
    {
        value = initial;
    }

    /**
     * Read PropositionDoesNotExist from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PropositionDoesNotExistHelper.read(istream);
    }

    /**
     * Write PropositionDoesNotExist into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PropositionDoesNotExistHelper.write(ostream,value);
    }

    /**
     * Return the PropositionDoesNotExist TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PropositionDoesNotExistHelper.type();
    }

}
