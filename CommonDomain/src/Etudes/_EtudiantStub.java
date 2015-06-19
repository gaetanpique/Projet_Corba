package Etudes;

/**
 * Interface definition : Etudiant
 * 
 * @author OpenORB Compiler
 */
public class _EtudiantStub extends org.omg.CORBA.portable.ObjectImpl
        implements Etudiant
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Etudiant:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.EtudiantOperations.class;

    /**
     * Read accessor for resultats attribute
     * @return the attribute value
     */
    public Etudes.Resultat resultats()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_resultats",true);
                    _input = this._invoke(_output);
                    return Etudes.ResultatHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_resultats",_opsClass);
                if (_so == null)
                   continue;
                Etudes.EtudiantOperations _self = (Etudes.EtudiantOperations) _so.servant;
                try
                {
                    return _self.resultats();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for listeVoeux attribute
     * @return the attribute value
     */
    public Etudes.Voeu[] listeVoeux()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeVoeux",true);
                    _input = this._invoke(_output);
                    return Etudes.listVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeVoeux",_opsClass);
                if (_so == null)
                   continue;
                Etudes.EtudiantOperations _self = (Etudes.EtudiantOperations) _so.servant;
                try
                {
                    return _self.listeVoeux();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation estMeilleurQue
     */
    public boolean estMeilleurQue(Etudes.Etudiant aComparer)
        throws Etudes.diplomesDifferentsException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("estMeilleurQue",true);
                    Etudes.EtudiantHelper.write(_output,aComparer);
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
                    if (_exception_id.equals(Etudes.diplomesDifferentsExceptionHelper.id()))
                    {
                        throw Etudes.diplomesDifferentsExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("estMeilleurQue",_opsClass);
                if (_so == null)
                   continue;
                Etudes.EtudiantOperations _self = (Etudes.EtudiantOperations) _so.servant;
                try
                {
                    return _self.estMeilleurQue( aComparer);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getPositionEtudiant
     */
    public short getPositionEtudiant()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPositionEtudiant",true);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPositionEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.EtudiantOperations _self = (Etudes.EtudiantOperations) _so.servant;
                try
                {
                    return _self.getPositionEtudiant();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getUniversite
     */
    public Etudes.Universite getUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getUniversite",true);
                    _input = this._invoke(_output);
                    Etudes.Universite _arg_ret = Etudes.UniversiteHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getUniversite",_opsClass);
                if (_so == null)
                   continue;
                Etudes.EtudiantOperations _self = (Etudes.EtudiantOperations) _so.servant;
                try
                {
                    return _self.getUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
