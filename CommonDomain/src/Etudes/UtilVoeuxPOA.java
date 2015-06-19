package Etudes;

/**
 * Interface definition : UtilVoeux
 * 
 * @author OpenORB Compiler
 */
public abstract class UtilVoeuxPOA extends org.omg.PortableServer.Servant
        implements UtilVoeuxOperations, org.omg.CORBA.portable.InvokeHandler
{
    public UtilVoeux _this()
    {
        return UtilVoeuxHelper.narrow(_this_object());
    }

    public UtilVoeux _this(org.omg.CORBA.ORB orb)
    {
        return UtilVoeuxHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/UtilVoeux:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("classerVoeuxParProposition")) {
                return _invoke_classerVoeuxParProposition(_is, handler);
        } else if (opName.equals("classerVoeuxParUniversite")) {
                return _invoke_classerVoeuxParUniversite(_is, handler);
        } else if (opName.equals("getMeilleurePropositionByEtudiant")) {
                return _invoke_getMeilleurePropositionByEtudiant(_is, handler);
        } else if (opName.equals("getVoeuxByEtudiant")) {
                return _invoke_getVoeuxByEtudiant(_is, handler);
        } else if (opName.equals("getVoeuxByRectorat")) {
                return _invoke_getVoeuxByRectorat(_is, handler);
        } else if (opName.equals("getVoeuxByUniversite")) {
                return _invoke_getVoeuxByUniversite(_is, handler);
        } else if (opName.equals("soumettreVoeu")) {
                return _invoke_soumettreVoeu(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getMeilleurePropositionByEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);

        Etudes.Voeu[] _arg_result = getMeilleurePropositionByEtudiant(arg0_in);

        _output = handler.createReply();
        Etudes.listVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_soumettreVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition arg0_in = Etudes.PropositionHelper.read(_is);
        Etudes.Etudiant arg1_in = Etudes.EtudiantHelper.read(_is);
        short arg2_in = _is.read_short();

        try
        {
            soumettreVoeu(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();

        }
        catch (Etudes.NombreMaxDeVoeuxAtteintException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.NombreMaxDeVoeuxAtteintExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getVoeuxByEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);

        Etudes.Voeu[] _arg_result = getVoeuxByEtudiant(arg0_in);

        _output = handler.createReply();
        Etudes.listVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getVoeuxByUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg0_in = Etudes.UniversiteHelper.read(_is);

        Etudes.Voeu[] _arg_result = getVoeuxByUniversite(arg0_in);

        _output = handler.createReply();
        Etudes.listVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getVoeuxByRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Rectorat arg0_in = Etudes.RectoratHelper.read(_is);

        Etudes.Voeu[] _arg_result = getVoeuxByRectorat(arg0_in);

        _output = handler.createReply();
        Etudes.listVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_classerVoeuxParProposition(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition arg0_in = Etudes.PropositionHelper.read(_is);

        classerVoeuxParProposition(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_classerVoeuxParUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg0_in = Etudes.UniversiteHelper.read(_is);

        classerVoeuxParUniversite(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
