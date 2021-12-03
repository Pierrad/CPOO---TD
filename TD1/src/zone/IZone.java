package zone;

import java.util.ArrayList;

public interface IZone {
    String getName();

    String getDescription();

    ArrayList<Zone> getNestedZone();

    void setName(String name);

    void setDescription(String description);

    void addZoneToNestedZone(Zone z);

    void removeZoneToNestedZone(Zone z);
}
