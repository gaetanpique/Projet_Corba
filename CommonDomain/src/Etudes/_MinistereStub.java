package Etudes;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public class _MinistereStub extends org.omg.CORBA.portable.ObjectImpl
        implements Ministere
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Ministere:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.MinistereOperations.class;

    /**
     * Operation getListFormations
     */
    public Etudes.Formation[] getListFormations()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListFormations",true);
                    _input = this._invoke(_output);
                    Etudes.Formation[] _arg_ret = Etudes.listFormationsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListFormations",_opsClass);
                if (_so == null)
                   continue;
                Etudes.MinistereOperations _self = (Etudes.MinistereOperations) _so.servant;
                try
                {
                    return _self.getListFormations();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getListRectorats
     */
    public Etudes.Rectorat[] getListRectorats()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListRectorats",true);
                    _input = this._invoke(_output);
                    Etudes.Rectorat[] _arg_ret = Etudes.listRectoratsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListRectorats",_opsClass);
                if (_so == null)
                   continue;
                Etudes.MinistereOperations _self = (Etudes.MinistereOperations) _so.servant;
                try
                {
                    return _self.getListRectorats();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Formation formation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPropositionByFormation",true);
                    Etudes.FormationHelper.write(_output,formation);
                    _input = this._invoke(_output);
                    Etudes.Proposition[] _arg_ret = Etudes.listPropositionsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPropositionByFormation",_opsClass);
                if (_so == null)
                   continue;
                Etudes.MinistereOperations _self = (Etudes.MinistereOperations) _so.servant;
                try
                {
                    return _self.getPropositionByFormation( formation);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation referencer
     */
    public void referencer(Etudes.Rectorat nomRectoratConnecte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("referencer",false);
                    Etudes.RectoratHelper.write(_output,nomRectoratConnecte);
                    _input = this._invoke(_output);
                    return;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("referencer",_opsClass);
                if (_so == null)
                   continue;
                Etudes.MinistereOperations _self = (Etudes.MinistereOperations) _so.servant;
                try
                {
                    _self.referencer( nomRectoratConnecte);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation dereferencer
     */
    public void dereferencer(Etudes.Rectorat rectoratDeconnecte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("dereferencer",false);
                    Etudes.RectoratHelper.write(_output,rectoratDeconnecte);
                    _input = this._invoke(_output);
                    return;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("dereferencer",_opsClass);
                if (_so == null)
                   continue;
                Etudes.MinistereOperations _self = (Etudes.MinistereOperations) _so.servant;
                try
                {
                    _self.dereferencer( rectoratDeconnecte);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
