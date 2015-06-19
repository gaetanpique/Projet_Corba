package Etudes;

/**
 * Holder class for : Proposition
 * 
 * @author OpenORB Compiler
 */
final public class PropositionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Proposition value
     */
    public Etudes.Proposition value;

    /**
     * Default constructor
     */
    public PropositionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PropositionHolder(Etudes.Proposition initial)
    {
        value = initial;
    }

    /**
     * Read Proposition from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PropositionHelper.read(istream);
    }

    /**
     * Write Proposition into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PropositionHelper.write(ostream,value);
    }

    /**
     * Return the Proposition TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PropositionHelper.type();
    }

}
