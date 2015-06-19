package Etudes;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class _RectoratStub extends org.omg.CORBA.portable.ObjectImpl
        implements Rectorat
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/Rectorat:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.RectoratOperations.class;

    /**
     * Read accessor for nom attribute
     * @return the attribute value
     */
    public String nom()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_nom",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_nom",_opsClass);
                if (_so == null)
                   continue;
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    return _self.nom();
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
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
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
     * Operation demanderConnexion
     */
    public void demanderConnexion(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderConnexion",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderConnexion",_opsClass);
                if (_so == null)
                   continue;
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    _self.demanderConnexion( etudiant,  motDePasse);
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
     * Operation demanderInscription
     */
    public void demanderInscription(Etudes.Etudiant etudiant, String motDePasse)
        throws Etudes.EtudiantInconnuException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderInscription",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderInscription",_opsClass);
                if (_so == null)
                   continue;
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    _self.demanderInscription( etudiant,  motDePasse);
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
     * Operation referencer
     */
    public void referencer(Etudes.Universite universiteConnecte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("referencer",false);
                    Etudes.UniversiteHelper.write(_output,universiteConnecte);
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
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    _self.referencer( universiteConnecte);
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
    public void dereferencer(Etudes.Universite universiteDeconnecte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("dereferencer",false);
                    Etudes.UniversiteHelper.write(_output,universiteDeconnecte);
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
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    _self.dereferencer( universiteDeconnecte);
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
     * Operation getListUniversites
     */
    public Etudes.Universite[] getListUniversites()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListUniversites",true);
                    _input = this._invoke(_output);
                    Etudes.Universite[] _arg_ret = Etudes.listUniversitesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListUniversites",_opsClass);
                if (_so == null)
                   continue;
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    return _self.getListUniversites();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getAccreditationsByUniversite
     */
    public Etudes.Formation[] getAccreditationsByUniversite(Etudes.Universite universite)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getAccreditationsByUniversite",true);
                    Etudes.UniversiteHelper.write(_output,universite);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAccreditationsByUniversite",_opsClass);
                if (_so == null)
                   continue;
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
                try
                {
                    return _self.getAccreditationsByUniversite( universite);
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
    public Etudes.Proposition[] getPropositionByFormation(Etudes.Master formation)
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
                Etudes.RectoratOperations _self = (Etudes.RectoratOperations) _so.servant;
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

}
