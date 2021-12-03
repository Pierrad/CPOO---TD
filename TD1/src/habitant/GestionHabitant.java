package habitant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Controller for the habitant class
 */
public class GestionHabitant implements Serializable, IGestionHabitant {
    private ArrayList<Habitant> listHabitant = new ArrayList<Habitant>();

    @Override
    public void addHabitant(String name, String pw) {
        Habitant newHabitant = new Habitant(name, pw);
        if (!listHabitant.contains(newHabitant)) {
            listHabitant.add(new Habitant(name, pw));
        }
    }

    @Override
    public void addHabitant(Habitant h) {
        if (!listHabitant.contains(h)) {
            listHabitant.add(new Habitant(h.getName(), h.getPassword()));
        }
    }

    @Override
    public void removeHabitant(Habitant h) {
        listHabitant.remove(h);
    }

    @Override
    public Boolean removeHabitant(String name) {
        try {
            listHabitant.removeIf(h -> h.getName().equals(name));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Habitant getHabitant(Habitant hab) {
        for (Habitant h : listHabitant) {
            if (h.getName() == hab.getName() && h.getPassword() == hab.getPassword()) {
                return h;
            }
        }
        return null;
    }

    @Override
    public Habitant getHabitant(String name) {
        for (Habitant h : listHabitant) {
            if (Objects.equals(h.getName(), name)) {
                return h;
            }
        }
        return null;
    }

    @Override
    public Habitant getHabitant(String name, String password) {
        for (Habitant h : listHabitant) {
            if (h.getName() == name && h.getPassword() == password) {
                return h;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Habitant> getListHabitant() {
        return listHabitant;
    }
}
