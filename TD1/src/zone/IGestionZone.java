package zone;

import java.util.ArrayList;

public interface IGestionZone {
    void initializeZone();

    void setZones(ArrayList<Zone> zone);

    void addZone(Zone z);

    void addZone(String nom, String description);

    void addZoneToZone(Zone parentZone, Zone childZone);

    void removeZone(Zone zone);

    Boolean removeZone(String name);

    ArrayList<Zone> getListZone();

    Zone getZoneFromName(String name);
}
