package td01;

import dispositif.DetecteurMouvement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DetecteurMouvementTest {
    private DetecteurMouvement dt;

    @BeforeEach
    void setUp() {
        dt = new DetecteurMouvement("Detecteur 1", 1);
    }

    @AfterEach
    void tearDown() {
        dt = null;
    }

    @Test
    void test() {
        System.out.println(dt.toString());
    }
}