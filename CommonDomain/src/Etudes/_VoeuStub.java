package Etudes;

/**
 * Interface definition : Voeu
 * 
 * @author OpenORB Compiler
 */
public class _VoeuStub extends org.omg.CORBA.portable.ObjectImpl
        implements Voeu
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Voeu:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.VoeuOperations.class;

    /**
     * Read accessor for propositionCorrespondante attribute
     * @return the attribute value
     */
    public Etudes.Proposition propositionCorrespondante()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_propositionCorrespondante",true);
                    _input = this._invoke(_output);
                    return Etudes.PropositionHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_propositionCorrespondante",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    return _self.propositionCorrespondante();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for etudiantCorrespondant attribute
     * @return the attribute value
     */
    public Etudes.Etudiant etudiantCorrespondant()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_etudiantCorrespondant",true);
                    _input = this._invoke(_output);
                    return Etudes.EtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_etudiantCorrespondant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    return _self.etudiantCorrespondant();
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
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
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

    /**
     * Write accessor for position attribute
     * @param value the attribute value
     */
    public void position(short value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_position",true);
                    _output.write_short(value);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_position",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.position(value);
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
     * Read accessor for classementEtudiant attribute
     * @return the attribute value
     */
    public short classementEtudiant()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_classementEtudiant",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_classementEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    return _self.classementEtudiant();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for classementEtudiant attribute
     * @param value the attribute value
     */
    public void classementEtudiant(short value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_classementEtudiant",true);
                    _output.write_short(value);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_classementEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.classementEtudiant(value);
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
     * Read accessor for etatVoeu attribute
     * @return the attribute value
     */
    public String etatVoeu()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_etatVoeu",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_etatVoeu",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    return _self.etatVoeu();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for etatVoeu attribute
     * @param value the attribute value
     */
    public void etatVoeu(String value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_etatVoeu",true);
                    _output.write_string(value);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_etatVoeu",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.etatVoeu(value);
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
     * Operation reponseOUI
     */
    public void reponseOUI()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("reponseOUI",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("reponseOUI",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.reponseOUI();
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
     * Operation reponseOUIMAIS
     */
    public void reponseOUIMAIS()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("reponseOUIMAIS",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("reponseOUIMAIS",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.reponseOUIMAIS();
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
     * Operation reponseNONMAIS
     */
    public void reponseNONMAIS()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("reponseNONMAIS",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("reponseNONMAIS",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.reponseNONMAIS();
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
     * Operation reponseNON
     */
    public void reponseNON()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("reponseNON",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("reponseNON",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.reponseNON();
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
     * Operation accepterCandidature
     */
    public void accepterCandidature()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("accepterCandidature",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("accepterCandidature",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.accepterCandidature();
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
     * Operation refuserCandidature
     */
    public void refuserCandidature()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("refuserCandidature",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("refuserCandidature",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.refuserCandidature();
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
     * Operation majClassement
     */
    public void majClassement(short classement)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("majClassement",false);
                    _output.write_short(classement);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("majClassement",_opsClass);
                if (_so == null)
                   continue;
                Etudes.VoeuOperations _self = (Etudes.VoeuOperations) _so.servant;
                try
                {
                    _self.majClassement( classement);
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
