package Etudes;

/**
 * Holder class for : EtudiantInconnuException
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantInconnuExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtudiantInconnuException value
     */
    public Etudes.EtudiantInconnuException value;

    /**
     * Default constructor
     */
    public EtudiantInconnuExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantInconnuExceptionHolder(Etudes.EtudiantInconnuException initial)
    {
        value = initial;
    }

    /**
     * Read EtudiantInconnuException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantInconnuExceptionHelper.read(istream);
    }

    /**
     * Write EtudiantInconnuException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantInconnuExceptionHelper.write(ostream,value);
    }

    /**
     * Return the EtudiantInconnuException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantInconnuExceptionHelper.type();
    }

}
