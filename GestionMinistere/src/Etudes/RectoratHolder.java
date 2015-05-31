package Etudes;

/**
 * Holder class for : Rectorat
 * 
 * @author OpenORB Compiler
 */
final public class RectoratHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Rectorat value
     */
    public Etudes.Rectorat value;

    /**
     * Default constructor
     */
    public RectoratHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public RectoratHolder(Etudes.Rectorat initial)
    {
        value = initial;
    }

    /**
     * Read Rectorat from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = RectoratHelper.read(istream);
    }

    /**
     * Write Rectorat into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        RectoratHelper.write(ostream,value);
    }

    /**
     * Return the Rectorat TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return RectoratHelper.type();
    }

}
