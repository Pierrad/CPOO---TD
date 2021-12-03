package dispositif;

import alerte.GestionAlerte;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.GestionZone;
import zone.Zone;

import java.util.ArrayList;

public class GestionDispositifTest {
    private GestionDispositif gd;

    @BeforeEach
    void setUp() {
        gd = new GestionDispositif();
    }

    @AfterEach
    void destroy() {
        gd = null;
    }

    @Test
    void testInitializeDispositif() {
        GestionZone gz = new GestionZone();
        GestionAlerte ga = new GestionAlerte();
        gd.initializeDispositif(gz, ga);
        Assertions.assertEquals(6, gd.getListDispositif().size());
    }

    @Test
    void testAddDispositif() {
        Dispositif d = new Dispositif("D", new Zone("House"));
        gd.addDispositif(d);
        Assertions.assertEquals(1, gd.getListDispositif().size());
        gd.addDispositif("Test");
        Assertions.assertEquals(2, gd.getListDispositif().size());
        gd.addDispositif("Test2", new Zone("Jardin"));
        Assertions.assertEquals(3, gd.getListDispositif().size());
        gd.addDispositif("Test3", new Zone("Etage"), "CAMERA", new GestionAlerte());
        Assertions.assertEquals(4, gd.getListDispositif().size());
    }

    @Test
    void testGetDispositifFromName() {
        Dispositif d = new Dispositif("D");
        gd.addDispositif(d);
        Assertions.assertEquals(d, gd.getDispositifFromName("D"));
    }

    @Test
    void testChangeZone() {
        Dispositif d = new Dispositif("D", new Zone("HOUSE"));
        Zone z = new Zone("Jardin");
        GestionZone gz = new GestionZone();
        gz.addZone(z);
        gd.addDispositif(d);
        gd.changeZone("D", "Jardin", gz);
        Assertions.assertEquals(z.toString(), d.getZone().toString());
    }

    @Test
    void testRemoveDispositifByName() {
        Dispositif d = new Dispositif("D", new Zone("HOUSE"));
        gd.addDispositif(d);
        Assertions.assertEquals(1, gd.getListDispositif().size());
        gd.removeDispositifByName("D");
        Assertions.assertEquals(0, gd.getListDispositif().size());
    }

    @Test
    void testGetListDipositifInZone() {
        ArrayList<Dispositif> listOfDispositifInZone = new ArrayList<>();
        Zone z = new Zone("House");
        Dispositif d = new Dispositif("D", z);
        Dispositif d1 = new Dispositif("D1", z);
        listOfDispositifInZone.add(d);
        listOfDispositifInZone.add(d1);
        gd.addDispositif(d);
        gd.addDispositif(d1);
        Assertions.assertEquals(listOfDispositifInZone.size(), gd.getListDispositif(z).size());
    }

    @Test
    void testActivateAllDispositifInZone() {
        Zone z = new Zone("House");
        DetecteurMouvement c = new DetecteurMouvement("Camera", z);
        Capteur d = new Capteur("Capteur", z);
        gd.addDispositif(c);
        gd.addDispositif(d);
        gd.activateAllDispositifInZone(z);
        Assertions.assertTrue(c.getState());
        Assertions.assertTrue(d.getState());
    }

    @Test
    void testDesactivateAllDispositifInZone() {
        Zone z = new Zone("House");
        DetecteurMouvement c = new DetecteurMouvement("Camera", z);
        Capteur d = new Capteur("Capteur", z);
        gd.addDispositif(c);
        gd.addDispositif(d);
        gd.activateAllDispositifInZone(z);
        Assertions.assertTrue(c.getState());
        Assertions.assertTrue(d.getState());
        gd.desactivateAllDispositifInZone(z);
        Assertions.assertFalse(c.getState());
        Assertions.assertFalse(d.getState());
    }

    @Test
    void testDispatchCommande() {
        Dispositif d = new Dispositif("Dispositif", new Zone("House"));
        gd.addDispositif(d);
        Assertions.assertEquals("Votre dispositif est maintenant activée.", gd.dispatchCommande("1", d));
        Assertions.assertEquals("[]", gd.dispatchCommande("2", d));
        Assertions.assertEquals("House", gd.dispatchCommande("3", d));
        Camera c = new Camera("Camera", new Zone("House"), new GestionAlerte());
        gd.addDispositif(c);
        Assertions.assertEquals("100%", gd.dispatchCommande("4", c));
        Assertions.assertEquals("Votre Camera est désactivée et éteinte", gd.dispatchCommande("5", c));
        Alarme a = new Alarme("Alarme", new Zone("House"));
        Assertions.assertEquals("Votre Alarme est désactivée et éteinte", gd.dispatchCommande("4", a));
        Capteur ca = new Capteur("Capteur", new Zone("House"));
        Assertions.assertEquals("100%", gd.dispatchCommande("4", ca));
        Sirene s = new Sirene("Sirene", new Zone("House"));
        Assertions.assertEquals("Votre Sirene est désactivée et éteinte", gd.dispatchCommande("4", s));
    }

    @Test
    void testGenerateFalseAlert() {
        GestionAlerte ga = new GestionAlerte();
        ga.initializeActionAlerte();
        gd.initializeDispositif(new GestionZone(), ga);
        Capteur ca = new Capteur("Capteur", new Zone("House"), ga);
        Alarme a = new Alarme("Alarme", new Zone("House"));
        gd.addDispositif(ca);
        gd.addDispositif(a);
        gd.generateFalseAlert(ga);
        Assertions.assertEquals(5, ga.getNotifs().size());
        for (Dispositif d : gd.getListDispositif()) {
            if (d instanceof Camera) {
                Assertions.assertTrue(d.getState());
                Assertions.assertTrue(((Camera) d).getSwitchState());
            }
            if (d instanceof Alarme) {
                Assertions.assertTrue(d.getState());
                Assertions.assertTrue(((Alarme) d).getSwitchState());
            }
            if (d instanceof Sirene) {
                Assertions.assertTrue(d.getState());
                Assertions.assertTrue(((Sirene) d).getSwitchState());
            }
        }

    }

    @Test
    void testReinitializeDispositifWithGestAlert() {
        GestionAlerte ga = new GestionAlerte();
        gd.initializeDispositif(new GestionZone(), ga);
        Capteur ca = new Capteur("Capteur", new Zone("House"), ga);
        Alarme a = new Alarme("Alarme", new Zone("House"));
        gd.addDispositif(ca);
        gd.addDispositif(a);
        GestionAlerte ga2 = new GestionAlerte();
        gd.reinitializeDispositifWithGestAlert(ga2);
        for (Dispositif d : gd.getListDispositif()) {
            if (d instanceof Camera) {
                Assertions.assertEquals(ga2, ((Camera) d).getGestionAlerte());
            }
            if (d instanceof Capteur) {
                Assertions.assertEquals(ga2, ((Capteur) d).getGestionAlerte());
            }
            if (d instanceof DetecteurMouvement) {
                Assertions.assertEquals(ga2, ((DetecteurMouvement) d).getGestionAlerte());
            }
        }
    }
}

