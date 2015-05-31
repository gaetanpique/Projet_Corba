package Etudes;

/**
 * Holder class for : Universite
 * 
 * @author OpenORB Compiler
 */
final public class UniversiteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Universite value
     */
    public Etudes.Universite value;

    /**
     * Default constructor
     */
    public UniversiteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UniversiteHolder(Etudes.Universite initial)
    {
        value = initial;
    }

    /**
     * Read Universite from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UniversiteHelper.read(istream);
    }

    /**
     * Write Universite into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UniversiteHelper.write(ostream,value);
    }

    /**
     * Return the Universite TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UniversiteHelper.type();
    }

}
