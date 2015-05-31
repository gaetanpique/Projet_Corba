package Etudes;

/**
 * Interface definition : Resultat
 * 
 * @author OpenORB Compiler
 */
public abstract class ResultatPOA extends org.omg.PortableServer.Servant
        implements ResultatOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Resultat _this()
    {
        return ResultatHelper.narrow(_this_object());
    }

    public Resultat _this(org.omg.CORBA.ORB orb)
    {
        return ResultatHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Resultat:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_codeObtention")) {
                return _invoke__get_codeObtention(_is, handler);
        } else if (opName.equals("_get_moyenne")) {
                return _invoke__get_moyenne(_is, handler);
        } else if (opName.equals("_set_moyenne")) {
                return _invoke__set_moyenne(_is, handler);
        } else if (opName.equals("betterThenPrerequis")) {
                return _invoke_betterThenPrerequis(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_codeObtention(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = codeObtention();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_moyenne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        float arg = moyenne();
        _output = handler.createReply();
        _output.write_float(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_moyenne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        float result = _is.read_float();

        moyenne(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_betterThenPrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition arg0_in = Etudes.PropositionHelper.read(_is);

        boolean _arg_result = betterThenPrerequis(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

}
