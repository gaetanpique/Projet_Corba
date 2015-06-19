package Etudes;

/**
 * Interface definition : Formation
 * 
 * @author OpenORB Compiler
 */
public class _FormationStub extends org.omg.CORBA.portable.ObjectImpl
        implements Formation
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Formation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.FormationOperations.class;

    /**
     * Read accessor for intitule attribute
     * @return the attribute value
     */
    public String intitule()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_intitule",true);
                    _input = this._invoke(_output);
                    return _input.read_string();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_intitule",_opsClass);
                if (_so == null)
                   continue;
                Etudes.FormationOperations _self = (Etudes.FormationOperations) _so.servant;
                try
                {
                    return _self.intitule();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation _equals
     */
    public boolean _equals(Etudes.Formation f)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("equals",true);
                    Etudes.FormationHelper.write(_output,f);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_equals",_opsClass);
                if (_so == null)
                   continue;
                Etudes.FormationOperations _self = (Etudes.FormationOperations) _so.servant;
                try
                {
                    return _self._equals( f);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
