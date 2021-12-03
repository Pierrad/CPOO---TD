package zone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZoneTest {
    private Zone z;

    @BeforeEach
    void setUp() {
        z = new Zone("HOUSE", "La maison");
    }

    @AfterEach
    void destroy() {
        z = null;
    }

    @Test
    void testSetterName() {
        z.setName("JARDIN");
        Assertions.assertEquals("JARDIN", z.getName());
    }

    @Test
    void testSetterDescription() {
        z.setDescription("Description");
        Assertions.assertEquals("Description", z.getDescription());
    }

    @Test
    void testAddNestedZone() {
        z.addZoneToNestedZone(new Zone("ETAGE"));
        Assertions.assertEquals(1, z.getNestedZone().size());
    }

    @Test
    void testRemoveNestedZone() {
        Zone z1 = new Zone("ETAGE");
        z.addZoneToNestedZone(z1);
        Assertions.assertEquals(1, z.getNestedZone().size());
        z.removeZoneToNestedZone(z1);
        Assertions.assertEquals(0, z.getNestedZone().size());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("HOUSE", z.toString());
    }

}
