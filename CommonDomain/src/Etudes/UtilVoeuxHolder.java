package Etudes;

/**
 * Holder class for : UtilVoeux
 * 
 * @author OpenORB Compiler
 */
final public class UtilVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal UtilVoeux value
     */
    public Etudes.UtilVoeux value;

    /**
     * Default constructor
     */
    public UtilVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UtilVoeuxHolder(Etudes.UtilVoeux initial)
    {
        value = initial;
    }

    /**
     * Read UtilVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UtilVoeuxHelper.read(istream);
    }

    /**
     * Write UtilVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UtilVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the UtilVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UtilVoeuxHelper.type();
    }

}
