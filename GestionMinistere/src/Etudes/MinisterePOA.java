package Etudes;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public abstract class MinisterePOA extends org.omg.PortableServer.Servant
        implements MinistereOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Ministere _this()
    {
        return MinistereHelper.narrow(_this_object());
    }

    public Ministere _this(org.omg.CORBA.ORB orb)
    {
        return MinistereHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Ministere:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("getListFormations")) {
                return _invoke_getListFormations(_is, handler);
        } else if (opName.equals("getListRectorats")) {
                return _invoke_getListRectorats(_is, handler);
        } else if (opName.equals("getPropositionByFormation")) {
                return _invoke_getPropositionByFormation(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getListFormations(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        Etudes.Formation[] _arg_result = getListFormations();

        _output = handler.createReply();
        Etudes.listFormationsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListRectorats(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        Etudes.Rectorat[] _arg_result = getListRectorats();

        _output = handler.createReply();
        Etudes.listRectoratsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPropositionByFormation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Formation arg0_in = Etudes.FormationHelper.read(_is);

        Etudes.Proposition[] _arg_result = getPropositionByFormation(arg0_in);

        _output = handler.createReply();
        Etudes.listPropositionsHelper.write(_output,_arg_result);

        return _output;
    }

}
