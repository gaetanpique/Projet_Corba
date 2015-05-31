package Etudes;

/**
 * Holder class for : NombreMaxDeVoeuxAtteint
 * 
 * @author OpenORB Compiler
 */
final public class NombreMaxDeVoeuxAtteintHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal NombreMaxDeVoeuxAtteint value
     */
    public Etudes.NombreMaxDeVoeuxAtteint value;

    /**
     * Default constructor
     */
    public NombreMaxDeVoeuxAtteintHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NombreMaxDeVoeuxAtteintHolder(Etudes.NombreMaxDeVoeuxAtteint initial)
    {
        value = initial;
    }

    /**
     * Read NombreMaxDeVoeuxAtteint from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NombreMaxDeVoeuxAtteintHelper.read(istream);
    }

    /**
     * Write NombreMaxDeVoeuxAtteint into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NombreMaxDeVoeuxAtteintHelper.write(ostream,value);
    }

    /**
     * Return the NombreMaxDeVoeuxAtteint TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NombreMaxDeVoeuxAtteintHelper.type();
    }

}
