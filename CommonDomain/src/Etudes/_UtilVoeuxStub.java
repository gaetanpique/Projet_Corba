package Etudes;

/**
 * Interface definition : UtilVoeux
 * 
 * @author OpenORB Compiler
 */
public class _UtilVoeuxStub extends org.omg.CORBA.portable.ObjectImpl
        implements UtilVoeux
{
    static final String[] _ids_list =
    {
        "IDL:Etudes/UtilVoeux:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Etudes.UtilVoeuxOperations.class;

    /**
     * Operation getMeilleurePropositionByEtudiant
     */
    public Etudes.Voeu[] getMeilleurePropositionByEtudiant(Etudes.Etudiant etudiant)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getMeilleurePropositionByEtudiant",true);
                    Etudes.EtudiantHelper.write(_output,etudiant);
                    _input = this._invoke(_output);
                    Etudes.Voeu[] _arg_ret = Etudes.listVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getMeilleurePropositionByEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    return _self.getMeilleurePropositionByEtudiant( etudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation soumettreVoeu
     */
    public void soumettreVoeu(Etudes.Proposition aSoumettre, Etudes.Etudiant soumetteur, short position)
        throws Etudes.NombreMaxDeVoeuxAtteintException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("soumettreVoeu",false);
                    Etudes.PropositionHelper.write(_output,aSoumettre);
                    Etudes.EtudiantHelper.write(_output,soumetteur);
                    _output.write_short(position);
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
                    if (_exception_id.equals(Etudes.NombreMaxDeVoeuxAtteintExceptionHelper.id()))
                    {
                        throw Etudes.NombreMaxDeVoeuxAtteintExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("soumettreVoeu",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    _self.soumettreVoeu( aSoumettre,  soumetteur,  position);
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
     * Operation getVoeuxByEtudiant
     */
    public Etudes.Voeu[] getVoeuxByEtudiant(Etudes.Etudiant etudiant)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getVoeuxByEtudiant",true);
                    Etudes.EtudiantHelper.write(_output,etudiant);
                    _input = this._invoke(_output);
                    Etudes.Voeu[] _arg_ret = Etudes.listVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getVoeuxByEtudiant",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    return _self.getVoeuxByEtudiant( etudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getVoeuxByUniversite
     */
    public Etudes.Voeu[] getVoeuxByUniversite(Etudes.Universite universite)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getVoeuxByUniversite",true);
                    Etudes.UniversiteHelper.write(_output,universite);
                    _input = this._invoke(_output);
                    Etudes.Voeu[] _arg_ret = Etudes.listVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getVoeuxByUniversite",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    return _self.getVoeuxByUniversite( universite);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getVoeuxByRectorat
     */
    public Etudes.Voeu[] getVoeuxByRectorat(Etudes.Rectorat rectoratConcerne)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getVoeuxByRectorat",true);
                    Etudes.RectoratHelper.write(_output,rectoratConcerne);
                    _input = this._invoke(_output);
                    Etudes.Voeu[] _arg_ret = Etudes.listVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getVoeuxByRectorat",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    return _self.getVoeuxByRectorat( rectoratConcerne);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation classerVoeuxParProposition
     */
    public void classerVoeuxParProposition(Etudes.Proposition p)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("classerVoeuxParProposition",false);
                    Etudes.PropositionHelper.write(_output,p);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("classerVoeuxParProposition",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    _self.classerVoeuxParProposition( p);
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
     * Operation classerVoeuxParUniversite
     */
    public void classerVoeuxParUniversite(Etudes.Universite u)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("classerVoeuxParUniversite",false);
                    Etudes.UniversiteHelper.write(_output,u);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("classerVoeuxParUniversite",_opsClass);
                if (_so == null)
                   continue;
                Etudes.UtilVoeuxOperations _self = (Etudes.UtilVoeuxOperations) _so.servant;
                try
                {
                    _self.classerVoeuxParUniversite( u);
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
