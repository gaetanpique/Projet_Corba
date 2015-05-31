package Etudes;

/** 
 * Helper class for : UtilVoeux
 *  
 * @author OpenORB Compiler
 */ 
public class UtilVoeuxHelper
{
    /**
     * Insert UtilVoeux into an any
     * @param a an any
     * @param t UtilVoeux value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.UtilVoeux t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract UtilVoeux from an any
     * @param a an any
     * @return the extracted UtilVoeux value
     */
    public static Etudes.UtilVoeux extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.UtilVoeuxHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the UtilVoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"UtilVoeux");
        }
        return _tc;
    }

    /**
     * Return the UtilVoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/UtilVoeux:1.0";

    /**
     * Read UtilVoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed UtilVoeux value
     */
    public static Etudes.UtilVoeux read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.UtilVoeux)istream.read_Object(Etudes._UtilVoeuxStub.class);
    }

    /**
     * Write UtilVoeux into a marshalled stream
     * @param ostream the output stream
     * @param value UtilVoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.UtilVoeux value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to UtilVoeux
     * @param obj the CORBA Object
     * @return UtilVoeux Object
     */
    public static UtilVoeux narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof UtilVoeux)
            return (UtilVoeux)obj;

        if (obj._is_a(id()))
        {
            _UtilVoeuxStub stub = new _UtilVoeuxStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to UtilVoeux
     * @param obj the CORBA Object
     * @return UtilVoeux Object
     */
    public static UtilVoeux unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof UtilVoeux)
            return (UtilVoeux)obj;

        _UtilVoeuxStub stub = new _UtilVoeuxStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
