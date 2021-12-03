package dispositif;

import alerte.GestionAlerte;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.Zone;

public class DetecteurMouvementTest {
    private DetecteurMouvement a;

    @BeforeEach
    void setUp() {
        GestionAlerte ga = new GestionAlerte();
        a = new DetecteurMouvement("Capteur", new Zone("HOUSE"), ga);
    }

    @AfterEach
    void destroy() {
        a = null;
    }

    @Test
    void setterGestionAlerte() {
        GestionAlerte gaa = new GestionAlerte();
        a.setGestionAlerte(gaa);
        Assertions.assertEquals(gaa, a.getGestionAlerte());
    }
    
    @Test
    void testTriggerAlerte() {
        a.triggerAlerte();
        Assertions.assertEquals(1, a.getGestionAlerte().getNotifs().size());
    }
}
