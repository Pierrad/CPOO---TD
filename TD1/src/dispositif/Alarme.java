package dispositif;

import zone.Zone;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Alarme dispositif class
 * An alarme can be turn on (can trigger alert) and activated (triggering alert)
 */
public class Alarme extends Dispositif implements Serializable, IAlarme {
    /**
     * The current state of the Alarme (is in Alert or not)
     */
    private Boolean switchState = false;

    public Alarme(String name) {
        super(name);
    }

    public Alarme(String name, Zone z) {
        super(name, z);
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

    /**
     * All the possibilities with this device
     *
     * @return string that list all possibilities
     */
    @Override
    public String possibilities() {
        return super.possibilities() + "4- Allumer ou éteindre votre alarme";
    }
}
