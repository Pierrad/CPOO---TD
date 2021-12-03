package zone;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Zone class
 */
public class Zone implements Serializable, IZone {
    private String name;
    private String description;
    private ArrayList<Zone> nestedZone = new ArrayList<Zone>();

    public Zone(String zoneName, String desc) {
        name = zoneName;
        description = desc;
    }

    public Zone(String zoneName) {
        name = zoneName;
        description = null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArrayList<Zone> getNestedZone() {
        return nestedZone;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Allow to add a zone to the current zone
     *
     * @param z the zone to be added to the current zone
     */
    @Override
    public void addZoneToNestedZone(Zone z) {
        if (!nestedZone.contains(z)) {
            nestedZone.add(z);
        }
    }

    /**
     * Remove a zone from the current zone
     *
     * @param z the zone to be removed from the current zone
     */
    @Override
    public void removeZoneToNestedZone(Zone z) {
        nestedZone.remove(z);
    }

    @Override
    public String toString() {
        return this.name;
    }

}
