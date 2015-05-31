package Etudes;

/**
 * Holder class for : diplomesDifferents
 * 
 * @author OpenORB Compiler
 */
final public class diplomesDifferentsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal diplomesDifferents value
     */
    public Etudes.diplomesDifferents value;

    /**
     * Default constructor
     */
    public diplomesDifferentsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public diplomesDifferentsHolder(Etudes.diplomesDifferents initial)
    {
        value = initial;
    }

    /**
     * Read diplomesDifferents from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = diplomesDifferentsHelper.read(istream);
    }

    /**
     * Write diplomesDifferents into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        diplomesDifferentsHelper.write(ostream,value);
    }

    /**
     * Return the diplomesDifferents TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return diplomesDifferentsHelper.type();
    }

}
