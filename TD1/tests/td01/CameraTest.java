package td01;

import dispositif.Camera;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CameraTest {
    private Camera c;

    @BeforeEach
    void setUp() {
        c = new Camera("Camera 1", 3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testChargeBatterie() {
        c.setBattery(100);
        Assertions.assertEquals(100, c.getBattery());
        Assertions.assertEquals(100, c.chargeBatterie());
    }

    @Test
    void testAllumage() {
        Assertions.assertEquals(false, c.getState());
        c.allumer();
        Assertions.assertEquals(true, c.getState());
    }

    @Test
    void testExtinction() {
        c.allumer();
        Assertions.assertEquals(true, c.getState());
        c.eteindre();
        Assertions.assertEquals(false, c.getState());
    }

    @Test
    void testFlux() {
        c.visionnerFlux();
    }
}