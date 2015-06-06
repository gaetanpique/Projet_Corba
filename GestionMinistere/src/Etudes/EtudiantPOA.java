package Etudes;

/**
 * Interface definition : Etudiant
 * 
 * @author OpenORB Compiler
 */
public abstract class EtudiantPOA extends org.omg.PortableServer.Servant
        implements EtudiantOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Etudiant _this()
    {
        return EtudiantHelper.narrow(_this_object());
    }

    public Etudiant _this(org.omg.CORBA.ORB orb)
    {
        return EtudiantHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Etudiant:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_resultats")) {
                return _invoke__get_resultats(_is, handler);
        } else if (opName.equals("_set_resultats")) {
                return _invoke__set_resultats(_is, handler);
        } else if (opName.equals("estMeilleurQue")) {
                return _invoke_estMeilleurQue(_is, handler);
        } else if (opName.equals("getUniversite")) {
                return _invoke_getUniversite(_is, handler);
        } else if (opName.equals("isInscrit")) {
                return _invoke_isInscrit(_is, handler);
        } else if (opName.equals("isMotDePasseCorrect")) {
                return _invoke_isMotDePasseCorrect(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_resultats(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Resultat arg = resultats();
        _output = handler.createReply();
        Etudes.ResultatHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_resultats(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Resultat result = Etudes.ResultatHelper.read(_is);

        resultats(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_estMeilleurQue(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);

        try
        {
            boolean _arg_result = estMeilleurQue(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (Etudes.diplomesDifferents _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.diplomesDifferentsHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isInscrit(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        boolean _arg_result = isInscrit();

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isMotDePasseCorrect(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = isMotDePasseCorrect(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        Etudes.Universite _arg_result = getUniversite();

        _output = handler.createReply();
        Etudes.UniversiteHelper.write(_output,_arg_result);

        return _output;
    }

}
