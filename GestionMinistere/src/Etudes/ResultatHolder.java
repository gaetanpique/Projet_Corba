package Etudes;

/**
 * Holder class for : Resultat
 * 
 * @author OpenORB Compiler
 */
final public class ResultatHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Resultat value
     */
    public Etudes.Resultat value;

    /**
     * Default constructor
     */
    public ResultatHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ResultatHolder(Etudes.Resultat initial)
    {
        value = initial;
    }

    /**
     * Read Resultat from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ResultatHelper.read(istream);
    }

    /**
     * Write Resultat into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ResultatHelper.write(ostream,value);
    }

    /**
     * Return the Resultat TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ResultatHelper.type();
    }

}
