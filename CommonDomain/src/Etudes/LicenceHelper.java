package Etudes;

/** 
 * Helper class for : Licence
 *  
 * @author OpenORB Compiler
 */ 
public class LicenceHelper
{
    /**
     * Insert Licence into an any
     * @param a an any
     * @param t Licence value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Licence t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Licence from an any
     * @param a an any
     * @return the extracted Licence value
     */
    public static Etudes.Licence extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.LicenceHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Licence TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Licence");
        }
        return _tc;
    }

    /**
     * Return the Licence IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Licence:1.0";

    /**
     * Read Licence from a marshalled stream
     * @param istream the input stream
     * @return the readed Licence value
     */
    public static Etudes.Licence read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Licence)istream.read_Object(Etudes._LicenceStub.class);
    }

    /**
     * Write Licence into a marshalled stream
     * @param ostream the output stream
     * @param value Licence value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Licence value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Licence
     * @param obj the CORBA Object
     * @return Licence Object
     */
    public static Licence narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Licence)
            return (Licence)obj;

        if (obj._is_a(id()))
        {
            _LicenceStub stub = new _LicenceStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Licence
     * @param obj the CORBA Object
     * @return Licence Object
     */
    public static Licence unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Licence)
            return (Licence)obj;

        _LicenceStub stub = new _LicenceStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
