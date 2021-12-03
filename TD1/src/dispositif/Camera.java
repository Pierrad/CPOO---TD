package dispositif;

import alerte.GestionAlerte;
import alerte.Notification;
import zone.Zone;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Camera dispositif class
 * A camera can be turn on (can record) and activated (is recording)
 */
public class Camera extends Dispositif implements Serializable, ICamera {
    private Integer battery = 100;
    /**
     * The current state of the Alarme (is in Alert or not)
     */
    private Boolean switchState = false;
    /**
     * We need to have an instance of GestionAlerte to trigger alert if needed
     */
    private GestionAlerte gestionAlerte;

    public Camera(String name) {
        super(name);
    }

    public Camera(String name, Zone z) {
        super(name, z);
    }

    public Camera(String name, Zone z, GestionAlerte ga) {
        super(name, z);
        gestionAlerte = ga;
    }

    @Override
    public GestionAlerte getGestionAlerte() {
        return gestionAlerte;
    }

    @Override
    public void setGestionAlerte(GestionAlerte gestionAlerte) {
        this.gestionAlerte = gestionAlerte;
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
    public Boolean getSwitchState() {
        return this.switchState;
    }

    @Override
    public void setSwitchState(Boolean s) {
        if (this.getState().equals(true)) {
            this.switchState = s;
        } else if (this.getState().equals(false)) {
            this.switchState = false;
        }
    }

    @Override
    public void visionnerFlux() {
        System.out.println("Flux");
    }

    /**
     * Call addNotif from GestionAlerte to register a new Notification of alert
     */
    @Override
    public void triggerAlerte() {
        gestionAlerte.addNotif(new Notification("Alerte de votre caméra : " + this.getName() + " dans la zone : " + this.getZone()));
    }

    /**
     * All the possibilities with this device
     *
     * @return string that list all possibilities
     */
    @Override
    public String possibilities() {
        return super.possibilities() + "4- Connaître la batterie de votre caméra\n" + "5- Allumer ou éteindre votre caméra";
    }

}
