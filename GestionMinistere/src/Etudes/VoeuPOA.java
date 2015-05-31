package Etudes;

/**
 * Interface definition : Voeu
 * 
 * @author OpenORB Compiler
 */
public abstract class VoeuPOA extends org.omg.PortableServer.Servant
        implements VoeuOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Voeu _this()
    {
        return VoeuHelper.narrow(_this_object());
    }

    public Voeu _this(org.omg.CORBA.ORB orb)
    {
        return VoeuHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Voeu:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_formation")) {
                return _invoke__get_formation(_is, handler);
        } else if (opName.equals("_get_universite")) {
                return _invoke__get_universite(_is, handler);
        } else if (opName.equals("accepter")) {
                return _invoke_accepter(_is, handler);
        } else if (opName.equals("cloturer")) {
                return _invoke_cloturer(_is, handler);
        } else if (opName.equals("majClassement")) {
                return _invoke_majClassement(_is, handler);
        } else if (opName.equals("refuser")) {
                return _invoke_refuser(_is, handler);
        } else if (opName.equals("refuserDefinitevement")) {
                return _invoke_refuserDefinitevement(_is, handler);
        } else if (opName.equals("valider")) {
                return _invoke_valider(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_universite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg = universite();
        _output = handler.createReply();
        Etudes.UniversiteHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_formation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Master arg = formation();
        _output = handler.createReply();
        Etudes.MasterHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_valider(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        valider();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_cloturer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        cloturer();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_accepter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        accepter();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_refuser(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        refuser();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_refuserDefinitevement(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        refuserDefinitevement();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majClassement(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        majClassement(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
