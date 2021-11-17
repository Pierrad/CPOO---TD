package td01;

import gestionnaire.GestionGestionnaire;
import gestionnaire.Gestionnaire;
import habitant.Habitant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HabitantToGestionnaireTest {
    private Habitant h;
    private GestionGestionnaire gg;

    @BeforeEach
    void setUp() {
        h = new Habitant("Arthur", "Azerty");
        gg = new GestionGestionnaire();
    }

    @Test
    void changeGestionnaire() {
        Gestionnaire testGestionnaire = new Gestionnaire("default", "default");
        Assertions.assertEquals(gg.getCurrentGestionnaire(), testGestionnaire);
        gg.defineNewGestionnaire(h.getName(), h.getPassword());
        testGestionnaire = new Gestionnaire("Arthur", "Azerty");
        Assertions.assertEquals(gg.getCurrentGestionnaire(), testGestionnaire);
    }

}
