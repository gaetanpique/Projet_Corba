package Etudes;

/**
 * Holder class for : Master
 * 
 * @author OpenORB Compiler
 */
final public class MasterHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Master value
     */
    public Etudes.Master value;

    /**
     * Default constructor
     */
    public MasterHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MasterHolder(Etudes.Master initial)
    {
        value = initial;
    }

    /**
     * Read Master from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MasterHelper.read(istream);
    }

    /**
     * Write Master into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MasterHelper.write(ostream,value);
    }

    /**
     * Return the Master TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MasterHelper.type();
    }

}
