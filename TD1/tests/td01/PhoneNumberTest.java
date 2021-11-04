package td01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneNumberTest {
    private PhoneNumber ph;

    @BeforeEach
    void setUp() {
        ph = new PhoneNumber();
    }

    @AfterEach
    void tearDown() {
        ph = null;
    }

    @Test
    void testNumber() {
        ph.setNumber("06898555");
        Assertions.assertEquals("06898555", ph.getNumber());
    }
}