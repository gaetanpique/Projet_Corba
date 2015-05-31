package Etudes;

/**
 * Holder class for : Ministere
 * 
 * @author OpenORB Compiler
 */
final public class MinistereHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Ministere value
     */
    public Etudes.Ministere value;

    /**
     * Default constructor
     */
    public MinistereHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MinistereHolder(Etudes.Ministere initial)
    {
        value = initial;
    }

    /**
     * Read Ministere from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MinistereHelper.read(istream);
    }

    /**
     * Write Ministere into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MinistereHelper.write(ostream,value);
    }

    /**
     * Return the Ministere TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MinistereHelper.type();
    }

}
