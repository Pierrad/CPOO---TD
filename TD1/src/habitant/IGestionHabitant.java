package habitant;

import java.util.ArrayList;

public interface IGestionHabitant {
    void addHabitant(String name, String pw);

    void addHabitant(Habitant h);

    void removeHabitant(Habitant h);

    Boolean removeHabitant(String name);

    Habitant getHabitant(Habitant hab);

    Habitant getHabitant(String name);

    Habitant getHabitant(String name, String password);

    ArrayList<Habitant> getListHabitant();
}
