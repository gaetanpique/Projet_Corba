package Etudes;

/**
 * Interface definition : Voeu
 * 
 * @author OpenORB Compiler
 */
public interface VoeuOperations
{
    /**
     * Read accessor for universite attribute
     * @return the attribute value
     */
    public Etudes.Universite universite();

    /**
     * Read accessor for formation attribute
     * @return the attribute value
     */
    public Etudes.Master formation();

    /**
     * Operation valider
     */
    public void valider();

    /**
     * Operation cloturer
     */
    public void cloturer();

    /**
     * Operation accepter
     */
    public void accepter();

    /**
     * Operation refuser
     */
    public void refuser();

    /**
     * Operation refuserDefinitevement
     */
    public void refuserDefinitevement();

    /**
     * Operation majClassement
     */
    public void majClassement(short classement);

}
