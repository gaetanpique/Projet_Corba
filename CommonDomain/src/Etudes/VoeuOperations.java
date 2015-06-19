package Etudes;

/**
 * Interface definition : Voeu
 * 
 * @author OpenORB Compiler
 */
public interface VoeuOperations
{
    /**
     * Read accessor for propositionCorrespondante attribute
     * @return the attribute value
     */
    public Etudes.Proposition propositionCorrespondante();

    /**
     * Read accessor for etudiantCorrespondant attribute
     * @return the attribute value
     */
    public Etudes.Etudiant etudiantCorrespondant();

    /**
     * Read accessor for position attribute
     * @return the attribute value
     */
    public short position();

    /**
     * Write accessor for position attribute
     * @param value the attribute value
     */
    public void position(short value);

    /**
     * Read accessor for classementEtudiant attribute
     * @return the attribute value
     */
    public short classementEtudiant();

    /**
     * Write accessor for classementEtudiant attribute
     * @param value the attribute value
     */
    public void classementEtudiant(short value);

    /**
     * Read accessor for etatVoeu attribute
     * @return the attribute value
     */
    public String etatVoeu();

    /**
     * Write accessor for etatVoeu attribute
     * @param value the attribute value
     */
    public void etatVoeu(String value);

    /**
     * Operation reponseOUI
     */
    public void reponseOUI();

    /**
     * Operation reponseOUIMAIS
     */
    public void reponseOUIMAIS();

    /**
     * Operation reponseNONMAIS
     */
    public void reponseNONMAIS();

    /**
     * Operation reponseNON
     */
    public void reponseNON();

    /**
     * Operation accepterCandidature
     */
    public void accepterCandidature();

    /**
     * Operation refuserCandidature
     */
    public void refuserCandidature();

    /**
     * Operation majClassement
     */
    public void majClassement(short classement);

}
