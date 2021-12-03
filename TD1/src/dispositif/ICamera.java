package dispositif;

import alerte.GestionAlerte;

public interface ICamera {
    GestionAlerte getGestionAlerte();

    void setGestionAlerte(GestionAlerte gestionAlerte);

    Integer getBattery();

    void setBattery(Integer battery);

    Boolean getSwitchState();

    void setSwitchState(Boolean s);

    void visionnerFlux();

    void triggerAlerte();

    String possibilities();
}
