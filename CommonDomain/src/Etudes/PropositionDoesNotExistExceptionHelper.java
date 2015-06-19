package Etudes;

/** 
 * Helper class for : PropositionDoesNotExistException
 *  
 * @author OpenORB Compiler
 */ 
public class PropositionDoesNotExistExceptionHelper
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
     * Insert PropositionDoesNotExistException into an any
     * @param a an any
     * @param t PropositionDoesNotExistException value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.PropositionDoesNotExistException t)
    {
        a.insert_Streamable(new Etudes.PropositionDoesNotExistExceptionHolder(t));
    }

    /**
     * Extract PropositionDoesNotExistException from an any
     * @param a an any
     * @return the extracted PropositionDoesNotExistException value
     */
    public static Etudes.PropositionDoesNotExistException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.PropositionDoesNotExistExceptionHolder)
                    return ((Etudes.PropositionDoesNotExistExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.PropositionDoesNotExistExceptionHolder h = new Etudes.PropositionDoesNotExistExceptionHolder(read(a.create_input_stream()));
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
     * Return the PropositionDoesNotExistException TypeCode
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
                _tc = orb.create_exception_tc(id(),"PropositionDoesNotExistException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the PropositionDoesNotExistException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/PropositionDoesNotExistException:1.0";

    /**
     * Read PropositionDoesNotExistException from a marshalled stream
     * @param istream the input stream
     * @return the readed PropositionDoesNotExistException value
     */
    public static Etudes.PropositionDoesNotExistException read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.PropositionDoesNotExistException new_one = new Etudes.PropositionDoesNotExistException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.nonProposee = Etudes.FormationHelper.read(istream);

        return new_one;
    }

    /**
     * Write PropositionDoesNotExistException into a marshalled stream
     * @param ostream the output stream
     * @param value PropositionDoesNotExistException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.PropositionDoesNotExistException value)
    {
        ostream.write_string(id());
        Etudes.FormationHelper.write(ostream,value.nonProposee);
    }

}
