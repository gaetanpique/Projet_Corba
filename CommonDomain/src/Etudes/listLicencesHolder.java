package Etudes;

/**
 * Holder class for : listLicences
 * 
 * @author OpenORB Compiler
 */
final public class listLicencesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listLicences value
     */
    public Etudes.Licence[] value;

    /**
     * Default constructor
     */
    public listLicencesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listLicencesHolder(Etudes.Licence[] initial)
    {
        value = initial;
    }

    /**
     * Read listLicences from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listLicencesHelper.read(istream);
    }

    /**
     * Write listLicences into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listLicencesHelper.write(ostream,value);
    }

    /**
     * Return the listLicences TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listLicencesHelper.type();
    }

}
