package dispositif;

import alerte.AlerteAction;
import alerte.GestionAlerte;
import zone.GestionZone;
import zone.Zone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static dispositif.TypeOfDispositif.*;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Controller for dispositif class
 */
public class GestionDispositif implements Serializable, IGestionDispositif {
    private ArrayList<Dispositif> listDispositif = new ArrayList<Dispositif>();

    public GestionDispositif() {
    }

    /**
     * We need to initialize a list of devices at the first start of the app because the system is
     * delivered with a set of devices
     *
     * @param gz GestionZone (connect devices to a zone)
     * @param ga GestionAlerte (connect devices with an alerte controller to trigger alert)
     */
    @Override
    public void initializeDispositif(GestionZone gz, GestionAlerte ga) {
        Zone house = gz.getZoneFromName("HOUSE");
        Sirene s0 = new Sirene("SIREN_00", house);
        Sirene s1 = new Sirene("SIREN_01", house);
        Camera c = new Camera("CAM_00", house, ga);
        DetecteurMouvement d0 = new DetecteurMouvement("DET_00", house, ga);
        DetecteurMouvement d1 = new DetecteurMouvement("DET_01", house, ga);
        DetecteurMouvement d2 = new DetecteurMouvement("DET_02", house, ga);
        addDispositif(s0);
        addDispositif(s1);
        addDispositif(c);
        addDispositif(d0);
        addDispositif(d1);
        addDispositif(d2);
    }

    @Override
    public void addDispositif(Dispositif dispositif) {
        if (!listDispositif.contains(dispositif)) {
            listDispositif.add(dispositif);
        }
    }


    @Override
    public void addDispositif(String name) {
        Dispositif d = new Dispositif(name);
        if (!listDispositif.contains(d)) {
            listDispositif.add(d);
        }
    }

    @Override
    public void addDispositif(String name, Zone z) {
        Dispositif d = new Dispositif(name, z);
        if (!listDispositif.contains(d)) {
            listDispositif.add(d);
        }
    }

    @Override
    public void addDispositif(String name, Zone z, String type, GestionAlerte ga) {
        Dispositif d = null;
        if (Objects.equals(TypeOfDispositif.CAMERA.toString(), type.toUpperCase())) {
            d = new Camera(name, z, ga);
        } else if (Objects.equals(ALARME.toString(), type.toUpperCase())) {
            d = new Alarme(name, z);
        } else if (Objects.equals(CAPTEUR.toString(), type.toUpperCase())) {
            d = new Capteur(name, z, ga);
        } else if (Objects.equals(DETECTEUR_MOUVEMENT.toString(), type.toUpperCase())) {
            d = new DetecteurMouvement(name, z, ga);
        } else if (Objects.equals(SIRENE.toString(), type.toUpperCase())) {
            d = new Sirene(name, z);
        }

        if (d != null && !listDispositif.contains(d)) {
            listDispositif.add(d);
        }
    }

    @Override
    public Dispositif getDispositifFromName(String name) {
        for (Dispositif d : listDispositif) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Change the zone of a device
     *
     * @param dispositifName The device on which we want to change the zone
     * @param zoneName       The new zone name (it must already exist)
     * @param gz             GestionZone to find the zone in the list of zone
     * @return true if we have change the zone, false if not
     */
    @Override
    public Boolean changeZone(String dispositifName, String zoneName, GestionZone gz) {
        Dispositif d = getDispositifFromName(dispositifName);
        Zone z = gz.getZoneFromName(zoneName);
        if (d != null && z != null) {
            d.setZone(z);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean removeDispositifByName(String name) {
        try {
            listDispositif.removeIf(h -> h.getName().equals(name));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public ArrayList<Dispositif> getListDispositif() {
        return listDispositif;
    }

    /**
     * Get list of device in a zone
     *
     * @param z the zone to get the device
     * @return a list of device in a specific zone
     */
    @Override
    public ArrayList<Dispositif> getListDispositif(Zone z) {
        ArrayList<Dispositif> listOfDispositifInZone = new ArrayList<>();
        for (Dispositif d : listDispositif) {
            if (d.getZone().equals(z)) {
                listOfDispositifInZone.add(d);
            }
        }
        return listOfDispositifInZone;
    }

    /**
     * List of all types devices from Enum TypeOfDispositif
     *
     * @return a list of types of devices
     */
    @Override
    public ArrayList<String> getListOfTypeDispositif() {
        ArrayList<String> listOfType = new ArrayList<>();
        for (TypeOfDispositif e : TypeOfDispositif.values()) {
            listOfType.add(e.toString());
        }
        return listOfType;
    }

    @Override
    public void activateAllDispositifInZone(Zone z) {
        for (Dispositif d : listDispositif) {
            if (d.getZone().equals(z)) {
                d.setState(true);
            }
        }
    }

    @Override
    public void desactivateAllDispositifInZone(Zone z) {
        for (Dispositif d : listDispositif) {
            if (d.getZone().equals(z)) {
                d.setState(false);
            }
        }
    }

    /**
     * Dispatch a command to a specific device
     *
     * @param commande the id of the command to dispatch
     * @param d        the device
     * @return the result of the command
     */
    @Override
    public String dispatchCommande(String commande, Dispositif d) {
        String res = "";

        switch (commande) {
            case "1":
                d.setState(!d.getState());
                res = d.getState() ? "Votre dispositif est maintenant activée." : "Votre dispositif est maintenant désactivée.";
                break;
            case "2":
                res = Arrays.toString(d.getLogs());
                break;
            case "3":
                res = d.getZone().toString();
                break;
            case "4":
                if (d instanceof Alarme) {
                    ((Alarme) d).setSwitchState(!((Alarme) d).getSwitchState());
                    res = "Votre Alarme est " + (d.getState() ? "active" : "désactivée") + " et " + (((Alarme) d).getSwitchState() ? "allumée" : "éteinte");
                    break;
                } else if (d instanceof Camera) {
                    res = ((Camera) d).getBattery().toString() + '%';
                    break;
                } else if (d instanceof Capteur) {
                    res = ((Capteur) d).getBattery().toString() + '%';
                    break;
                } else if (d instanceof Sirene) {
                    ((Sirene) d).setSwitchState(!((Sirene) d).getSwitchState());
                    res = "Votre Sirene est " + (d.getState() ? "active" : "désactivée") + " et " + (((Sirene) d).getSwitchState() ? "allumée" : "éteinte");
                    break;
                }
            case "5":
                if (d instanceof Camera) {
                    ((Camera) d).setSwitchState(!((Camera) d).getSwitchState());
                    res = "Votre Camera est " + (d.getState() ? "active" : "désactivée") + " et " + (((Camera) d).getSwitchState() ? "allumée" : "éteinte");
                    break;
                }
        }
        return res;
    }

    /**
     * Generating a false alert (code can be better I think, need refactoring maybe)
     *
     * @param ga GestionAlerte
     */
    @Override
    public void generateFalseAlert(GestionAlerte ga) {
        ArrayList<AlerteAction> aa = ga.getAlerteActionsActivated();
        for (Dispositif d : listDispositif) {
            if (ga.activatedListContainsId(1)) {
                if (d instanceof Camera) {
                    d.setState(true);
                    ((Camera) d).setSwitchState(true);
                    ((Camera) d).triggerAlerte();
                }
            }
            if (ga.activatedListContainsId(0)) {
                if (d instanceof Alarme) {
                    d.setState(true);
                    ((Alarme) d).setSwitchState(true);
                } else if (d instanceof Sirene) {
                    d.setState(true);
                    ((Sirene) d).setSwitchState(true);
                }
            }
            if (d instanceof Capteur) {
                ((Capteur) d).triggerAlerte();
            }
            if (d instanceof DetecteurMouvement) {
                ((DetecteurMouvement) d).triggerAlerte();
            }
        }
    }

    //

    /**
     * When we recover the system state from a save, the different devices are referring to an older GestionAlerte to
     * send alert, so when we trigger a new alert, we cannot see it
     * So we need to reinitialize the GestionAlerte of each devices that can throw alert.
     *
     * @param ga GestionAlerte
     */
    @Override
    public void reinitializeDispositifWithGestAlert(GestionAlerte ga) {
        for (Dispositif d : this.listDispositif) {
            if (d instanceof Camera) {
                ((Camera) d).setGestionAlerte(ga);
            } else if (d instanceof Capteur) {
                ((Capteur) d).setGestionAlerte(ga);
            } else if (d instanceof DetecteurMouvement) {
                ((DetecteurMouvement) d).setGestionAlerte(ga);
            }
        }
    }

}
