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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_classementEtudiant",
                    new Operation__get_classementEtudiant());
            operationMap.put("_get_etatVoeu",
                    new Operation__get_etatVoeu());
            operationMap.put("_get_etudiantCorrespondant",
                    new Operation__get_etudiantCorrespondant());
            operationMap.put("_get_position",
                    new Operation__get_position());
            operationMap.put("_get_propositionCorrespondante",
                    new Operation__get_propositionCorrespondante());
            operationMap.put("_set_classementEtudiant",
                    new Operation__set_classementEtudiant());
            operationMap.put("_set_etatVoeu",
                    new Operation__set_etatVoeu());
            operationMap.put("_set_position",
                    new Operation__set_position());
            operationMap.put("accepterCandidature",
                    new Operation_accepterCandidature());
            operationMap.put("majClassement",
                    new Operation_majClassement());
            operationMap.put("refuserCandidature",
                    new Operation_refuserCandidature());
            operationMap.put("reponseNON",
                    new Operation_reponseNON());
            operationMap.put("reponseNONMAIS",
                    new Operation_reponseNONMAIS());
            operationMap.put("reponseOUI",
                    new Operation_reponseOUI());
            operationMap.put("reponseOUIMAIS",
                    new Operation_reponseOUIMAIS());
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
    private org.omg.CORBA.portable.OutputStream _invoke__get_propositionCorrespondante(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Proposition arg = propositionCorrespondante();
        _output = handler.createReply();
        Etudes.PropositionHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_etudiantCorrespondant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg = etudiantCorrespondant();
        _output = handler.createReply();
        Etudes.EtudiantHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_position(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg = position();
        _output = handler.createReply();
        _output.write_short(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_position(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short result = _is.read_short();

        position(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_classementEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg = classementEtudiant();
        _output = handler.createReply();
        _output.write_short(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_classementEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short result = _is.read_short();

        classementEtudiant(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_etatVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = etatVoeu();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_etatVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String result = _is.read_string();

        etatVoeu(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_reponseOUI(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        reponseOUI();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_reponseOUIMAIS(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        reponseOUIMAIS();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_reponseNONMAIS(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        reponseNONMAIS();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_reponseNON(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        reponseNON();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_accepterCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        accepterCandidature();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_refuserCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        refuserCandidature();

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

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                VoeuPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_propositionCorrespondante extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_propositionCorrespondante(_is, handler);
        }
    }

    private static final class Operation__get_etudiantCorrespondant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_etudiantCorrespondant(_is, handler);
        }
    }

    private static final class Operation__get_position extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_position(_is, handler);
        }
    }

    private static final class Operation__set_position extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_position(_is, handler);
        }
    }

    private static final class Operation__get_classementEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_classementEtudiant(_is, handler);
        }
    }

    private static final class Operation__set_classementEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_classementEtudiant(_is, handler);
        }
    }

    private static final class Operation__get_etatVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_etatVoeu(_is, handler);
        }
    }

    private static final class Operation__set_etatVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_etatVoeu(_is, handler);
        }
    }

    private static final class Operation_reponseOUI extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_reponseOUI(_is, handler);
        }
    }

    private static final class Operation_reponseOUIMAIS extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_reponseOUIMAIS(_is, handler);
        }
    }

    private static final class Operation_reponseNONMAIS extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_reponseNONMAIS(_is, handler);
        }
    }

    private static final class Operation_reponseNON extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_reponseNON(_is, handler);
        }
    }

    private static final class Operation_accepterCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_accepterCandidature(_is, handler);
        }
    }

    private static final class Operation_refuserCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_refuserCandidature(_is, handler);
        }
    }

    private static final class Operation_majClassement extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final VoeuPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_majClassement(_is, handler);
        }
    }

}
