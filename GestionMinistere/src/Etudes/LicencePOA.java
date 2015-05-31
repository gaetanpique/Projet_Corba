package Etudes;

/**
 * Interface definition : Licence
 * 
 * @author OpenORB Compiler
 */
public abstract class LicencePOA extends org.omg.PortableServer.Servant
        implements LicenceOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Licence _this()
    {
        return LicenceHelper.narrow(_this_object());
    }

    public Licence _this(org.omg.CORBA.ORB orb)
    {
        return LicenceHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Licence:1.0", 
        "IDL:Etudes/Formation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_intitule")) {
                return _invoke__get_intitule(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_intitule(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = intitule();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

}
