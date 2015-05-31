package Etudes;

/** 
 * Helper class for : listLicences
 *  
 * @author OpenORB Compiler
 */ 
public class listLicencesHelper
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
     * Insert listLicences into an any
     * @param a an any
     * @param t listLicences value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Licence[] t)
    {
        a.insert_Streamable(new Etudes.listLicencesHolder(t));
    }

    /**
     * Extract listLicences from an any
     * @param a an any
     * @return the extracted listLicences value
     */
    public static Etudes.Licence[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.listLicencesHolder)
                    return ((Etudes.listLicencesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.listLicencesHolder h = new Etudes.listLicencesHolder(read(a.create_input_stream()));
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
     * Return the listLicences TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listLicences",orb.create_sequence_tc(0,Etudes.LicenceHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listLicences IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/listLicences:1.0";

    /**
     * Read listLicences from a marshalled stream
     * @param istream the input stream
     * @return the readed listLicences value
     */
    public static Etudes.Licence[] read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.Licence[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new Etudes.Licence[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = Etudes.LicenceHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listLicences into a marshalled stream
     * @param ostream the output stream
     * @param value listLicences value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Licence[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            Etudes.LicenceHelper.write(ostream,value[i7]);

        }
    }

}
