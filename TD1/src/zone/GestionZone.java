package zone;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Controller for the zone class
 */
public class GestionZone implements Serializable, IGestionZone {
    private ArrayList<Zone> listZones = new ArrayList<Zone>();

    public GestionZone() {

    }

    @Override
    public void initializeZone() {
        listZones = new ArrayList<Zone>();
        Zone house = new Zone("HOUSE", "La zone principale de la maison");
        addZone(house);
    }

    @Override
    public void setZones(ArrayList<Zone> zone) {
        this.listZones = zone;
    }

    @Override
    public void addZone(Zone z) {
        if (!listZones.contains(z)) {
            listZones.add(z);
        }
    }

    @Override
    public void addZone(String nom, String description) {
        Zone z = new Zone(nom, description);
        if (!listZones.contains(z)) {
            listZones.add(z);
        }
    }

    /**
     * Allow to add a child Zone to a parent Zone (nested zone)
     *
     * @param parentZone the parent zone
     * @param childZone  the child zone to be nested in parent zone
     */
    @Override
    public void addZoneToZone(Zone parentZone, Zone childZone) {
        parentZone.addZoneToNestedZone(childZone);
    }

    @Override
    public void removeZone(Zone zone) {
        listZones.remove(zone);
    }

    @Override
    public Boolean removeZone(String name) {
        try {
            listZones.removeIf(h -> h.getName().equals(name));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<Zone> getListZone() {
        return this.listZones;
    }

    @Override
    public Zone getZoneFromName(String name) {
        for (Zone z : listZones) {
            if (z.getName().equals(name)) {
                return z;
            }
        }
        return null;
    }

}
