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
     * Write accessor for moyenne attribute
     * @param value the attribute value
     */
    public void moyenne(float value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_moyenne",true);
                    _output.write_float(value);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_moyenne",_opsClass);
                if (_so == null)
                   continue;
                Etudes.ResultatOperations _self = (Etudes.ResultatOperations) _so.servant;
                try
                {
                    _self.moyenne(value);
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
     * Operation isValideForFormation
     */
    public boolean isValideForFormation(Etudes.Formation formation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isValideForFormation",true);
                    Etudes.FormationHelper.write(_output,formation);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isValideForFormation",_opsClass);
                if (_so == null)
                   continue;
                Etudes.ResultatOperations _self = (Etudes.ResultatOperations) _so.servant;
                try
                {
                    return _self.isValideForFormation( formation);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
