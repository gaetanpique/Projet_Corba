package Etudes;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public abstract class MasterPOA extends org.omg.PortableServer.Servant
        implements MasterOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Master _this()
    {
        return MasterHelper.narrow(_this_object());
    }

    public Master _this(org.omg.CORBA.ORB orb)
    {
        return MasterHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Master:1.0", 
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
        } else if (opName.equals("equals")) {
                return _invoke_equals(_is, handler);
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

    private org.omg.CORBA.portable.OutputStream _invoke_equals(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Formation arg0_in = Etudes.FormationHelper.read(_is);

        boolean _arg_result = _equals(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

}
