package dispositifTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dispositif.Camera;

class CameraTest {
	private Camera c;
	
	@BeforeEach
	void setUp() throws Exception
	{
		c = new Camera("Camera 1", 3);
	}

	@AfterEach
	void tearDown() throws Exception
	{
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
        c.activer();
        Assertions.assertEquals(true, c.getState());
        c.activer();
        Assertions.assertEquals(false, c.getState());
    }
    
    @Test
    void testDesactiver() {
        c.activer();
        Assertions.assertEquals(true, c.getState());
        c.activer();
        Assertions.assertEquals(false, c.getState());
    }
}
