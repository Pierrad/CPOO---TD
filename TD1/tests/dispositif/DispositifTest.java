package dispositif;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.Zone;

public class DispositifTest {
    private Dispositif d;

    @BeforeEach
    void setUp() {
        d = new Dispositif("Dispositif", new Zone("House"));
    }

    @AfterEach
    void destroy() {
        d = null;
    }

    @Test
    void testSetterName() {
        d.setName("Test");
        Assertions.assertEquals("Test", d.getName());
    }

    @Test
    void testSetterID() {
        d.setId(2);
        Assertions.assertEquals(2, d.getId());
    }

    @Test
    void testSetterZone() {
        Zone z = new Zone("Jardin");
        d.setZone(z);
        Assertions.assertEquals(z, d.getZone());
    }

    @Test
    void testSetterState() {
        d.setState(true);
        Assertions.assertEquals(true, d.getState());
    }

    @Test
    void testSetterLogs() {
        String[] logs = new String[]{"A", "B", "C"};
        d.setLogs(logs);
        Assertions.assertEquals(logs, d.getLogs());
    }

    @Test
    void testClearLogs() {
        String[] logs = new String[]{"A", "B", "C"};
        d.setLogs(logs);
        Assertions.assertEquals(logs, d.getLogs());
        d.clearLog();
        Assertions.assertNull(d.getLogs());
    }

    @Test
    void testPossibilities() {
        String s = "Vous pouvez : \n" + "1- Activer ou désactiver votre dispositif\n" + "2- Obtenir les logs de votre dispositif\n" + "3- Connaître la zone du dispositif\n";
        Assertions.assertEquals(s, d.possibilities());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Dispositif n°" + d.getId() + " nommé Dispositif dans House", d.toString());
    }
}
