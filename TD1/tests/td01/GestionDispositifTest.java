package td01;

import dispositif.Dispositif;
import dispositif.GestionDispositif;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GestionDispositifTest {
    private Dispositif d1;
    private Dispositif d2;
    private GestionDispositif gd1;

    @BeforeEach
    void setUp() {
        d1 = new Dispositif("Dispositif 1", 1);
        d2 = new Dispositif("Dispositif 2", 2);
        gd1 = new GestionDispositif();
        gd1.add(d1);
        gd1.add(d2);
    }

    @Test
    void testList() {
        Assertions.assertEquals(2, gd1.list().size());
    }

    @Test
    void testDemanderList() {
        ArrayList<Dispositif> l = gd1.demanderListeDispositif();
        Assertions.assertEquals(l, gd1.getListDispositifs());
    }

    @Test
    void testSelect() {
        gd1.select(d1);
    }

    @Test
    void testBatteries() {
        gd1.testBatteries();
    }

    @Test
    void testDispositif() {
        gd1.setDispositif(d1);
        Assertions.assertEquals(d1, gd1.getDispositif());
    }

    @Test
    void testSelection() {
        gd1.setSelected(d1);
        Assertions.assertEquals(d1, gd1.getSelected());
    }

    @Test
    void testListDispositif() {
        gd1.setListDispositifs(gd1.demanderListeDispositif());
        Assertions.assertEquals(gd1.demanderListeDispositif(), gd1.getListDispositifs());
    }
}
