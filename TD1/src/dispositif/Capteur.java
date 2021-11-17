package dispositif;

public class Capteur extends Dispositif {

    private Integer battery;
    private GestionAlerte gestionAlerte;

    public Capteur(String name, Integer id, Integer battery, GestionAlerte gestionAlerte) {
        super(name, id);
        this.battery = battery;
        this.gestionAlerte = gestionAlerte;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public GestionAlerte getGestionAlerte() {
        return gestionAlerte;
    }

    public void setGestionAlerte(GestionAlerte gestionAlerte) {
        this.gestionAlerte = gestionAlerte;
    }

}
