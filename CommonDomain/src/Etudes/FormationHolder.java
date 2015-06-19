package Etudes;

/**
 * Holder class for : Formation
 * 
 * @author OpenORB Compiler
 */
final public class FormationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Formation value
     */
    public Etudes.Formation value;

    /**
     * Default constructor
     */
    public FormationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public FormationHolder(Etudes.Formation initial)
    {
        value = initial;
    }

    /**
     * Read Formation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = FormationHelper.read(istream);
    }

    /**
     * Write Formation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        FormationHelper.write(ostream,value);
    }

    /**
     * Return the Formation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return FormationHelper.type();
    }

}
