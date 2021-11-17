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

    @BeforeEach
    void setUp() {
        d = new Dispositif("Dispositif 1");
    }

    @AfterEach
    void tearDown() {
        d = null;
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
    void switchDispositif() {
        d.switchDispositif(true);
    }
}