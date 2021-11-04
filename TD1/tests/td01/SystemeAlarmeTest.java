package td01;

import dispositif.GestionDispositif;
import gestionnaire.Gestionnaire;
import habitant.Habitant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SystemeAlarmeTest {
    private Gestionnaire arthur;
    private Habitant hab;
    private SystemeAlarme sysAlarme;
    private Administrateur a;
    private GestionDispositif gd;

    @BeforeEach
    void setUp() {
        arthur = new Gestionnaire("Arthur", "toto");
        hab = new Habitant("Habitant", "Azerty");
        sysAlarme = new SystemeAlarme();
        a = new Administrateur();
        gd = new GestionDispositif();
    }

    @AfterEach
    void tearDown() {
        arthur = null;
        hab = null;
        sysAlarme = null;
        a = null;
        gd = null;
    }

    @Test
    void testConnexion() {
        Assertions.assertTrue(sysAlarme.seConnecter(arthur));
        Assertions.assertFalse(sysAlarme.seConnecter(hab));
    }

    @Test
    void testAddress() {
        sysAlarme.setAdress("24 rue Jean");
        Assertions.assertEquals("24 rue Jean", sysAlarme.getAdress());
    }

    @Test
    void testAdministrateur() {
        sysAlarme.setAdministrateur(a);
        Assertions.assertEquals(a, sysAlarme.getAdministrateur());
    }

    @Test
    void testPhone() {
        Set<PhoneNumber> s = new HashSet<>();
        sysAlarme.setPhoneNumbers(s);
        Assertions.assertEquals(s, sysAlarme.getPhoneNumbers());
    }

    @Test
    void testGestionnaire() {
        sysAlarme.setGestionnaire(arthur);
        Assertions.assertEquals(arthur, sysAlarme.getGestionnaire());
    }

    @Test
    void testHabitants() {
        Set<Habitant> h = new HashSet<>();
        sysAlarme.setHabitants(h);
        Assertions.assertEquals(h, sysAlarme.getHabitants());
    }

    @Test
    void testGestionnaireDispositif() {
        sysAlarme.setGestDispositif(gd);
        Assertions.assertEquals(gd, sysAlarme.getGestDispositif());
    }
}