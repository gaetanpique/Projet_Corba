package Etudes;

/** 
 * Helper class for : Ministere
 *  
 * @author OpenORB Compiler
 */ 
public class MinistereHelper
{
    /**
     * Insert Ministere into an any
     * @param a an any
     * @param t Ministere value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Ministere t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Ministere from an any
     * @param a an any
     * @return the extracted Ministere value
     */
    public static Etudes.Ministere extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.MinistereHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Ministere TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Ministere");
        }
        return _tc;
    }

    /**
     * Return the Ministere IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Ministere:1.0";

    /**
     * Read Ministere from a marshalled stream
     * @param istream the input stream
     * @return the readed Ministere value
     */
    public static Etudes.Ministere read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Ministere)istream.read_Object(Etudes._MinistereStub.class);
    }

    /**
     * Write Ministere into a marshalled stream
     * @param ostream the output stream
     * @param value Ministere value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Ministere value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Ministere
     * @param obj the CORBA Object
     * @return Ministere Object
     */
    public static Ministere narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Ministere)
            return (Ministere)obj;

        if (obj._is_a(id()))
        {
            _MinistereStub stub = new _MinistereStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Ministere
     * @param obj the CORBA Object
     * @return Ministere Object
     */
    public static Ministere unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Ministere)
            return (Ministere)obj;

        _MinistereStub stub = new _MinistereStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
