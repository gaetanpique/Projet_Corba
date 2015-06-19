package Etudes;

/**
 * Interface definition : Resultat
 * 
 * @author OpenORB Compiler
 */
public class _ResultatStub extends org.omg.CORBA.portable.ObjectImpl
        implements Resultat
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Resultat:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.ResultatOperations.class;

    /**
     * Read accessor for codeObtention attribute
     * @return the attribute value
     */
    public String codeObtention()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_codeObtention",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_codeObtention",_opsClass);
                if (_so == null)
                   continue;
                Etudes.ResultatOperations _self = (Etudes.ResultatOperations) _so.servant;
                try
                {
                    return _self.codeObtention();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for moyenne attribute
     * @return the attribute value
     */
    public float moyenne()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_moyenne",true);
                    _input = this._invoke(_output);
                    return _input.read_float();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_moyenne",_opsClass);
                if (_so == null)
                   continue;
                Etudes.ResultatOperations _self = (Etudes.ResultatOperations) _so.servant;
                try
                {
                    return _self.moyenne();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for position attribute
     * @return the attribute value
     */
    public short position()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_position",true);
                    _input = this._invoke(_output);
                    return _input.read_short();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_position",_opsClass);
                if (_so == null)
                   continue;
                Etudes.ResultatOperations _self = (Etudes.ResultatOperations) _so.servant;
                try
                {
                    return _self.position();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
