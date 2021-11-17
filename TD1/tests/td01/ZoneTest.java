package td01;

import dispositif.Dispositif;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.Zone;

import java.util.HashSet;
import java.util.Set;

class ZoneTest {
    private Zone z;

    @BeforeEach
    void setUp() {
        z = new Zone("Name", "description");
    }

    @AfterEach
    void tearDown() {
        z = null;
    }

    @Test
    void testName() {
        z.setName("zone");
        Assertions.assertEquals("zone", z.getName());
    }

    @Test
    void testDispositifs() {
        Set<Dispositif> d = new HashSet<>();
        z.setDispositifs(d);
        Assertions.assertEquals(d, z.getDispositifs());
    }
}