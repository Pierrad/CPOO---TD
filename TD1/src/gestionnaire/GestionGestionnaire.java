package gestionnaire;

import java.util.Objects;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Controller for gestionnaire class
 */
public class GestionGestionnaire implements IGestionGestionnaire {
    private Gestionnaire currentGestionnaire;

    public GestionGestionnaire() {
        currentGestionnaire = new Gestionnaire("Client", "1234");
    }

    @Override
    public Gestionnaire getCurrentGestionnaire() {
        return currentGestionnaire;
    }

    @Override
    public void defineNewGestionnaire(String name, String password) {
        currentGestionnaire = new Gestionnaire(name, password);
    }

    @Override
    public Boolean isGestionnaire(String name) {
        return Objects.equals(currentGestionnaire.getName(), name);
    }

    @Override
    public void disconnect() {
        currentGestionnaire = null;
    }
}
