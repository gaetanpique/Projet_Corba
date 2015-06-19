package Etudes;

/**
 * Holder class for : Etudiant
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Etudiant value
     */
    public Etudes.Etudiant value;

    /**
     * Default constructor
     */
    public EtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantHolder(Etudes.Etudiant initial)
    {
        value = initial;
    }

    /**
     * Read Etudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantHelper.read(istream);
    }

    /**
     * Write Etudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantHelper.write(ostream,value);
    }

    /**
     * Return the Etudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantHelper.type();
    }

}
