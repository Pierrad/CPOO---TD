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
    void destroy() {
        gg = null;
    }

    @Test
    void testGetCurrentGestionnaire() {
        Assertions.assertEquals("Client", gg.getCurrentGestionnaire().getName());
        Assertions.assertEquals("1234", gg.getCurrentGestionnaire().getPassword());
    }

    @Test
    void testDefineNewGestionnaire() {
        gg.defineNewGestionnaire("Test", "Test");
        Assertions.assertEquals("Test", gg.getCurrentGestionnaire().getName());
        Assertions.assertEquals("Test", gg.getCurrentGestionnaire().getPassword());
    }

    @Test
    void testIsGestionnaire() {
        Gestionnaire g = new Gestionnaire("Client", "1234");
        Assertions.assertTrue(gg.isGestionnaire(g.getName()));
    }

    @Test
    void testDisconnect() {
        gg.disconnect();
        Assertions.assertNull(gg.getCurrentGestionnaire());
    }
}
