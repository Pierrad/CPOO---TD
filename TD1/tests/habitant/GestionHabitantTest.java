package habitant;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionHabitantTest {
    private GestionHabitant gh;

    @BeforeEach
    void setUp() {
        gh = new GestionHabitant();
    }

    @AfterEach
    void destroy() {
        gh = null;
    }

    @Test
    void testAddHabitant() {
        Habitant h = new Habitant("Test", "Test");
        gh.addHabitant(h);
        Assertions.assertEquals(1, gh.getListHabitant().size());
        gh.addHabitant("Test1", "Test2");
        Assertions.assertEquals(2, gh.getListHabitant().size());
    }

    @Test
    void testRemoveHabitant() {
        Habitant h1 = new Habitant("Test", "Test");
        gh.addHabitant(h1);
        Assertions.assertEquals(1, gh.getListHabitant().size());
        gh.removeHabitant("Test");
        Assertions.assertEquals(0, gh.getListHabitant().size());
    }

    @Test
    void testGetHabitant() {
        Habitant h = new Habitant("Test", "Test");
        gh.addHabitant(h);
        Assertions.assertEquals(h.toString(), gh.getHabitant(h).toString());
        Assertions.assertEquals(h.toString(), gh.getHabitant("Test").toString());
        Assertions.assertEquals(h.toString(), gh.getHabitant("Test", "Test").toString());
    }

    @Test
    void testGetListHabitant() {
        Habitant h = new Habitant("Test", "Test");
        gh.addHabitant(h);
        Assertions.assertEquals(1, gh.getListHabitant().size());
    }
}
