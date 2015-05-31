package Etudes;

/**
 * Interface definition : Formation
 * 
 * @author OpenORB Compiler
 */
public abstract class FormationPOA extends org.omg.PortableServer.Servant
        implements FormationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Formation _this()
    {
        return FormationHelper.narrow(_this_object());
    }

    public Formation _this(org.omg.CORBA.ORB orb)
    {
        return FormationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
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
