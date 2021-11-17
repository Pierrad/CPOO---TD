package testZone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zone.GestionZone;

/**
 * Classe GestionZoneTest
 * @author Marie ORFILA
 *
 */

class GestionZoneTest
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testAddZone()
	{
		GestionZone gz = new GestionZone();
	    gz.addZone("nameZone", "descriptionZone");
	    gz.addZone("nameZone2", "descriptionZone2");

	    assertEquals(gz.getZones().size(), 2);
	}

	@Test
	void testRemoveZone()
	{
		GestionZone gz2 = new GestionZone();
		gz2.addZone("nameZone", "descriptionZone");
		gz2.addZone("nameZone2", "descriptionZone2");
	    gz2.addZone("nameZone3", "descriptionZone3");
	    gz2.addZone("nameZoneu4", "descriptionZone4");

	    assertEquals(gz2.getZones().size(), 4);

	    gz2.removeZone(gz2.getZones().get(0));
	    gz2.removeZone(gz2.getZones().get(2));

	    assertEquals(gz2.getZones().size(), 2);

	}

}
