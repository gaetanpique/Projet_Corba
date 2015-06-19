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

    /**
     * Read accessor for prerequis attribute
     * @return the attribute value
     */
    public Etudes.Licence[] prerequis()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_prerequis",true);
                    _input = this._invoke(_output);
                    return Etudes.listLicencesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_prerequis",_opsClass);
                if (_so == null)
                   continue;
                Etudes.PropositionOperations _self = (Etudes.PropositionOperations) _so.servant;
                try
                {
                    return _self.prerequis();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for prerequis attribute
     * @param value the attribute value
     */
    public void prerequis(Etudes.Licence[] value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_prerequis",true);
                    Etudes.listLicencesHelper.write(_output,value);
                    _input = this._invoke(_output);
                    return;
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_prerequis",_opsClass);
                if (_so == null)
                   continue;
                Etudes.PropositionOperations _self = (Etudes.PropositionOperations) _so.servant;
                try
                {
                    _self.prerequis(value);
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
     * Operation addPrerequis
     */
    public void addPrerequis(Etudes.Licence l)
        throws Etudes.prerequisDejaExistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("addPrerequis",true);
                    Etudes.LicenceHelper.write(_output,l);
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
                    if (_exception_id.equals(Etudes.prerequisDejaExistantExceptionHelper.id()))
                    {
                        throw Etudes.prerequisDejaExistantExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("addPrerequis",_opsClass);
                if (_so == null)
                   continue;
                Etudes.PropositionOperations _self = (Etudes.PropositionOperations) _so.servant;
                try
                {
                    _self.addPrerequis( l);
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
