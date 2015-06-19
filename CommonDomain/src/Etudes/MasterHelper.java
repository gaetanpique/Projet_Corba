package Etudes;

/** 
 * Helper class for : Master
 *  
 * @author OpenORB Compiler
 */ 
public class MasterHelper
{
    /**
     * Insert Master into an any
     * @param a an any
     * @param t Master value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Master t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Master from an any
     * @param a an any
     * @return the extracted Master value
     */
    public static Etudes.Master extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.MasterHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Master TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Master");
        }
        return _tc;
    }

    /**
     * Return the Master IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Master:1.0";

    /**
     * Read Master from a marshalled stream
     * @param istream the input stream
     * @return the readed Master value
     */
    public static Etudes.Master read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Master)istream.read_Object(Etudes._MasterStub.class);
    }

    /**
     * Write Master into a marshalled stream
     * @param ostream the output stream
     * @param value Master value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Master value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Master
     * @param obj the CORBA Object
     * @return Master Object
     */
    public static Master narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Master)
            return (Master)obj;

        if (obj._is_a(id()))
        {
            _MasterStub stub = new _MasterStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Master
     * @param obj the CORBA Object
     * @return Master Object
     */
    public static Master unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Master)
            return (Master)obj;

        _MasterStub stub = new _MasterStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
