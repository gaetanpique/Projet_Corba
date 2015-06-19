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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_listeDesPropositions",
                    new Operation__get_listeDesPropositions());
            operationMap.put("_set_listeDesPropositions",
                    new Operation__set_listeDesPropositions());
            operationMap.put("checkLicenceEtudiant",
                    new Operation_checkLicenceEtudiant());
            operationMap.put("connecter",
                    new Operation_connecter());
            operationMap.put("creerProposition",
                    new Operation_creerProposition());
            operationMap.put("getEtudiantByNumero",
                    new Operation_getEtudiantByNumero());
            operationMap.put("getEtudiants",
                    new Operation_getEtudiants());
            operationMap.put("getPositionEtudiant",
                    new Operation_getPositionEtudiant());
            operationMap.put("getPrerequis",
                    new Operation_getPrerequis());
            operationMap.put("getPropositionByFormation",
                    new Operation_getPropositionByFormation());
            operationMap.put("inscrire",
                    new Operation_inscrire());
            operationMap.put("majPrerequis",
                    new Operation_majPrerequis());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_listeDesPropositions(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition[] arg = listeDesPropositions();
        _output = handler.createReply();
        Etudes.listPropositionsHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_listeDesPropositions(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition[] result = Etudes.listPropositionsHelper.read(_is);

        listeDesPropositions(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getEtudiants(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        Etudes.Etudiant[] _arg_result = getEtudiants();

        _output = handler.createReply();
        Etudes.listEtudiantHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getEtudiantByNumero(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        Etudes.Etudiant _arg_result = getEtudiantByNumero(arg0_in);

        _output = handler.createReply();
        Etudes.EtudiantHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscrire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            inscrire(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (Etudes.EtudiantInconnuException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.EtudiantInconnuExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_connecter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            connecter(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (Etudes.EtudiantInconnuException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.EtudiantInconnuExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPropositionByFormation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Master arg0_in = Etudes.MasterHelper.read(_is);

        Etudes.Proposition _arg_result = getPropositionByFormation(arg0_in);

        _output = handler.createReply();
        Etudes.PropositionHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition arg0_in = Etudes.PropositionHelper.read(_is);

        try
        {
            Etudes.Licence[] _arg_result = getPrerequis(arg0_in);

            _output = handler.createReply();
            Etudes.listLicencesHelper.write(_output,_arg_result);

        }
        catch (Etudes.PropositionDoesNotExistException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.PropositionDoesNotExistExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerProposition(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        Etudes.Licence[] arg1_in = Etudes.listLicencesHelper.read(_is);

        creerProposition(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majPrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition arg0_in = Etudes.PropositionHelper.read(_is);
        Etudes.Licence[] arg1_in = Etudes.listLicencesHelper.read(_is);

        try
        {
            majPrerequis(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (Etudes.PropositionDoesNotExistException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.PropositionDoesNotExistExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPositionEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        Etudes.Licence arg1_in = Etudes.LicenceHelper.read(_is);

        try
        {
            short _arg_result = getPositionEtudiant(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_checkLicenceEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        Etudes.Licence arg1_in = Etudes.LicenceHelper.read(_is);

        boolean _arg_result = checkLicenceEtudiant(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                UniversitePOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_listeDesPropositions extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_listeDesPropositions(_is, handler);
        }
    }

    private static final class Operation__set_listeDesPropositions extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_listeDesPropositions(_is, handler);
        }
    }

    private static final class Operation_getEtudiants extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getEtudiants(_is, handler);
        }
    }

    private static final class Operation_getEtudiantByNumero extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getEtudiantByNumero(_is, handler);
        }
    }

    private static final class Operation_inscrire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_inscrire(_is, handler);
        }
    }

    private static final class Operation_connecter extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_connecter(_is, handler);
        }
    }

    private static final class Operation_getPropositionByFormation extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getPropositionByFormation(_is, handler);
        }
    }

    private static final class Operation_getPrerequis extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getPrerequis(_is, handler);
        }
    }

    private static final class Operation_creerProposition extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_creerProposition(_is, handler);
        }
    }

    private static final class Operation_majPrerequis extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_majPrerequis(_is, handler);
        }
    }

    private static final class Operation_getPositionEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getPositionEtudiant(_is, handler);
        }
    }

    private static final class Operation_checkLicenceEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final UniversitePOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_checkLicenceEtudiant(_is, handler);
        }
    }

}
