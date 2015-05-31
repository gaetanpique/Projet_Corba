package Etudes;

/**
 * Holder class for : listEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class listEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listEtudiant value
     */
    public Etudes.Etudiant[] value;

    /**
     * Default constructor
     */
    public listEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listEtudiantHolder(Etudes.Etudiant[] initial)
    {
        value = initial;
    }

    /**
     * Read listEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listEtudiantHelper.read(istream);
    }

    /**
     * Write listEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the listEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listEtudiantHelper.type();
    }

}
