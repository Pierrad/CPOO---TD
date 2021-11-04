package td01;

import dispositif.Dispositif;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class DispositifTest {
    private Dispositif d;
    private Set<LogMessages> sLg;
    private LogMessages lg;
    private Zone z;

    @BeforeEach
    void setUp() {
        d = new Dispositif("Dispositif 1", 1);
        sLg = new HashSet<>();
        lg = new LogMessages();
        lg.setMessage("Un message");
        sLg.add(lg);
        d.setLogs(sLg);
        z = new Zone();
    }

    @AfterEach
    void tearDown() {
        d = null;
        sLg = null;
        lg = null;
        z = null;
    }

    @Test
    void clearLog() {
        Assertions.assertEquals(sLg, d.getLogs());
        d.clearLog();
    }

    @Test
    void getName() {
        Assertions.assertEquals("Dispositif 1", d.getName());
    }

    @Test
    void setName() {
        d.setName("nouveau Dispositif 1");
        Assertions.assertEquals("nouveau Dispositif 1", d.getName());
    }

    @Test
    void getId() {
        Assertions.assertEquals(1, d.getId());
    }

    @Test
    void setId() {
        d.setId(2);
        Assertions.assertEquals(2, d.getId());
    }

    @Test
    void getState() {
        Assertions.assertEquals(false, d.getState());
    }

    @Test
    void setState() {
        d.setState(true);
        Assertions.assertEquals(true, d.getState());
    }

    @Test
    void getLogs() {
        Assertions.assertEquals(sLg, d.getLogs());
    }

    @Test
    void setLogs() {
        d.setLogs(sLg);
        Assertions.assertEquals(sLg, d.getLogs());
    }

    @Test
    void getZone() {
        d.setZone(z);
        Assertions.assertEquals(z, d.getZone());
    }

    @Test
    void setZone() {
        d.setZone(z);
        Assertions.assertEquals(z, d.getZone());
    }

    @Test
    void switchDispositif() {
        d.switchDispositif(true);
    }
}