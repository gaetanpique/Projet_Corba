package Etudes;

/**
 * Holder class for : Licence
 * 
 * @author OpenORB Compiler
 */
final public class LicenceHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Licence value
     */
    public Etudes.Licence value;

    /**
     * Default constructor
     */
    public LicenceHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LicenceHolder(Etudes.Licence initial)
    {
        value = initial;
    }

    /**
     * Read Licence from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LicenceHelper.read(istream);
    }

    /**
     * Write Licence into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LicenceHelper.write(ostream,value);
    }

    /**
     * Return the Licence TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LicenceHelper.type();
    }

}
