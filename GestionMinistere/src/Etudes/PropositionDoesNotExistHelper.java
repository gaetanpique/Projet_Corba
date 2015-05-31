package Etudes;

/** 
 * Helper class for : PropositionDoesNotExist
 *  
 * @author OpenORB Compiler
 */ 
public class PropositionDoesNotExistHelper
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
     * Insert PropositionDoesNotExist into an any
     * @param a an any
     * @param t PropositionDoesNotExist value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.PropositionDoesNotExist t)
    {
        a.insert_Streamable(new Etudes.PropositionDoesNotExistHolder(t));
    }

    /**
     * Extract PropositionDoesNotExist from an any
     * @param a an any
     * @return the extracted PropositionDoesNotExist value
     */
    public static Etudes.PropositionDoesNotExist extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.PropositionDoesNotExistHolder)
                    return ((Etudes.PropositionDoesNotExistHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.PropositionDoesNotExistHolder h = new Etudes.PropositionDoesNotExistHolder(read(a.create_input_stream()));
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
     * Return the PropositionDoesNotExist TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "nonProposee";
                _members[0].type = Etudes.FormationHelper.type();
                _tc = orb.create_exception_tc(id(),"PropositionDoesNotExist",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the PropositionDoesNotExist IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/PropositionDoesNotExist:1.0";

    /**
     * Read PropositionDoesNotExist from a marshalled stream
     * @param istream the input stream
     * @return the readed PropositionDoesNotExist value
     */
    public static Etudes.PropositionDoesNotExist read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.PropositionDoesNotExist new_one = new Etudes.PropositionDoesNotExist();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.nonProposee = Etudes.FormationHelper.read(istream);

        return new_one;
    }

    /**
     * Write PropositionDoesNotExist into a marshalled stream
     * @param ostream the output stream
     * @param value PropositionDoesNotExist value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.PropositionDoesNotExist value)
    {
        ostream.write_string(id());
        Etudes.FormationHelper.write(ostream,value.nonProposee);
    }

}
