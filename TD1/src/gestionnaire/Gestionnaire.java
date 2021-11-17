package gestionnaire;

import habitant.Habitant;

/**
 *
 */
public class Gestionnaire extends Habitant {
    private String name;
    private String password;

    public Gestionnaire(String name, String password) {
        super(name, password);
    }

    // public void addZone(String nom, String description)
    //{
    //   d�j� existante pour GestionZone, n�cessit� de le faire?
    //}

    public void removeHabitant(Habitant a) {
        a.setName(null);
        a.setPassword(null);
    }

    public Habitant addHabitant(String name, String password) {
        return new Habitant(name, password);
    }
}