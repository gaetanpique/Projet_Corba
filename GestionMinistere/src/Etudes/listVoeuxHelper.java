package Etudes;

/** 
 * Helper class for : listVoeux
 *  
 * @author OpenORB Compiler
 */ 
public class listVoeuxHelper
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
     * Insert listVoeux into an any
     * @param a an any
     * @param t listVoeux value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Voeu[] t)
    {
        a.insert_Streamable(new Etudes.listVoeuxHolder(t));
    }

    /**
     * Extract listVoeux from an any
     * @param a an any
     * @return the extracted listVoeux value
     */
    public static Etudes.Voeu[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.listVoeuxHolder)
                    return ((Etudes.listVoeuxHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.listVoeuxHolder h = new Etudes.listVoeuxHolder(read(a.create_input_stream()));
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
     * Return the listVoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listVoeux",orb.create_sequence_tc(0,Etudes.VoeuHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listVoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/listVoeux:1.0";

    /**
     * Read listVoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed listVoeux value
     */
    public static Etudes.Voeu[] read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.Voeu[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new Etudes.Voeu[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = Etudes.VoeuHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listVoeux into a marshalled stream
     * @param ostream the output stream
     * @param value listVoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Voeu[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            Etudes.VoeuHelper.write(ostream,value[i7]);

        }
    }

}
