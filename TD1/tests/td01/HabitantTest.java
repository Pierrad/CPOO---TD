package td01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HabitantTest {
    private Habitant h;

    @BeforeEach
    void setUp() {
        h = new Habitant("Habitant 1", "Azerty");
    }

    @AfterEach
    void tearDown() {
        h = null;
    }

    @Test
    void testName() {
        h.setName("Hab");
        Assertions.assertEquals("Hab", h.getName());
    }

    @Test
    void testPassword() {
        h.setPassword("Aze");
        Assertions.assertEquals("Aze", h.getPassword());
    }
}