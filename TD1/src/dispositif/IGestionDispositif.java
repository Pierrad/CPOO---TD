package dispositif;

import alerte.GestionAlerte;
import zone.GestionZone;
import zone.Zone;

import java.util.ArrayList;

public interface IGestionDispositif {
    void initializeDispositif(GestionZone gz, GestionAlerte ga);

    void addDispositif(Dispositif dispositif);

    void addDispositif(String name);

    void addDispositif(String name, Zone z);

    void addDispositif(String name, Zone z, String type, GestionAlerte ga);

    Dispositif getDispositifFromName(String name);

    Boolean changeZone(String dispositifName, String zoneName, GestionZone gz);

    Boolean removeDispositifByName(String name);

    ArrayList<Dispositif> getListDispositif();

    ArrayList<Dispositif> getListDispositif(Zone z);

    ArrayList<String> getListOfTypeDispositif();

    void activateAllDispositifInZone(Zone z);

    void desactivateAllDispositifInZone(Zone z);

    String dispatchCommande(String commande, Dispositif d);

    // Not very good
    void generateFalseAlert(GestionAlerte ga);

    // When we recover the system state from a save, the different devices are referring to an older GestionAlerte to
    // send alert, so when we trigger a new alert, we cannot see it
    // So we need to reinitialize the GestionAlerte of each devices that can throw alert.
    void reinitializeDispositifWithGestAlert(GestionAlerte ga);
}
