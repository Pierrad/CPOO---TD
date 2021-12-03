package dispositif;

import alerte.GestionAlerte;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.Zone;

public class CameraTest {
    private Camera a;

    @BeforeEach
    void setUp() {
        GestionAlerte ga = new GestionAlerte();
        a = new Camera("Camera", new Zone("HOUSE"), ga);
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
    void setterBattery() {
        a.setBattery(94);
        Assertions.assertEquals(94, a.getBattery());
    }

    @Test
    void testSetterSwitchState() {
        Assertions.assertFalse(a.getSwitchState());
        a.setState(true);
        a.setSwitchState(true);
        Assertions.assertTrue(a.getSwitchState());
        a.setSwitchState(false);
        a.setState(false);
        a.setSwitchState(true);
        Assertions.assertFalse(a.getSwitchState());
    }

    @Test
    void testTriggerAlerte() {
        a.triggerAlerte();
        Assertions.assertEquals(1, a.getGestionAlerte().getNotifs().size());
    }

    @Test
    void testPossibilities() {
        String s = "Vous pouvez : \n" + "1- Activer ou désactiver votre dispositif\n" + "2- Obtenir les logs de votre dispositif\n" + "3- Connaître la zone du dispositif\n" + "4- Connaître la batterie de votre caméra\n" + "5- Allumer ou éteindre votre caméra";
        Assertions.assertEquals(s, a.possibilities());
    }
}
