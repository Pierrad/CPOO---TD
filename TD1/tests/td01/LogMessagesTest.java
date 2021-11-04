package td01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogMessagesTest {
    private LogMessages lg;

    @BeforeEach
    void setUp() {
        lg = new LogMessages();
    }

    @AfterEach
    void tearDown() {
        lg = null;
    }

    @Test
    void testMessage() {
        lg.setMessage("Message");
        Assertions.assertEquals("Message", lg.getMessage());
    }
}