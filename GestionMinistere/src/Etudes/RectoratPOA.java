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

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("demanderConnexion")) {
                return _invoke_demanderConnexion(_is, handler);
        } else if (opName.equals("demanderInscription")) {
                return _invoke_demanderInscription(_is, handler);
        } else if (opName.equals("getAccreditationsByUniversite")) {
                return _invoke_getAccreditationsByUniversite(_is, handler);
        } else if (opName.equals("getEtudiantByNumero")) {
                return _invoke_getEtudiantByNumero(_is, handler);
        } else if (opName.equals("getListUniversites")) {
                return _invoke_getListUniversites(_is, handler);
        } else if (opName.equals("getPropositionByFormation")) {
                return _invoke_getPropositionByFormation(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
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

        boolean _arg_result = demanderConnexion(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderInscription(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Etudiant arg0_in = Etudes.EtudiantHelper.read(_is);
        String arg1_in = _is.read_string();

        boolean _arg_result = demanderInscription(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

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
        Etudes.Formation arg0_in = Etudes.FormationHelper.read(_is);

        Etudes.Proposition[] _arg_result = getPropositionByFormation(arg0_in);

        _output = handler.createReply();
        Etudes.listPropositionsHelper.write(_output,_arg_result);

        return _output;
    }

}
