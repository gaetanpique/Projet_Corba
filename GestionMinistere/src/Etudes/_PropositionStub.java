package Etudes;

/**
 * Interface definition : Proposition
 * 
 * @author OpenORB Compiler
 */
public class _PropositionStub extends org.omg.CORBA.portable.ObjectImpl
        implements Proposition
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Proposition:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.PropositionOperations.class;

    /**
     * Operation isCompatible
     */
    public boolean isCompatible(Etudes.Resultat resultatEtudiant)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isCompatible",true);
                    Etudes.ResultatHelper.write(_output,resultatEtudiant);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isCompatible",_opsClass);
                if (_so == null)
                   continue;
                Etudes.PropositionOperations _self = (Etudes.PropositionOperations) _so.servant;
                try
                {
                    return _self.isCompatible( resultatEtudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for universiteSource attribute
     * @return the attribute value
     */
    public Etudes.Universite universiteSource()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_universiteSource",true);
                    _input = this._invoke(_output);
                    return Etudes.UniversiteHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_universiteSource",_opsClass);
                if (_so == null)
                   continue;
                Etudes.PropositionOperations _self = (Etudes.PropositionOperations) _so.servant;
                try
                {
                    return _self.universiteSource();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for masterPropose attribute
     * @return the attribute value
     */
    public Etudes.Master masterPropose()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_masterPropose",true);
                    _input = this._invoke(_output);
                    return Etudes.MasterHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_masterPropose",_opsClass);
                if (_so == null)
                   continue;
                Etudes.PropositionOperations _self = (Etudes.PropositionOperations) _so.servant;
                try
                {
                    return _self.masterPropose();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
