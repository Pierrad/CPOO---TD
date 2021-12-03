package app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private App a;

    @BeforeEach
    void setUp() {
        a = new App();
    }

    @AfterEach
    void destroy() {
        a = null;
    }

    @Test
    void testApp() {
        // How to test that ?
    }
}
