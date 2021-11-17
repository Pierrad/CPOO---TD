package dispositifTest;

import dispositif.Camera;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CameraTest {
    private Camera c;

    @BeforeEach
    void setUp() throws Exception {
        c = new Camera("Camera 1", 3);
    }

    @AfterEach
    void tearDown() throws Exception {
        //TODO
    }

    @Test
    void testChargeBatterie() {
        c.setBattery(100);
        Assertions.assertEquals(100, c.getBattery());
        Assertions.assertEquals(100, c.chargeBatterie());
    }

    @Test
    void testAllumer() {
        Assertions.assertEquals(false, c.getState());
        c.allumer();
        Assertions.assertEquals(true, c.getState());
    }

    @Test
    void testEteindre() {
        c.allumer();
        Assertions.assertEquals(true, c.getState());
        c.eteindre();
        Assertions.assertEquals(false, c.getState());
    }

    @Test
    void testVisionnerFlux() {
        c.visionnerFlux();
    }

    @Test
    void testActiver() {
        c.activate();
        Assertions.assertEquals(true, c.getIsActivate());
        c.activate();
        Assertions.assertEquals(false, c.getIsActivate());
    }

    @Test
    void testDesactiver() {
        c.desactiver();
        Assertions.assertEquals(true, c.getIsActivate());
        c.desactiver();
        Assertions.assertEquals(false, c.getIsActivate());
    }
}
