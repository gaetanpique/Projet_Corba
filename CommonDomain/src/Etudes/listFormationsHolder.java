package Etudes;

/**
 * Holder class for : listFormations
 * 
 * @author OpenORB Compiler
 */
final public class listFormationsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listFormations value
     */
    public Etudes.Formation[] value;

    /**
     * Default constructor
     */
    public listFormationsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listFormationsHolder(Etudes.Formation[] initial)
    {
        value = initial;
    }

    /**
     * Read listFormations from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listFormationsHelper.read(istream);
    }

    /**
     * Write listFormations into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listFormationsHelper.write(ostream,value);
    }

    /**
     * Return the listFormations TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listFormationsHelper.type();
    }

}
