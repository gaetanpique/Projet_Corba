package Etudes;

/**
 * Holder class for : EtudiantDejaInscritException
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantDejaInscritExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtudiantDejaInscritException value
     */
    public Etudes.EtudiantDejaInscritException value;

    /**
     * Default constructor
     */
    public EtudiantDejaInscritExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantDejaInscritExceptionHolder(Etudes.EtudiantDejaInscritException initial)
    {
        value = initial;
    }

    /**
     * Read EtudiantDejaInscritException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantDejaInscritExceptionHelper.read(istream);
    }

    /**
     * Write EtudiantDejaInscritException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantDejaInscritExceptionHelper.write(ostream,value);
    }

    /**
     * Return the EtudiantDejaInscritException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantDejaInscritExceptionHelper.type();
    }

}
