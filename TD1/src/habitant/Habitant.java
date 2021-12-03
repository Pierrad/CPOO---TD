package habitant;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Habitant class
 */
public class Habitant implements Serializable, IHabitant {

    private String name;

    private String password;

    public Habitant(String name, String password) {
        this.name = name;
        this.password = password;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login(String name, String password) {
        return Objects.equals(this.password, password) && Objects.equals(this.name, name);
    }

    @Override
    public String toString() {
        return "Nom : " + this.getName() + " / Mot de passe : " + this.getPassword();
    }

}