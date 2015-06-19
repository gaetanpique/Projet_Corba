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

        if (opName.equals("_get_listeVoeux")) {
                return _invoke__get_listeVoeux(_is, handler);
        } else if (opName.equals("_get_resultats")) {
                return _invoke__get_resultats(_is, handler);
        } else if (opName.equals("estMeilleurQue")) {
                return _invoke_estMeilleurQue(_is, handler);
        } else if (opName.equals("getPositionEtudiant")) {
                return _invoke_getPositionEtudiant(_is, handler);
        } else if (opName.equals("getUniversite")) {
                return _invoke_getUniversite(_is, handler);
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

    private org.omg.CORBA.portable.OutputStream _invoke__get_listeVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Voeu[] arg = listeVoeux();
        _output = handler.createReply();
        Etudes.listVoeuxHelper.write(_output,arg);
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
        catch (Etudes.diplomesDifferentsException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.diplomesDifferentsExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPositionEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        short _arg_result = getPositionEtudiant();

        _output = handler.createReply();
        _output.write_short(_arg_result);

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
