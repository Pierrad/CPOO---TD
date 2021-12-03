package zone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GestionZoneTest {
    private GestionZone gz;

    @BeforeEach
    void setUp() {
        gz = new GestionZone();
    }

    @AfterEach
    void destroy() {
        gz = null;
    }

    @Test
    void testInitializeZone() {
        gz.initializeZone();
        Assertions.assertEquals(1, gz.getListZone().size());
    }

    @Test
    void testSetterZone() {
        ArrayList<Zone> lz = new ArrayList<Zone>();
        lz.add(new Zone("HOUSE"));
        lz.add(new Zone("JARDIN"));
        Assertions.assertEquals(0, gz.getListZone().size());
        gz.setZones(lz);
        Assertions.assertEquals(2, gz.getListZone().size());
    }

    @Test
    void testAddZone() {
        Zone z1 = new Zone("HOUSE", "Maison");
        gz.addZone(z1);
        gz.addZone("JARDIN", "Jardin");
        Assertions.assertEquals(2, gz.getListZone().size());
    }

    @Test
    void testAddZoneToZone() {
        Zone zP = new Zone("House", "maison");
        Zone zC = new Zone("Etage", "etage");
        gz.addZoneToZone(zP, zC);
        Assertions.assertEquals(1, zP.getNestedZone().size());
    }

    @Test
    void testRemoveZone() {
        Zone z1 = new Zone("House", "maison");
        Zone z2 = new Zone("Etage", "etage");
        gz.addZone(z1);
        gz.addZone(z2);
        Assertions.assertEquals(2, gz.getListZone().size());
        gz.removeZone(z1);
        Assertions.assertEquals(1, gz.getListZone().size());
        gz.removeZone("Etage");
        Assertions.assertEquals(0, gz.getListZone().size());
    }

    @Test
    void testGetZoneFromName() {
        Zone z1 = new Zone("House", "maison");
        Zone z2 = new Zone("Etage", "etage");
        gz.addZone(z1);
        gz.addZone(z2);
        Assertions.assertEquals(z1, gz.getZoneFromName("House"));
    }
}
