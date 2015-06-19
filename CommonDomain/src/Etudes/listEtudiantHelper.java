package Etudes;

/** 
 * Helper class for : listEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class listEtudiantHelper
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
     * Insert listEtudiant into an any
     * @param a an any
     * @param t listEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, Etudes.Etudiant[] t)
    {
        a.insert_Streamable(new Etudes.listEtudiantHolder(t));
    }

    /**
     * Extract listEtudiant from an any
     * @param a an any
     * @return the extracted listEtudiant value
     */
    public static Etudes.Etudiant[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof Etudes.listEtudiantHolder)
                    return ((Etudes.listEtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            Etudes.listEtudiantHolder h = new Etudes.listEtudiantHolder(read(a.create_input_stream()));
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
     * Return the listEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listEtudiant",orb.create_sequence_tc(0,Etudes.EtudiantHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Etudes/listEtudiant:1.0";

    /**
     * Read listEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed listEtudiant value
     */
    public static Etudes.Etudiant[] read(org.omg.CORBA.portable.InputStream istream)
    {
        Etudes.Etudiant[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new Etudes.Etudiant[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = Etudes.EtudiantHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value listEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Etudes.Etudiant[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            Etudes.EtudiantHelper.write(ostream,value[i7]);

        }
    }

}
