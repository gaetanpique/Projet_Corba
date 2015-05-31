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
     * Operation demanderConnexion
     */
    public boolean demanderConnexion(String numEtudiant, String motDePasse)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderConnexion",true);
                    _output.write_string(numEtudiant);
                    _output.write_string(motDePasse);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderConnexion",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.demanderConnexion( numEtudiant,  motDePasse);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demanderInscription
     */
    public boolean demanderInscription(String numEtudiant, String motDePasse)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderInscription",true);
                    _output.write_string(numEtudiant);
                    _output.write_string(motDePasse);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderInscription",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.demanderInscription( numEtudiant,  motDePasse);
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
    public Etudes.Licence[] getPrerequis(Etudes.Formation formation)
        throws Etudes.PropositionDoesNotExist
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPrerequis",true);
                    Etudes.FormationHelper.write(_output,formation);
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
                    if (_exception_id.equals(Etudes.PropositionDoesNotExistHelper.id()))
                    {
                        throw Etudes.PropositionDoesNotExistHelper.read(_exception.getInputStream());
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
                    return _self.getPrerequis( formation);
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
    public void creerProposition(Etudes.Formation nouvelleFormation, Etudes.Licence[] prerequis)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerProposition",false);
                    Etudes.FormationHelper.write(_output,nouvelleFormation);
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
                    _self.creerProposition( nouvelleFormation,  prerequis);
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
    public void majPrerequis(Etudes.Formation formation, Etudes.Licence[] nouveauxPrerequis)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("majPrerequis",false);
                    Etudes.FormationHelper.write(_output,formation);
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
                    _self.majPrerequis( formation,  nouveauxPrerequis);
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
     * Operation getClassement
     */
    public short getClassement(Etudes.Etudiant sujet, Etudes.Licence formation)
        throws Etudes.pasDiplomeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getClassement",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getClassement",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UniversiteOperations _self = (Etudes.UniversiteOperations) _so.servant;
                try
                {
                    return _self.getClassement( sujet,  formation);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
