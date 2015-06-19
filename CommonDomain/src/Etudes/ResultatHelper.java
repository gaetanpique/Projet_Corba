package Etudes;

/** 
 * Helper class for : Resultat
 *  
 * @author OpenORB Compiler
 */ 
public class ResultatHelper
{
    /**
     * Insert Resultat into an any
     * @param a an any
     * @param t Resultat value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Resultat t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Resultat from an any
     * @param a an any
     * @return the extracted Resultat value
     */
    public static Etudes.Resultat extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.ResultatHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Resultat TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Resultat");
        }
        return _tc;
    }

    /**
     * Return the Resultat IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Resultat:1.0";

    /**
     * Read Resultat from a marshalled stream
     * @param istream the input stream
     * @return the readed Resultat value
     */
    public static Etudes.Resultat read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Resultat)istream.read_Object(Etudes._ResultatStub.class);
    }

    /**
     * Write Resultat into a marshalled stream
     * @param ostream the output stream
     * @param value Resultat value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Resultat value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Resultat
     * @param obj the CORBA Object
     * @return Resultat Object
     */
    public static Resultat narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Resultat)
            return (Resultat)obj;

        if (obj._is_a(id()))
        {
            _ResultatStub stub = new _ResultatStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Resultat
     * @param obj the CORBA Object
     * @return Resultat Object
     */
    public static Resultat unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Resultat)
            return (Resultat)obj;

        _ResultatStub stub = new _ResultatStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
