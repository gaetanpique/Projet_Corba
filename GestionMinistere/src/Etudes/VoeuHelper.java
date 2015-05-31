package Etudes;

/** 
 * Helper class for : Voeu
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuHelper
{
    /**
     * Insert Voeu into an any
     * @param a an any
     * @param t Voeu value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Voeu t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Voeu from an any
     * @param a an any
     * @return the extracted Voeu value
     */
    public static Etudes.Voeu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.VoeuHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Voeu TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Voeu");
        }
        return _tc;
    }

    /**
     * Return the Voeu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Voeu:1.0";

    /**
     * Read Voeu from a marshalled stream
     * @param istream the input stream
     * @return the readed Voeu value
     */
    public static Etudes.Voeu read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Voeu)istream.read_Object(Etudes._VoeuStub.class);
    }

    /**
     * Write Voeu into a marshalled stream
     * @param ostream the output stream
     * @param value Voeu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Voeu value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Voeu
     * @param obj the CORBA Object
     * @return Voeu Object
     */
    public static Voeu narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Voeu)
            return (Voeu)obj;

        if (obj._is_a(id()))
        {
            _VoeuStub stub = new _VoeuStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Voeu
     * @param obj the CORBA Object
     * @return Voeu Object
     */
    public static Voeu unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Voeu)
            return (Voeu)obj;

        _VoeuStub stub = new _VoeuStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
