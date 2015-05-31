package Etudes;

/** 
 * Helper class for : Etudiant
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantHelper
{
    /**
     * Insert Etudiant into an any
     * @param a an any
     * @param t Etudiant value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Etudiant t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Etudiant from an any
     * @param a an any
     * @return the extracted Etudiant value
     */
    public static Etudes.Etudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return Etudes.EtudiantHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Etudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Etudiant");
        }
        return _tc;
    }

    /**
     * Return the Etudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/Etudiant:1.0";

    /**
     * Read Etudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed Etudiant value
     */
    public static Etudes.Etudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Etudes.Etudiant)istream.read_Object(Etudes._EtudiantStub.class);
    }

    /**
     * Write Etudiant into a marshalled stream
     * @param ostream the output stream
     * @param value Etudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Etudiant value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Etudiant
     * @param obj the CORBA Object
     * @return Etudiant Object
     */
    public static Etudiant narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Etudiant)
            return (Etudiant)obj;

        if (obj._is_a(id()))
        {
            _EtudiantStub stub = new _EtudiantStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Etudiant
     * @param obj the CORBA Object
     * @return Etudiant Object
     */
    public static Etudiant unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Etudiant)
            return (Etudiant)obj;

        _EtudiantStub stub = new _EtudiantStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
