package Etudes;

/** 
 * Helper class for : listUniversites
 *  
 * @author OpenORB Compiler
 */ 
public class listUniversitesHelper
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
     * Insert listUniversites into an any
     * @param a an any
     * @param t listUniversites value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Universite[] t)
    {
        a.insert_Streamable(new Etudes.listUniversitesHolder(t));
    }

    /**
     * Extract listUniversites from an any
     * @param a an any
     * @return the extracted listUniversites value
     */
    public static Etudes.Universite[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.listUniversitesHolder)
                    return ((Etudes.listUniversitesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.listUniversitesHolder h = new Etudes.listUniversitesHolder(read(a.create_input_stream()));
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
     * Return the listUniversites TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listUniversites",orb.create_sequence_tc(0,Etudes.UniversiteHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listUniversites IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/listUniversites:1.0";

    /**
     * Read listUniversites from a marshalled stream
     * @param istream the input stream
     * @return the readed listUniversites value
     */
    public static Etudes.Universite[] read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.Universite[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new Etudes.Universite[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = Etudes.UniversiteHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listUniversites into a marshalled stream
     * @param ostream the output stream
     * @param value listUniversites value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Universite[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            Etudes.UniversiteHelper.write(ostream,value[i7]);

        }
    }

}
