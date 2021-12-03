package dispositif;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.Zone;

public class SireneTest {
    private Sirene a;

    @BeforeEach
    void setUp() {
        a = new Sirene("Alarme", new Zone("HOUSE"));
    }

    @AfterEach
    void destroy() {
        a = null;
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
    void testStop() {
        a.setState(true);
        a.setSwitchState(true);
        a.stop();
        Assertions.assertFalse(a.getSwitchState());
    }

    @Test
    void testPossibilities() {
        String s = "Vous pouvez : \n" + "1- Activer ou désactiver votre dispositif\n" + "2- Obtenir les logs de votre dispositif\n" + "3- Connaître la zone du dispositif\n" + "4- Allumer ou éteindre votre sirène";
        Assertions.assertEquals(s, a.possibilities());
    }
}
