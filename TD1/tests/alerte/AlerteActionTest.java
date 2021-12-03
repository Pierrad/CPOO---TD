package alerte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlerteActionTest {
    private AlerteAction aa;

    @BeforeEach
    void setUp() throws Exception {
        aa = new AlerteAction(0, "Nouvelle Alerte action");
    }

    @AfterEach
    void destroy() throws Exception {
        aa = null;
    }

    @Test
    void setterID() {
        aa.setId(1);
        Assertions.assertEquals(1, aa.getId());
    }

    @Test
    void setterDescription() {
        aa.setDescription("test");
        Assertions.assertEquals("test", aa.getDescription());
    }

    @Test
    void setterIsActive() {
        aa.setActive(false);
        Assertions.assertEquals(false, aa.getActive());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Alerte Action n°0 : Nouvelle Alerte action", aa.toString());
    }
}
