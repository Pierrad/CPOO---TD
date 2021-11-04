package td01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {

    private Message msg;

    @BeforeEach
    void setUp() {
        msg = new Message("C'est un message incroyable de fou");
    }

    @AfterEach
    void tearDown() {
        msg = null;
    }

    @Test
    void test() {
        Assertions.assertEquals("C'est un message incroyable de fou", msg.getMessage());
        msg.setMessage("wow");
        Assertions.assertEquals("wow", msg.getMessage());
    }


}
