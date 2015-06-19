package Etudes;

/** 
 * Helper class for : listPropositions
 *  
 * @author OpenORB Compiler
 */ 
public class listPropositionsHelper
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
     * Insert listPropositions into an any
     * @param a an any
     * @param t listPropositions value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Proposition[] t)
    {
        a.insert_Streamable(new Etudes.listPropositionsHolder(t));
    }

    /**
     * Extract listPropositions from an any
     * @param a an any
     * @return the extracted listPropositions value
     */
    public static Etudes.Proposition[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.listPropositionsHolder)
                    return ((Etudes.listPropositionsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.listPropositionsHolder h = new Etudes.listPropositionsHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the listPropositions TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listPropositions",orb.create_sequence_tc(0,Etudes.PropositionHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listPropositions IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/listPropositions:1.0";

    /**
     * Read listPropositions from a marshalled stream
     * @param istream the input stream
     * @return the readed listPropositions value
     */
    public static Etudes.Proposition[] read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.Proposition[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new Etudes.Proposition[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = Etudes.PropositionHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listPropositions into a marshalled stream
     * @param ostream the output stream
     * @param value listPropositions value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Proposition[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            Etudes.PropositionHelper.write(ostream,value[i7]);

        }
    }

}
