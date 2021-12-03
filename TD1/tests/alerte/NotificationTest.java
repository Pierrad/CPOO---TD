package alerte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotificationTest {
    private Notification n;

    @BeforeEach
    void setUp() throws Exception {
        n = new Notification("Nouvelle notification");
    }

    @AfterEach
    void destroy() throws Exception {
        n = null;
    }

    @Test
    void setterID() {
        n.setId(1);
        Assertions.assertEquals(1, n.getId());
    }

    @Test
    void setterMessage() {
        n.setMessage("test");
        Assertions.assertEquals("test", n.getMessage());
    }


    @Test
    void testToString() {
        Assertions.assertEquals("Nouvelle notification", n.toString());
    }
}
