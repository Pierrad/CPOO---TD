package gestionnaire;

import habitant.Habitant;

import java.util.Objects;

public class GestionGestionnaire implements IGestionGestionnaire {
    private String currentGestionnaire;

    public GestionGestionnaire() {
        currentGestionnaire = "Default";
    }

    public String getCurrentGestionnaire() {
        return currentGestionnaire;
    }

    public void defineNewGestionnaire(String name) {
        currentGestionnaire = name;
    }

    public Boolean isGestionnaire(String name) {
        return Objects.equals(currentGestionnaire, name);
    }

    public void disconnect() {
        currentGestionnaire = null;
    }

    public Boolean switchInterfaceHabitant(Habitant h) {
        // TODO ?
        return true;
    }
}
