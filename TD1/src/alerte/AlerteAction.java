package alerte;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Class that represent an action to be called when an alert is trigger
 * An object of this class can be active (when an alert is triggered the action is produced) or inactive.
 */
public class AlerteAction implements Serializable, IAlerteAction {
    private int id;
    private String description;
    private Boolean isActive = true;

    public AlerteAction(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Boolean getActive() {
        return isActive;
    }

    @Override
    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Alerte Action n°" + this.id + " : " + this.description;
    }
}
