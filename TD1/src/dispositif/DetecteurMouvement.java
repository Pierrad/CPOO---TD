package dispositif;

import alerte.GestionAlerte;
import alerte.Notification;
import zone.Zone;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * DetecteurMouvement dispositif class
 */
public class DetecteurMouvement extends Dispositif implements Serializable, IDetecteurMouvement {
    /**
     * We need to have an instance of GestionAlerte to trigger alert if needed
     */
    private GestionAlerte gestionAlerte;

    public DetecteurMouvement(String name, Zone z) {
        super(name, z);
    }

    public DetecteurMouvement(String name, Zone z, GestionAlerte ga) {
        super(name, z);
        this.gestionAlerte = ga;
    }

    @Override
    public GestionAlerte getGestionAlerte() {
        return gestionAlerte;
    }


    @Override
    public void setGestionAlerte(GestionAlerte gestionAlerte) {
        this.gestionAlerte = gestionAlerte;
    }

    /**
     * Call addNotif from GestionAlerte to register a new Notification of alert
     */
    @Override
    public void triggerAlerte() {
        gestionAlerte.addNotif(new Notification("Alerte de votre détecteur de mouvement : " + this.getName() + " dans la zone : " + this.getZone()));
    }
}