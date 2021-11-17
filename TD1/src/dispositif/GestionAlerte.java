package dispositif;

public class GestionAlerte
{
    /*
    Boolean qui définit si l'alerte est active ou non.
     */
    private boolean AlerteActive;

    /*
    Construis la gestion de l'alerte par défaut a false.
     */
    public GestionAlerte()
    {
        AlerteActive=false;
    }

    /*
    Récupère le statut de l'alerte
     */
    public boolean getAlertStatus()
    {
        return AlerteActive;
    }

    /*
    Change le statut de l'alerte sur true
     */
    public void setAlertOn()
    {
        AlerteActive=true;
    }

    /*
    Change le statut de l'alerte sur false;
     */
    public void setAlertOff()
    {
        AlerteActive=false;
    }
}
