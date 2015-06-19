package Etudes;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public abstract class RectoratPOA extends org.omg.PortableServer.Servant
        implements RectoratOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Rectorat _this()
    {
        return RectoratHelper.narrow(_this_object());
    }

    public Rectorat _this(org.omg.CORBA.ORB orb)
    {
        return RectoratHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Rectorat:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_nom",
                    new Operation__get_nom());
            operationMap.put("demanderConnexion",
                    new Operation_demanderConnexion());
            operationMap.put("demanderInscription",
                    new Operation_demanderInscription());
            operationMap.put("dereferencer",
                    new Operation_dereferencer());
            operationMap.put("getAccreditationsByUniversite",
                    new Operation_getAccreditationsByUniversite());
            operationMap.put("getEtudiantByNumero",
                    new Operation_getEtudiantByNumero());
            operationMap.put("getListUniversites",
                    new Operation_getListUniversites());
            operationMap.put("getPropositionByFormation",
                    new Operation_getPropositionByFormation());
            operationMap.put("referencer",
                    new Operation_referencer());
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
    private org.omg.CORBA.portable.OutputStream _invoke__get_nom(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = nom();
        _output = handler.createReply();
        _output.write_string(arg);
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

    private org.omg.CORBA.portable.OutputStream _invoke_demanderConnexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            demanderConnexion(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (Etudes.EtudiantInconnuException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.EtudiantInconnuExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderInscription(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            demanderInscription(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (Etudes.EtudiantInconnuException _exception)
        {
            _output = handler.createExceptionReply();
            Etudes.EtudiantInconnuExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_referencer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg0_in = Etudes.UniversiteHelper.read(_is);

        referencer(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_dereferencer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg0_in = Etudes.UniversiteHelper.read(_is);

        dereferencer(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListUniversites(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        Etudes.Universite[] _arg_result = getListUniversites();

        _output = handler.createReply();
        Etudes.listUniversitesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getAccreditationsByUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg0_in = Etudes.UniversiteHelper.read(_is);

        Etudes.Formation[] _arg_result = getAccreditationsByUniversite(arg0_in);

        _output = handler.createReply();
        Etudes.listFormationsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPropositionByFormation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Master arg0_in = Etudes.MasterHelper.read(_is);

        Etudes.Proposition[] _arg_result = getPropositionByFormation(arg0_in);

        _output = handler.createReply();
        Etudes.listPropositionsHelper.write(_output,_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                RectoratPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_nom extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_nom(_is, handler);
        }
    }

    private static final class Operation_getEtudiantByNumero extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getEtudiantByNumero(_is, handler);
        }
    }

    private static final class Operation_demanderConnexion extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_demanderConnexion(_is, handler);
        }
    }

    private static final class Operation_demanderInscription extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_demanderInscription(_is, handler);
        }
    }

    private static final class Operation_referencer extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_referencer(_is, handler);
        }
    }

    private static final class Operation_dereferencer extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_dereferencer(_is, handler);
        }
    }

    private static final class Operation_getListUniversites extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getListUniversites(_is, handler);
        }
    }

    private static final class Operation_getAccreditationsByUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getAccreditationsByUniversite(_is, handler);
        }
    }

    private static final class Operation_getPropositionByFormation extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getPropositionByFormation(_is, handler);
        }
    }

}
