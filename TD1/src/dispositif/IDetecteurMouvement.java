package dispositif;

import alerte.GestionAlerte;

public interface IDetecteurMouvement {
    GestionAlerte getGestionAlerte();

    void setGestionAlerte(GestionAlerte gestionAlerte);

    void triggerAlerte();
}
