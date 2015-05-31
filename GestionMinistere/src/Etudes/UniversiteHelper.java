package Etudes;

/** 
 * Helper class for : Universite
 *  
 * @author OpenORB Compiler
 */ 
public class UniversiteHelper
{
    /**
     * Insert Universite into an any
     * @param a an any
     * @param t Universite value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Universite t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Universite from an any
     * @param a an any
     * @return the extracted Universite value
     */
    public static Etudes.Universite extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.UniversiteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Universite TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Universite");
        }
        return _tc;
    }

    /**
     * Return the Universite IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Universite:1.0";

    /**
     * Read Universite from a marshalled stream
     * @param istream the input stream
     * @return the readed Universite value
     */
    public static Etudes.Universite read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Universite)istream.read_Object(Etudes._UniversiteStub.class);
    }

    /**
     * Write Universite into a marshalled stream
     * @param ostream the output stream
     * @param value Universite value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Universite value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Universite
     * @param obj the CORBA Object
     * @return Universite Object
     */
    public static Universite narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Universite)
            return (Universite)obj;

        if (obj._is_a(id()))
        {
            _UniversiteStub stub = new _UniversiteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Universite
     * @param obj the CORBA Object
     * @return Universite Object
     */
    public static Universite unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Universite)
            return (Universite)obj;

        _UniversiteStub stub = new _UniversiteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
