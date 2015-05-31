package Etudes;

/**
 * Interface definition : Licence
 * 
 * @author OpenORB Compiler
 */
public class _LicenceStub extends org.omg.CORBA.portable.ObjectImpl
        implements Licence
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Licence:1.0", 
        "IDL:Etudes/Formation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.LicenceOperations.class;

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

}
