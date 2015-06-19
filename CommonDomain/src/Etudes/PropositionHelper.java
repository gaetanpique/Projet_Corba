package Etudes;

/** 
 * Helper class for : Proposition
 *  
 * @author OpenORB Compiler
 */ 
public class PropositionHelper
{
    /**
     * Insert Proposition into an any
     * @param a an any
     * @param t Proposition value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Proposition t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Proposition from an any
     * @param a an any
     * @return the extracted Proposition value
     */
    public static Etudes.Proposition extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.PropositionHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Proposition TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Proposition");
        }
        return _tc;
    }

    /**
     * Return the Proposition IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Proposition:1.0";

    /**
     * Read Proposition from a marshalled stream
     * @param istream the input stream
     * @return the readed Proposition value
     */
    public static Etudes.Proposition read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Proposition)istream.read_Object(Etudes._PropositionStub.class);
    }

    /**
     * Write Proposition into a marshalled stream
     * @param ostream the output stream
     * @param value Proposition value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Proposition value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Proposition
     * @param obj the CORBA Object
     * @return Proposition Object
     */
    public static Proposition narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Proposition)
            return (Proposition)obj;

        if (obj._is_a(id()))
        {
            _PropositionStub stub = new _PropositionStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Proposition
     * @param obj the CORBA Object
     * @return Proposition Object
     */
    public static Proposition unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Proposition)
            return (Proposition)obj;

        _PropositionStub stub = new _PropositionStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
