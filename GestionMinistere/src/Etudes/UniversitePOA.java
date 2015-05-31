package Etudes;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public abstract class UniversitePOA extends org.omg.PortableServer.Servant
        implements UniversiteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Universite _this()
    {
        return UniversiteHelper.narrow(_this_object());
    }

    public Universite _this(org.omg.CORBA.ORB orb)
    {
        return UniversiteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Universite:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("creerProposition")) {
                return _invoke_creerProposition(_is, handler);
        } else if (opName.equals("demanderConnexion")) {
                return _invoke_demanderConnexion(_is, handler);
        } else if (opName.equals("demanderInscription")) {
                return _invoke_demanderInscription(_is, handler);
        } else if (opName.equals("getClassement")) {
                return _invoke_getClassement(_is, handler);
        } else if (opName.equals("getEtudiants")) {
                return _invoke_getEtudiants(_is, handler);
        } else if (opName.equals("getPrerequis")) {
                return _invoke_getPrerequis(_is, handler);
        } else if (opName.equals("getPropositionByFormation")) {
                return _invoke_getPropositionByFormation(_is, handler);
        } else if (opName.equals("majPrerequis")) {
                return _invoke_majPrerequis(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getEtudiants(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        Etudes.Etudiant[] _arg_result = getEtudiants();

        _output = handler.createReply();
        Etudes.listEtudiantHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderConnexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        boolean _arg_result = demanderConnexion(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderInscription(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        boolean _arg_result = demanderInscription(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getPrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Formation arg0_in = Etudes.FormationHelper.read(_is);

        try
        {
            Etudes.Licence[] _arg_result = getPrerequis(arg0_in);

            _output = handler.createReply();
            Etudes.listLicencesHelper.write(_output,_arg_result);

        }
        catch (Etudes.PropositionDoesNotExist _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.PropositionDoesNotExistHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerProposition(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Formation arg0_in = Etudes.FormationHelper.read(_is);
        Etudes.Licence[] arg1_in = Etudes.listLicencesHelper.read(_is);

        creerProposition(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majPrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Formation arg0_in = Etudes.FormationHelper.read(_is);
        Etudes.Licence[] arg1_in = Etudes.listLicencesHelper.read(_is);

        majPrerequis(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getClassement(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        Etudes.Licence arg1_in = Etudes.LicenceHelper.read(_is);

        try
        {
            short _arg_result = getClassement(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_short(_arg_result);

        }
        catch (Etudes.pasDiplomeException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.pasDiplomeExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}
