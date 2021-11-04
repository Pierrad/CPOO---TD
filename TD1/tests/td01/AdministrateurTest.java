package td01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class AdministrateurTest {
    private Administrateur admin;
    private Set<SystemeAlarme> setSysA;

    @BeforeEach
    void setUp() {
        admin = new Administrateur();
        setSysA = new HashSet<SystemeAlarme>();
        setSysA.add(new SystemeAlarme());
    }

    @AfterEach
    void tearDown() {
        admin = null;
    }

    @Test
    void testInstallUpdate() {
        admin.installUpdate();
    }

    @Test
    void testSetSysAlarme() {
        admin.setSystemesAlarme(setSysA);
        Assertions.assertEquals(setSysA, admin.getSystemesAlarme());
    }
}