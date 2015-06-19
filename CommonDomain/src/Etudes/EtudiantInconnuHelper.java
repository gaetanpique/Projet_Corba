package Etudes;

/** 
 * Helper class for : EtudiantInconnu
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantInconnuHelper
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
     * Insert EtudiantInconnu into an any
     * @param a an any
     * @param t EtudiantInconnu value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.EtudiantInconnu t)
    {
        a.insert_Streamable(new Etudes.EtudiantInconnuHolder(t));
    }

    /**
     * Extract EtudiantInconnu from an any
     * @param a an any
     * @return the extracted EtudiantInconnu value
     */
    public static Etudes.EtudiantInconnu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.EtudiantInconnuHolder)
                    return ((Etudes.EtudiantInconnuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.EtudiantInconnuHolder h = new Etudes.EtudiantInconnuHolder(read(a.create_input_stream()));
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
     * Return the EtudiantInconnu TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "numEtudiantInconnu";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomUniversite";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"EtudiantInconnu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the EtudiantInconnu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/EtudiantInconnu:1.0";

    /**
     * Read EtudiantInconnu from a marshalled stream
     * @param istream the input stream
     * @return the readed EtudiantInconnu value
     */
    public static Etudes.EtudiantInconnu read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.EtudiantInconnu new_one = new Etudes.EtudiantInconnu();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.numEtudiantInconnu = istream.read_string();
        new_one.nomUniversite = istream.read_string();

        return new_one;
    }

    /**
     * Write EtudiantInconnu into a marshalled stream
     * @param ostream the output stream
     * @param value EtudiantInconnu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.EtudiantInconnu value)
    {
        ostream.write_string(id());
        ostream.write_string(value.numEtudiantInconnu);
        ostream.write_string(value.nomUniversite);
    }

}
