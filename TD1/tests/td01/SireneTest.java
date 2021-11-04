package td01;

import dispositif.Sirene;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SireneTest {
    private Sirene s;

    @BeforeEach
    void setUp() {
        s = new Sirene("Sirene 1", 1);
    }

    @AfterEach
    void tearDown() {
        s = null;
    }

    @Test
    void testStop() {
        s.stop();
    }
}