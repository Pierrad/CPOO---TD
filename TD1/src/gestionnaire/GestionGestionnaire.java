package gestionnaire;

import habitant.Habitant;

import java.util.Objects;

public class GestionGestionnaire implements IGestionGestionnaire {
    private Gestionnaire currentGestionnaire;

    public GestionGestionnaire() {
        currentGestionnaire = new Gestionnaire("default", "default");
    }

    public Gestionnaire getCurrentGestionnaire() {
        return currentGestionnaire;
    }

    public void defineNewGestionnaire(String name, String password) {
        currentGestionnaire = new Gestionnaire(name, password);
    }

    public Boolean isGestionnaire(String name) {
        return Objects.equals(currentGestionnaire.getName(), name);
    }

    public void disconnect() {
        currentGestionnaire = null;
    }

    public Boolean switchInterfaceHabitant(Habitant h) {
        // TODO ?
        return true;
    }
}
