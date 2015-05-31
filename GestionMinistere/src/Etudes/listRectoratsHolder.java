package Etudes;

/**
 * Holder class for : listRectorats
 * 
 * @author OpenORB Compiler
 */
final public class listRectoratsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listRectorats value
     */
    public Etudes.Rectorat[] value;

    /**
     * Default constructor
     */
    public listRectoratsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listRectoratsHolder(Etudes.Rectorat[] initial)
    {
        value = initial;
    }

    /**
     * Read listRectorats from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listRectoratsHelper.read(istream);
    }

    /**
     * Write listRectorats into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listRectoratsHelper.write(ostream,value);
    }

    /**
     * Return the listRectorats TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listRectoratsHelper.type();
    }

}
