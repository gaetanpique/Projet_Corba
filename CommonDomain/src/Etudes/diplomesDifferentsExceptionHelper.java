package Etudes;

/** 
 * Helper class for : diplomesDifferentsException
 *  
 * @author OpenORB Compiler
 */ 
public class diplomesDifferentsExceptionHelper
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
     * Insert diplomesDifferentsException into an any
     * @param a an any
     * @param t diplomesDifferentsException value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.diplomesDifferentsException t)
    {
        a.insert_Streamable(new Etudes.diplomesDifferentsExceptionHolder(t));
    }

    /**
     * Extract diplomesDifferentsException from an any
     * @param a an any
     * @return the extracted diplomesDifferentsException value
     */
    public static Etudes.diplomesDifferentsException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.diplomesDifferentsExceptionHolder)
                    return ((Etudes.diplomesDifferentsExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.diplomesDifferentsExceptionHolder h = new Etudes.diplomesDifferentsExceptionHolder(read(a.create_input_stream()));
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
     * Return the diplomesDifferentsException TypeCode
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
                _tc = orb.create_exception_tc(id(),"diplomesDifferentsException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the diplomesDifferentsException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/diplomesDifferentsException:1.0";

    /**
     * Read diplomesDifferentsException from a marshalled stream
     * @param istream the input stream
     * @return the readed diplomesDifferentsException value
     */
    public static Etudes.diplomesDifferentsException read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.diplomesDifferentsException new_one = new Etudes.diplomesDifferentsException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.nomEtudiant = istream.read_string();
        new_one.nomDiplome = istream.read_string();
        new_one.nomEtudiantDiff = istream.read_string();

        return new_one;
    }

    /**
     * Write diplomesDifferentsException into a marshalled stream
     * @param ostream the output stream
     * @param value diplomesDifferentsException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.diplomesDifferentsException value)
    {
        ostream.write_string(id());
        ostream.write_string(value.nomEtudiant);
        ostream.write_string(value.nomDiplome);
        ostream.write_string(value.nomEtudiantDiff);
    }

}
