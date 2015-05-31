package Etudes;

/**
 * Holder class for : listPropositions
 * 
 * @author OpenORB Compiler
 */
final public class listPropositionsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listPropositions value
     */
    public Etudes.Proposition[] value;

    /**
     * Default constructor
     */
    public listPropositionsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listPropositionsHolder(Etudes.Proposition[] initial)
    {
        value = initial;
    }

    /**
     * Read listPropositions from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listPropositionsHelper.read(istream);
    }

    /**
     * Write listPropositions into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listPropositionsHelper.write(ostream,value);
    }

    /**
     * Return the listPropositions TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listPropositionsHelper.type();
    }

}
