package habitant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HabitantTest {
    private Habitant h;

    @BeforeEach
    void setUp() {
        h = new Habitant("Habitant", "Azerty");
    }

    @AfterEach
    void destroy() {
        h = null;
    }

    @Test
    void testSetterName() {
        h.setName("Test");
        Assertions.assertEquals("Test", h.getName());
    }

    @Test
    void testSetterPassword() {
        h.setPassword("AZERTY");
        Assertions.assertEquals("AZERTY", h.getPassword());
    }

    @Test
    void testLogin() {
        Assertions.assertTrue(h.login("Habitant", "Azerty"));
        Assertions.assertFalse(h.login("Hade", "fre"));
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Nom : Habitant / Mot de passe : Azerty", h.toString());
    }

}
