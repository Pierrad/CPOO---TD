package dispositif;

import alerte.GestionAlerte;
import alerte.Notification;
import zone.Zone;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Capteur dispositif class
 */
public class Capteur extends Dispositif implements Serializable, ICapteur {
    private Integer battery = 100;
    /**
     * We need to have an instance of GestionAlerte to trigger alert if needed
     */
    private GestionAlerte gestionAlerte;

    public Capteur(String name, Zone z) {
        super(name, z);
    }

    public Capteur(String name, Zone z, GestionAlerte ga) {
        super(name, z);
        this.gestionAlerte = ga;
    }

    @Override
    public Integer getBattery() {
        return battery;
    }

    @Override
    public void setBattery(Integer battery) {
        this.battery = battery;
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
        gestionAlerte.addNotif(new Notification("Alerte de votre capteur : " + this.getName() + " dans la zone : " + this.getZone()));
    }

    /**
     * All the possibilities with this device
     *
     * @return string that list all possibilities
     */
    @Override
    public String possibilities() {
        return super.possibilities() + "4- Connaître la batterie de votre capteur";
    }

}
