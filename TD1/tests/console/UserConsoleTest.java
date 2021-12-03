package console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UserConsoleTest {
    private UserConsole ui;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        ui = new UserConsole();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void destroy() {
        ui = null;
        System.setOut(originalOut);
    }

    @Test
    void testPrint() {
        ui.print("hello");
        Assertions.assertEquals("\u001B[31mhello\u001B[0m\n", outContent.toString());
    }

    // Not working for testing input
    @Test
    void testWrite() {
        // String input = "test";
        // InputStream in = new ByteArrayInputStream(input.getBytes());
        // System.setIn(in);
        // Assertions.assertEquals("test", ui.write());
    }
}
