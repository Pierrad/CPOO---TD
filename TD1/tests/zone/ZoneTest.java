package testZone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zone.Zone;

/** Test classe de Zone
 * @author CAPARROS Damien
 **/

class ZoneTest {

	@BeforeEach
	void setUp() throws Exception
	{

	}

	@AfterEach
	void tearDown() throws Exception
	{

	}

	@Test
	void test()
	{

		// Test des constructeur ------------------------

		Zone salon = new Zone("Salon","C'est le salon");
		Zone chambre = new Zone("Chambre");

		// Test des get ---------------------------------

		salon.getName();
		salon.getDesc();

		chambre.getName();
		chambre.getDesc();

		// Test des set ---------------------------------

		salon.setName("Salon01");
		salon.setDesc("Salon, salle à manger");

		chambre.setName("Chambre01");
		chambre.setDesc("Chambre de Julien");

		}

}
