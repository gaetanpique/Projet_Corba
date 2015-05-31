package Etudes;

/**
 * Interface definition : Proposition
 * 
 * @author OpenORB Compiler
 */
public abstract class PropositionPOA extends org.omg.PortableServer.Servant
        implements PropositionOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Proposition _this()
    {
        return PropositionHelper.narrow(_this_object());
    }

    public Proposition _this(org.omg.CORBA.ORB orb)
    {
        return PropositionHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:Etudes/Proposition:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_masterPropose")) {
                return _invoke__get_masterPropose(_is, handler);
        } else if (opName.equals("_get_universiteSource")) {
                return _invoke__get_universiteSource(_is, handler);
        } else if (opName.equals("isCompatible")) {
                return _invoke_isCompatible(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_isCompatible(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Resultat arg0_in = Etudes.ResultatHelper.read(_is);

        boolean _arg_result = isCompatible(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_universiteSource(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Universite arg = universiteSource();
        _output = handler.createReply();
        Etudes.UniversiteHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_masterPropose(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        Etudes.Master arg = masterPropose();
        _output = handler.createReply();
        Etudes.MasterHelper.write(_output,arg);
        return _output;
    }

}
