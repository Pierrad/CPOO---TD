package habitant;

public class GestionGestionnaire extends Habitant{

    private boolean isGestionnaire = false;

    public GestionGestionnaire(String name, String password) {
        super(name, password);
        this.isGestionnaire = true;
    }
    
    public boolean getIsGestionnaire() {
        return this.isGestionnaire;
    }

}
