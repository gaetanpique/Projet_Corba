package Etudes;

/** 
 * Helper class for : diplomesDifferents
 *  
 * @author OpenORB Compiler
 */ 
public class diplomesDifferentsHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert diplomesDifferents into an any
     * @param a an any
     * @param t diplomesDifferents value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.diplomesDifferents t)
    {
        a.insert_Streamable(new Etudes.diplomesDifferentsHolder(t));
    }

    /**
     * Extract diplomesDifferents from an any
     * @param a an any
     * @return the extracted diplomesDifferents value
     */
    public static Etudes.diplomesDifferents extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.diplomesDifferentsHolder)
                    return ((Etudes.diplomesDifferentsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.diplomesDifferentsHolder h = new Etudes.diplomesDifferentsHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the diplomesDifferents TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "nomEtudiant";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomDiplome";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "nomEtudiantDiff";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"diplomesDifferents",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the diplomesDifferents IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/diplomesDifferents:1.0";

    /**
     * Read diplomesDifferents from a marshalled stream
     * @param istream the input stream
     * @return the readed diplomesDifferents value
     */
    public static Etudes.diplomesDifferents read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.diplomesDifferents new_one = new Etudes.diplomesDifferents();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.nomEtudiant = istream.read_string();
        new_one.nomDiplome = istream.read_string();
        new_one.nomEtudiantDiff = istream.read_string();

        return new_one;
    }

    /**
     * Write diplomesDifferents into a marshalled stream
     * @param ostream the output stream
     * @param value diplomesDifferents value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.diplomesDifferents value)
    {
        ostream.write_string(id());
        ostream.write_string(value.nomEtudiant);
        ostream.write_string(value.nomDiplome);
        ostream.write_string(value.nomEtudiantDiff);
    }

}
