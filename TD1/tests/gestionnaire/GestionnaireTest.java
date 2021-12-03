package gestionnaire;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class GestionnaireTest {
    private Gestionnaire g;

    @BeforeEach
    void setUp() {
        g = new Gestionnaire("Gestionnaire", "Azerty");
    }

    @AfterEach
    void destroy() {
        g = null;
    }
}
