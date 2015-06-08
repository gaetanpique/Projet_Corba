package Etudes;

/**
 * Holder class for : EtudiantInconnu
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtudiantInconnu value
     */
    public Etudes.EtudiantInconnu value;

    /**
     * Default constructor
     */
    public EtudiantInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantInconnuHolder(Etudes.EtudiantInconnu initial)
    {
        value = initial;
    }

    /**
     * Read EtudiantInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantInconnuHelper.read(istream);
    }

    /**
     * Write EtudiantInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantInconnuHelper.write(ostream,value);
    }

    /**
     * Return the EtudiantInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantInconnuHelper.type();
    }

}
