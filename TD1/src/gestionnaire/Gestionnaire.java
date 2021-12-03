package gestionnaire;

import habitant.Habitant;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Gestionnaire class
 */
public class Gestionnaire extends Habitant implements Serializable, IGestionnaire {
    private String name;
    private String password;

    public Gestionnaire(String name, String password) {
        super(name, password);
    }

}
