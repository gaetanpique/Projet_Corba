package Etudes;

/** 
 * Helper class for : Rectorat
 *  
 * @author OpenORB Compiler
 */ 
public class RectoratHelper
{
    /**
     * Insert Rectorat into an any
     * @param a an any
     * @param t Rectorat value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Rectorat t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Rectorat from an any
     * @param a an any
     * @return the extracted Rectorat value
     */
    public static Etudes.Rectorat extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.RectoratHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Rectorat TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Rectorat");
        }
        return _tc;
    }

    /**
     * Return the Rectorat IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Rectorat:1.0";

    /**
     * Read Rectorat from a marshalled stream
     * @param istream the input stream
     * @return the readed Rectorat value
     */
    public static Etudes.Rectorat read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Rectorat)istream.read_Object(Etudes._RectoratStub.class);
    }

    /**
     * Write Rectorat into a marshalled stream
     * @param ostream the output stream
     * @param value Rectorat value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Rectorat value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Rectorat
     * @param obj the CORBA Object
     * @return Rectorat Object
     */
    public static Rectorat narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Rectorat)
            return (Rectorat)obj;

        if (obj._is_a(id()))
        {
            _RectoratStub stub = new _RectoratStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Rectorat
     * @param obj the CORBA Object
     * @return Rectorat Object
     */
    public static Rectorat unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Rectorat)
            return (Rectorat)obj;

        _RectoratStub stub = new _RectoratStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
