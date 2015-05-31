package Etudes;

/**
 * Holder class for : listVoeux
 * 
 * @author OpenORB Compiler
 */
final public class listVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listVoeux value
     */
    public Etudes.Voeu[] value;

    /**
     * Default constructor
     */
    public listVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listVoeuxHolder(Etudes.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read listVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listVoeuxHelper.read(istream);
    }

    /**
     * Write listVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the listVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listVoeuxHelper.type();
    }

}
