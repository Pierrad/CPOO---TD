package dispositif;

import alerte.GestionAlerte;

public interface ICapteur {
    Integer getBattery();

    void setBattery(Integer battery);

    GestionAlerte getGestionAlerte();

    void setGestionAlerte(GestionAlerte gestionAlerte);

    void triggerAlerte();

    String possibilities();
}
