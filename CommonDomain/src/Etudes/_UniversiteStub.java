package Etudes;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public class _UniversiteStub extends org.omg.CORBA.portable.ObjectImpl
        implements Universite
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Universite:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.UniversiteOperations.class;

    /**
     * Read accessor for listeDesPropositions attribute
     * @return the attribute value
     */
    public Etudes.Proposition[] listeDesPropositions()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeDesPropositions",true);
                    _input = this._invoke(_output);
                    return Etudes.listPropositionsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeDesPropositions",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.listeDesPropositions();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for listeDesPropositions attribute
     * @param value the attribute value
     */
    public void listeDesPropositions(Etudes.Proposition[] value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_listeDesPropositions",true);
                    Etudes.listPropositionsHelper.write(_output,value);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_listeDesPropositions",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    _self.listeDesPropositions(value);
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
     * Operation getEtudiants
     */
    public Etudes.Etudiant[] getEtudiants()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getEtudiants",true);
                    _input = this._invoke(_output);
                    Etudes.Etudiant[] _arg_ret = Etudes.listEtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEtudiants",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.getEtudiants();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getEtudiantByNumero
     */
    public Etudes.Etudiant getEtudiantByNumero(String numEtudiant)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getEtudiantByNumero",true);
                    _output.write_string(numEtudiant);
                    _input = this._invoke(_output);
                    Etudes.Etudiant _arg_ret = Etudes.EtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEtudiantByNumero",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.getEtudiantByNumero( numEtudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation inscrire
     */
    public void inscrire(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscrire",true);
                    Etudes.EtudiantHelper.write(_output,etudiant);
                    _output.write_string(motDePasse);
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
                    if (_exception_id.equals(Etudes.EtudiantInconnuExceptionHelper.id()))
                    {
                        throw Etudes.EtudiantInconnuExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscrire",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    _self.inscrire( etudiant,  motDePasse);
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
     * Operation connecter
     */
    public void connecter(Etudes.Etudiant numEtudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connecter",true);
                    Etudes.EtudiantHelper.write(_output,numEtudiant);
                    _output.write_string(motDePasse);
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
                    if (_exception_id.equals(Etudes.EtudiantInconnuExceptionHelper.id()))
                    {
                        throw Etudes.EtudiantInconnuExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connecter",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    _self.connecter( numEtudiant,  motDePasse);
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
     * Operation getPropositionByFormation
     */
    public Etudes.Proposition getPropositionByFormation(Etudes.Master formation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPropositionByFormation",true);
                    Etudes.MasterHelper.write(_output,formation);
                    _input = this._invoke(_output);
                    Etudes.Proposition _arg_ret = Etudes.PropositionHelper.read(_input);
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
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
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
     * Operation getPrerequis
     */
    public Etudes.Licence[] getPrerequis(Etudes.Proposition p)
        throws Etudes.PropositionDoesNotExistException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPrerequis",true);
                    Etudes.PropositionHelper.write(_output,p);
                    _input = this._invoke(_output);
                    Etudes.Licence[] _arg_ret = Etudes.listLicencesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(Etudes.PropositionDoesNotExistExceptionHelper.id()))
                    {
                        throw Etudes.PropositionDoesNotExistExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPrerequis",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.getPrerequis( p);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerProposition
     */
    public void creerProposition(String intituleMaster, Etudes.Licence[] prerequis)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerProposition",false);
                    _output.write_string(intituleMaster);
                    Etudes.listLicencesHelper.write(_output,prerequis);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerProposition",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    _self.creerProposition( intituleMaster,  prerequis);
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
     * Operation majPrerequis
     */
    public void majPrerequis(Etudes.Proposition p, Etudes.Licence[] nouveauxPrerequis)
        throws Etudes.PropositionDoesNotExistException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("majPrerequis",false);
                    Etudes.PropositionHelper.write(_output,p);
                    Etudes.listLicencesHelper.write(_output,nouveauxPrerequis);
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
                    if (_exception_id.equals(Etudes.PropositionDoesNotExistExceptionHelper.id()))
                    {
                        throw Etudes.PropositionDoesNotExistExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("majPrerequis",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    _self.majPrerequis( p,  nouveauxPrerequis);
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
     * Operation getPositionEtudiant
     */
    public short getPositionEtudiant(Etudes.Etudiant sujet, Etudes.Licence formation)
        throws Etudes.pasDiplomeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPositionEtudiant",true);
                    Etudes.EtudiantHelper.write(_output,sujet);
                    Etudes.LicenceHelper.write(_output,formation);
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
                    if (_exception_id.equals(Etudes.pasDiplomeExceptionHelper.id()))
                    {
                        throw Etudes.pasDiplomeExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPositionEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.getPositionEtudiant( sujet,  formation);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation checkLicenceEtudiant
     */
    public boolean checkLicenceEtudiant(Etudes.Etudiant e, Etudes.Licence l)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("checkLicenceEtudiant",true);
                    Etudes.EtudiantHelper.write(_output,e);
                    Etudes.LicenceHelper.write(_output,l);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("checkLicenceEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.checkLicenceEtudiant( e,  l);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
