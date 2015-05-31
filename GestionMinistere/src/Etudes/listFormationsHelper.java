package Etudes;

/** 
 * Helper class for : listFormations
 *  
 * @author OpenORB Compiler
 */ 
public class listFormationsHelper
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
     * Insert listFormations into an any
     * @param a an any
     * @param t listFormations value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Formation[] t)
    {
        a.insert_Streamable(new Etudes.listFormationsHolder(t));
    }

    /**
     * Extract listFormations from an any
     * @param a an any
     * @return the extracted listFormations value
     */
    public static Etudes.Formation[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.listFormationsHolder)
                    return ((Etudes.listFormationsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.listFormationsHolder h = new Etudes.listFormationsHolder(read(a.create_input_stream()));
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
     * Return the listFormations TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listFormations",orb.create_sequence_tc(0,Etudes.FormationHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listFormations IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/listFormations:1.0";

    /**
     * Read listFormations from a marshalled stream
     * @param istream the input stream
     * @return the readed listFormations value
     */
    public static Etudes.Formation[] read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.Formation[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new Etudes.Formation[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = Etudes.FormationHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listFormations into a marshalled stream
     * @param ostream the output stream
     * @param value listFormations value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Formation[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            Etudes.FormationHelper.write(ostream,value[i7]);

        }
    }

}
