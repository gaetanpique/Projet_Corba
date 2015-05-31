package Etudes;

/**
 * Holder class for : listUniversites
 * 
 * @author OpenORB Compiler
 */
final public class listUniversitesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listUniversites value
     */
    public Etudes.Universite[] value;

    /**
     * Default constructor
     */
    public listUniversitesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listUniversitesHolder(Etudes.Universite[] initial)
    {
        value = initial;
    }

    /**
     * Read listUniversites from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listUniversitesHelper.read(istream);
    }

    /**
     * Write listUniversites into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listUniversitesHelper.write(ostream,value);
    }

    /**
     * Return the listUniversites TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listUniversitesHelper.type();
    }

}
