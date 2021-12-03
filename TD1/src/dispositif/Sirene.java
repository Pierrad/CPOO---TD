package dispositif;

import zone.Zone;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Sirene dispositif class
 * A sirene can be turn on (can trigger alert) and activated (triggering alert)
 */
public class Sirene extends Dispositif implements Serializable, ISirene {
    /**
     * The current state of the Alarme (is in Alert or not)
     */
    private Boolean switchState = false;

    public Sirene(String name, Zone z) {
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

    @Override
    public void stop() {
        setSwitchState(false);
    }

    /**
     * All the possibilities with this device
     *
     * @return string that list all possibilities
     */
    @Override
    public String possibilities() {
        return super.possibilities() + "4- Allumer ou éteindre votre sirène";
    }

}