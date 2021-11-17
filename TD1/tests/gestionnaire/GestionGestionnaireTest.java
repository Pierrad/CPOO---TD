package gestionnaire;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionGestionnaireTest {
    private GestionGestionnaire gg;

    @BeforeEach
    void setUp() {
        gg = new GestionGestionnaire();
    }

    @AfterEach
    void tearDown() {
        gg = null;
    }

    @Test
    void testDefineNewGestionnaire() {
        String n = "PA";
        String p = "password";
        gg.defineNewGestionnaire(n, p);
        Assertions.assertEquals("PA", gg.getCurrentGestionnaire());
    }

    @Test
    void testIsGestionnaire() {
        String n = "PA";
        String p = "password";
        Assertions.assertEquals(false, gg.isGestionnaire(n));
        gg.defineNewGestionnaire(n, p);
        Assertions.assertEquals(true, gg.isGestionnaire(n));
    }

    @Test
    void testDisconnect() {
        Assertions.assertEquals("Default", gg.getCurrentGestionnaire());
        gg.disconnect();
        Assertions.assertNull(gg.getCurrentGestionnaire());
    }

    @Test
    void TestSwitchInterfaceHabitant() {
        // TODO
    }

}
