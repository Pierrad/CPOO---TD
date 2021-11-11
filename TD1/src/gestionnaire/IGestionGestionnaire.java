package gestionnaire;

import habitant.Habitant;

public interface IGestionGestionnaire {
    void defineNewGestionnaire(String n);

    Boolean isGestionnaire(String n);

    void disconnect();

    Boolean switchInterfaceHabitant(Habitant h);
}
