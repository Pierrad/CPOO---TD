package habitant;

import java.util.ArrayList;

public class GestionHabitant {
    private ArrayList<Habitant> listHabitant = new ArrayList<Habitant>();

    public void addHabitant (String name, String pw) {
        listHabitant.add(new Habitant(name, pw));
    }
    public void removeHabitant(Habitant h) {
        listHabitant.remove(h);
    }
    public ArrayList<Habitant> getListHabitant() {
        return listHabitant;
    }
}
