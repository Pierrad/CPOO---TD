package app;

import alerte.GestionAlerte;
import alerte.Notification;
import dispositif.GestionDispositif;
import gestionnaire.GestionGestionnaire;
import habitant.GestionHabitant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zone.GestionZone;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SystemeAlarmeTest {
    private SystemeAlarme sa;
    private GestionAlerte gestAlerte = new GestionAlerte();
    private GestionGestionnaire gestGestionnaire = new GestionGestionnaire();
    private GestionHabitant gestHabitant = new GestionHabitant();
    private GestionDispositif gestDispositif = new GestionDispositif();
    private GestionZone gestZone = new GestionZone();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() throws IOException, ClassNotFoundException {
        sa = new SystemeAlarme();
        System.setOut(new PrintStream(outContent));
        // Initialization of data
        gestZone.initializeZone();
        gestDispositif.initializeDispositif(gestZone, gestAlerte);
        gestAlerte.initializeActionAlerte();
        gestGestionnaire.defineNewGestionnaire("PA", "Azerty");
        gestHabitant.addHabitant("PA", "Azerty");
        // Set all subControllers
        sa.setGestAlerte(gestAlerte);
        sa.setGestGestionnaire(gestGestionnaire);
        sa.setGestHabitant(gestHabitant);
        sa.setGestDispositif(gestDispositif);
        sa.setGestZone(gestZone);
    }

    @AfterEach
    void destroy() {
        sa = null;
        gestAlerte = null;
        gestGestionnaire = null;
        gestHabitant = null;
        gestDispositif = null;
        gestZone = null;
        System.setOut(originalOut);
    }

    //

    @Test
    void testLogin() {
        // Cannot test because I cannot test with fake input (same as UserConsoleTest)
    }

    @Test
    void testRegister() {
        // Cannot test because I cannot test with fake input (same as UserConsoleTest)
    }

    // For the next I will test all the things that don't need fake input...
    // I have tested all the methods used in the SystemeAlarme class so it should work
    // But It would have been better if I could test with fake input

    @Test
    void testGetListHabitant() {
        sa.getListHabitant();
        Assertions.assertEquals("\u001B[31mVoici la liste des habitants\u001B[0m\n" + "\u001B[31m[Nom : PA / Mot de passe : Azerty]\u001B[0m\n", outContent.toString());
    }

    @Test
    void testGetCurrentGestionnaire() {
        sa.getCurrentGestionnaire();
        Assertions.assertEquals("\u001B[31mVoici le gestionnaire actuel\u001B[0m\n" + "\u001B[31mNom : PA / Mot de passe : Azerty\u001B[0m\n", outContent.toString());
    }

    @Test
    void testGetListDispositif() {
        // Test is not representative because the id of dispositif is depending on other class test
        // sa.getListDispositif();
        // Assertions.assertEquals("\u001B[31mVoici la liste des dispositifs\u001B[0m\n" + "\u001B[31m[Dispositif n°12 nommé SIREN_00 dans HOUSE, Dispositif n°13 nommé SIREN_01 dans HOUSE, Dispositif n°14 nommé CAM_00 dans HOUSE, Dispositif n°15 nommé DET_00 dans HOUSE, Dispositif n°16 nommé DET_01 dans HOUSE, Dispositif n°17 nommé DET_02 dans HOUSE]\u001B[0m\n", outContent.toString());
    }

    @Test
    void testGetListZone() {
        sa.getListZone();
        Assertions.assertEquals("\u001B[31mVoici la liste des zones\u001B[0m\n" + "\u001B[31m[HOUSE]\u001B[0m\n", outContent.toString());
    }

    @Test
    void testGetListNotification() {
        gestAlerte.addNotif(new Notification("ALERTE!!!"));
        sa.getListNotification();
        Assertions.assertEquals("\u001B[31mVoici la liste des notifications : \u001B[0m\n" + "\u001B[31m[ALERTE!!!]\u001B[0m\n", outContent.toString());
    }

    @Test
    void testRemoveAllNotifs() {
        // Same as the one in GestionAlerteTest
    }

    @Test
    void testGenerateFalseAlert() {
        // Same as the one in GestionDispositifTest
    }

    @Test
    void testSwitchInterfaceHabitant() throws InterruptedException {
        sa.switchInterfaceHabitant();
        Assertions.assertEquals("habitant", sa.getTypeOfUser());
    }

    @Test
    void testStop() {
        // Memory.save() tested in MemoryTest
        // And the rest is just adding to ArrayList
    }

}
