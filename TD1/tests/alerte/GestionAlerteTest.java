package alerte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionAlerteTest {
    private GestionAlerte ga;

    @BeforeEach
    void setUp() {
        ga = new GestionAlerte();
    }

    @AfterEach
    void destroy() {
        ga = null;
    }

    @Test
    void testInitializationActionAlert() {
        ga.initializeActionAlerte();
        Assertions.assertEquals(2, ga.getAlerteActions().size());
    }

    @Test
    void testAddNotifs() {
        Notification notif = new Notification("test");
        ga.addNotif(notif);
        Assertions.assertEquals(1, ga.getNotifs().size());
    }

    @Test
    void testRemoveNotifs() {
        Notification notif = new Notification("test");
        Notification notif2 = new Notification("test2");
        ga.addNotif(notif);
        ga.addNotif(notif2);
        Assertions.assertEquals(2, ga.getNotifs().size());
        ga.removeNotif(notif2);
        Assertions.assertEquals(1, ga.getNotifs().size());
    }

    @Test
    void testRemoveAllNotifs() {
        Notification notif = new Notification("test");
        Notification notif2 = new Notification("test2");
        ga.addNotif(notif);
        ga.addNotif(notif2);
        Assertions.assertEquals(2, ga.getNotifs().size());
        ga.removeAllNotifs();
        Assertions.assertEquals(0, ga.getNotifs().size());
    }

    @Test
    void testAddAlerteAction() {
        AlerteAction aa = new AlerteAction(0, "test");
        ga.addAlerteAction(aa);
        ga.addAlerteAction(1, "test2");
        Assertions.assertEquals(2, ga.getAlerteActions().size());
    }

    @Test
    void testGetActivatedActions() {
        AlerteAction aa = new AlerteAction(0, "test");
        ga.addAlerteAction(aa);
        aa.setActive(false);
        ga.addAlerteAction(1, "test2");
        Assertions.assertEquals(1, ga.getAlerteActionsActivated().size());
    }

    @Test
    void testRemoveAlerteAction() {
        AlerteAction aa = new AlerteAction(0, "test");
        ga.addAlerteAction(aa);
        ga.addAlerteAction(1, "test2");
        ga.removeAlerteAction(aa);
        Assertions.assertEquals(1, ga.getAlerteActions().size());
        ga.removeAlerteAction(1, "test2");
        Assertions.assertEquals(0, ga.getAlerteActions().size());
    }

    @Test
    void testEditAlertAction() {
        String s = "0";
        ga.initializeActionAlerte();
        ga.editAlertAction(s);
        Assertions.assertEquals(1, ga.getAlerteActionsActivated().size());
    }

    @Test
    void testActivatedListContainsId() {
        ga.initializeActionAlerte();
        Assertions.assertTrue(ga.activatedListContainsId(1));
        ga.editAlertAction("0");
        Assertions.assertFalse(ga.activatedListContainsId(1));
    }

}
