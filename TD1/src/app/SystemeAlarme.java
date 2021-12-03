package app;

import alerte.AlerteAction;
import alerte.GestionAlerte;
import alerte.Notification;
import console.UserConsole;
import dispositif.Dispositif;
import dispositif.GestionDispositif;
import gestionnaire.GestionGestionnaire;
import gestionnaire.Gestionnaire;
import habitant.GestionHabitant;
import habitant.Habitant;
import util.Memory;
import zone.GestionZone;
import zone.Zone;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * The main controler of the app. It is connected to all subControlers and the ui interface
 */
public class SystemeAlarme {
    private String typeOfUser;
    private GestionAlerte gestAlerte = new GestionAlerte();
    private GestionGestionnaire gestGestionnaire = new GestionGestionnaire();
    private GestionHabitant gestHabitant = new GestionHabitant();
    private GestionDispositif gestDispositif = new GestionDispositif();
    private GestionZone gestZone = new GestionZone();
    private final UserConsole ui = new UserConsole();
    // FOR TESTING
    private final Boolean isTesting = false;

    /**
     * At the construction of the object, we read saved data, if it exist then we redirect to the login if not we register a new user
     *
     * @throws ClassNotFoundException if no class find
     * @throws IOException            if input/output error
     */
    public SystemeAlarme() throws ClassNotFoundException, IOException {
        Boolean hasSaveInstance = initializeData();
        // We disable the authentification part if we are in testing because I cannot achieve to get user fake input
        if (!isTesting) {
            if (hasSaveInstance) {
                login();
                gestDispositif.reinitializeDispositifWithGestAlert(gestAlerte);
            } else {
                register();
                // Initialization of data
                gestZone.initializeZone();
                gestDispositif.initializeDispositif(gestZone, gestAlerte);
                gestAlerte.initializeActionAlerte();
            }
        }
    }

    // For the test
    public void setGestAlerte(GestionAlerte gestAlerte) {
        this.gestAlerte = gestAlerte;
    }

    // For the test
    public void setGestGestionnaire(GestionGestionnaire gestGestionnaire) {
        this.gestGestionnaire = gestGestionnaire;
    }

    // For the test
    public void setGestHabitant(GestionHabitant gestHabitant) {
        this.gestHabitant = gestHabitant;
    }

    // For the test
    public void setGestDispositif(GestionDispositif gestDispositif) {
        this.gestDispositif = gestDispositif;
    }

    // For the test
    public void setGestZone(GestionZone gestZone) {
        this.gestZone = gestZone;
    }

    // For the test
    public String getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * Recovery of all the data if a save exist
     *
     * @return true or false if a save exist or not
     * @throws IOException            if input/output error
     * @throws ClassNotFoundException if no class find
     */
    private Boolean initializeData() throws IOException, ClassNotFoundException {
        Object object = Memory.read("sauvegarde.txt");
        if (object != null) {
            if (object instanceof ArrayList) {
                for (Object o : ((ArrayList<?>) object)) {
                    if (o instanceof Gestionnaire) {
                        gestGestionnaire.defineNewGestionnaire(((Gestionnaire) o).getName(), ((Gestionnaire) o).getPassword());
                    }
                    if (o instanceof ArrayList && ((ArrayList<?>) o).size() > 0) {
                        if (((ArrayList<?>) o).get(0) instanceof Habitant) {
                            for (Habitant h : ((ArrayList<Habitant>) o)) {
                                gestHabitant.addHabitant(h);
                            }
                        }
                        if (((ArrayList<?>) o).get(0) instanceof Dispositif) {
                            for (Dispositif d : ((ArrayList<Dispositif>) o)) {
                                gestDispositif.addDispositif(d);
                            }
                        }
                        if (((ArrayList<?>) o).get(0) instanceof Zone) {
                            for (Zone z : ((ArrayList<Zone>) o)) {
                                gestZone.addZone(z);
                            }
                        }
                        if (((ArrayList<?>) o).get(0) instanceof Notification) {
                            for (Notification n : ((ArrayList<Notification>) o)) {
                                gestAlerte.addNotif(n);
                            }
                        }
                        if (((ArrayList<?>) o).get(0) instanceof AlerteAction) {
                            for (AlerteAction aa : ((ArrayList<AlerteAction>) o)) {
                                gestAlerte.addAlerteAction(aa);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Based on the type of the user we show a different user interface
     *
     * @throws Exception from startForGestionnaire or startForHabitant method
     */
    public void start() throws Exception {
        if (typeOfUser.equals("gestionnaire")) {
            startForGestionnaire();
        } else if (typeOfUser.equals("habitant")) {
            startForHabitant();
        }
    }

    /**
     * All the possibilities for the Gestionnaire
     *
     * @throws Exception because start() can throw exception
     */
    public void startForGestionnaire() throws Exception {
        String commande = ui.readCommandeGestionnaire();
        switch (commande) {
            case UserConsole.CREATE_HABITANT:
                createHabitant();
                start();
                break;

            case UserConsole.REMOVE_HABITANT:
                removeHabitant();
                start();
                break;

            case UserConsole.GET_LIST_HABITANT:
                getListHabitant();
                start();
                break;

            case UserConsole.GET_CURRENT_GESTIONNAIRE:
                getCurrentGestionnaire();
                start();
                break;

            case UserConsole.DEFINE_NEW_GESTIONNAIRE:
                defineNewGestionnaire();
                start();
                break;

            case UserConsole.GET_LIST_DISPOSITIF:
                getListDispositif();
                start();
                break;

            case UserConsole.GET_LIST_DISPOSITIF_BY_ZONE:
                getListDispositifByZone();
                start();
                break;

            case UserConsole.ADD_DISPOSITIF:
                addDispositif();
                start();
                break;

            case UserConsole.REMOVE_DISPOSITIF:
                removeDispositif();
                start();
                break;

            case UserConsole.CHANGE_ZONE_OF_DISPOSITIF:
                changeZoneOfDispositif();
                start();
                break;

            case UserConsole.SELECT_DISPOSITIF:
                selectDispositif();
                start();
                break;

            case UserConsole.ACTION_ON_ALL_DISPOSITIF_IN_ZONE:
                actionOnAllDispositifInZone();
                start();
                break;

            case UserConsole.GET_LIST_ZONE:
                getListZone();
                start();
                break;

            case UserConsole.ADD_ZONE:
                addZone();
                start();
                break;

            case UserConsole.ADD_ZONE_TO_ZONE:
                addZoneToZone();
                start();
                break;

            case UserConsole.REMOVE_ZONE:
                removeZone();
                start();
                break;

            case UserConsole.GET_LIST_NOTIFICATION:
                getListNotification();
                start();
                break;

            case UserConsole.REMOVE_ALL_NOTIFICATIONS:
                removeAllNotifications();
                start();
                break;

            case UserConsole.GENERATE_FALSE_ALERTE:
                generateFalseAlerte();
                start();
                break;

            case UserConsole.EDIT_ALERT_ACTION:
                editAlertAction();
                start();
                break;

            case UserConsole.CHANGE_TO_HABITANT_INTERFACE:
                switchInterfaceHabitant();
                start();
                break;

            case UserConsole.STOP:
                stop();
                break;

            default:
                ui.print("❓ La commande spécifiée n'existe pas\n");
                start();
        }
    }

    /**
     * All the possibilities for the Habitant
     *
     * @throws Exception because start can throw exception
     */
    public void startForHabitant() throws Exception {
        String commande = ui.readCommandeHabitant();
        switch (commande) {
            case UserConsole.GET_LIST_HABITANT:
                getListHabitant();
                start();
                break;

            case UserConsole.GET_CURRENT_GESTIONNAIRE:
                getCurrentGestionnaire();
                start();
                break;

            case UserConsole.GET_LIST_DISPOSITIF:
                getListDispositif();
                start();
                break;

            case UserConsole.GET_LIST_DISPOSITIF_BY_ZONE:
                getListDispositifByZone();
                start();
                break;

            case UserConsole.GET_LIST_ZONE:
                getListZone();
                start();
                break;

            case UserConsole.GET_LIST_NOTIFICATION:
                getListNotification();
                start();
                break;

            case UserConsole.STOP:
                stop();
                break;

            default:
                ui.print("La commande spécifiée n'existe pas\n");
                start();
        }
    }

    private String[] getLoginInformations() {
        return new String[]{ui.getNomUser(), ui.getPasswordUser()};
    }

    /**
     * Registration
     * Creation of an Gestionnaire and the same Habitant
     */
    private void register() {
        ui.print("👋 Bienvenue dans l'interface de votre nouveau système d'alarme !");
        ui.print("Vous allez pouvoir créer un gestionnaire, merci de saisir les informations suivantes : ");
        String[] lgi = getLoginInformations();
        gestGestionnaire.defineNewGestionnaire(lgi[0], lgi[1]);
        ui.print("Un habitant avec votre nom et votre mot de passe vient d'être créer automatiquement.");
        gestHabitant.addHabitant(lgi[0], lgi[1]);
        typeOfUser = "gestionnaire";
    }

    /**
     * Login
     * Check that the user exist
     */
    private void login() {
        ui.print("👋 Connectez-vous pour accéder à votre compte");
        String[] lgi = getLoginInformations();
        Gestionnaire gg = gestGestionnaire.getCurrentGestionnaire();
        if (gg.getName().equals(lgi[0]) && gg.getPassword().equals(lgi[1])) {
            ui.print("Vous êtes connecté en tant que gestionnaire.");
            typeOfUser = "gestionnaire";
        } else if (gestHabitant.getHabitant(lgi[0], lgi[1]) != null) {
            ui.print("Vous êtes connecté en tant qu'habitant.");
            typeOfUser = "habitant";
        } else {
            ui.print("❗️ Vos informations ne correspondent à aucun de nos enregistrements.");
            ui.print("👋 Au revoir.");
            System.exit(0);
        }
    }

    private void createHabitant() {
        ui.print("Création d'un nouvel habitant");
        String name = ui.getNomUser();
        String password = ui.getPasswordUser();
        gestHabitant.addHabitant(name, password);
        ui.print("Création réussi");
    }

    private void removeHabitant() {
        ui.print("Quel habitant voulez-vous supprimer ?");
        String name = ui.write();
        Boolean state = gestHabitant.removeHabitant(name);
        if (state) {
            ui.print("Suppression effectué.");
        } else {
            ui.print("Erreur lors de la suppression.");
        }
    }

    public void getListHabitant() {
        ui.print("Voici la liste des habitants");
        ArrayList<Habitant> list = gestHabitant.getListHabitant();
        ui.print(list.toString());
    }

    public void getCurrentGestionnaire() {
        ui.print("Voici le gestionnaire actuel");
        ui.print(gestGestionnaire.getCurrentGestionnaire().toString());
    }

    private void defineNewGestionnaire() throws InterruptedException {
        ui.print("Veuillez entrer le nom d'un autre habitant parmi la liste suivante : ");
        getListHabitant();
        ui.print("Entrez un nom : ");
        String name = ui.write();
        Habitant h = gestHabitant.getHabitant(name);
        if (h != null) {
            ui.print("Transfert réussi.");
            ui.print("Vous allez être basculé vers l'interface Habitant.");
            ui.loading();
            gestGestionnaire.defineNewGestionnaire(h.getName(), h.getPassword());
            typeOfUser = "habitant";
        } else {
            ui.print("Aucun habitant correspondant à ce nom.");
        }
    }

    public void getListDispositif() {
        ui.print("Voici la liste des dispositifs");
        ArrayList<Dispositif> list = gestDispositif.getListDispositif();
        ui.print(list.toString());
    }

    private void getListDispositifByZone() {
        getListZone();
        ui.print("Pour quelle zone voulez-vous la liste des dispositifs ?");
        String zoneName = ui.write();
        Zone z = gestZone.getZoneFromName(zoneName);
        if (z != null) {
            ArrayList<Dispositif> list = gestDispositif.getListDispositif(z);
            ui.print(list.toString());
        } else {
            ui.print("Cette zone n'existe pas.");
        }
    }

    private void addDispositif() {
        getListDispositif();
        ui.print("Entrer le nom du nouveau dispositif : ");
        String name = ui.write();
        ui.print(gestDispositif.getListOfTypeDispositif().toString());
        ui.print("Quel type de dispositif voulez-vous ajouter ?");
        String type = ui.write();
        getListZone();
        ui.print("Dans quelle zone voulez-vous le mettre ?");
        String zone = ui.write();
        Zone z = gestZone.getZoneFromName(zone);
        if (z != null) {
            gestDispositif.addDispositif(name, z, type, gestAlerte);
        } else {
            ui.print("Erreur.");
        }
    }

    private void removeDispositif() {
        ui.print("Quel dispositif voulez-vous supprimer ?");
        String name = ui.write();
        Boolean state = gestDispositif.removeDispositifByName(name);
        if (state) {
            ui.print("Suppression effectué.");
        } else {
            ui.print("Erreur lors de la suppression.");
        }
    }

    private void changeZoneOfDispositif() {
        getListDispositif();
        ui.print("Quel dispositif voulez-vous déplacer de zone ?");
        String dispositifName = ui.write();
        getListZone();
        ui.print("Vers quelle zone ?");
        String zoneName = ui.write();
        Boolean state = gestDispositif.changeZone(dispositifName, zoneName, gestZone);
        if (state) {
            ui.print("Déplacement effectué.");
        } else {
            ui.print("Erreur lors du déplacement.");
        }
    }

    /**
     * Select a dispositif and perform action on this dispositif
     */
    private void selectDispositif() {
        getListDispositif();
        ui.print("Quel dispositif voulez-vous sélectionner ?");
        String dName = ui.write();
        Dispositif d = gestDispositif.getDispositifFromName(dName);
        if (d != null) {
            do {
                String commande = ui.readCommandeDispositif(d.possibilities());
                String res = gestDispositif.dispatchCommande(commande, d);
                ui.print(res);
                ui.print("Voulez-vous continuer avec ce dispositif ? (Oui / Non)");
            } while (ui.write().equals("Oui"));
        }
    }

    /**
     * Perform activation or desactivation on all device of a specific zone
     */
    private void actionOnAllDispositifInZone() {
        getListZone();
        ui.print("De quelle zone voulez-vous activer ou désactiver tout les dispositifs ?");
        String zone = ui.write();
        Zone z = gestZone.getZoneFromName(zone);
        if (z != null) {
            ui.print("Voulez-vous activer ou désactiver les dispositifs de cette zone ? (A / D)");
            if (ui.write().equals("A")) {
                gestDispositif.activateAllDispositifInZone(z);
            } else if (ui.write().equals("D")) {
                gestDispositif.desactivateAllDispositifInZone(z);
            } else {
                ui.print("Erreur");
            }
        } else {
            ui.print("Pas de zone de ce nom");
        }
    }

    public void getListZone() {
        ui.print("Voici la liste des zones");
        ArrayList<Zone> list = gestZone.getListZone();
        ui.print(list.toString());
    }

    private void addZone() {
        ui.print("Entrez le nom de la nouvelle zone : ");
        String zoneName = ui.write();
        ui.print("Entrez une description de la zone : ");
        String zoneDescription = ui.write();
        gestZone.addZone(zoneName, zoneDescription);
    }

    /**
     * Add zone to another zone (Nested zone)
     */
    private void addZoneToZone() {
        ui.print("Voici la liste des zones : ");
        getListZone();
        ui.print("Quelle est la zone parente ? ");
        String parentZone = ui.write();
        ui.print("Quelle est la zone enfant ? (Ou entrez CREATE pour créer une nouvelle zone)");
        String childZone = ui.write();
        if (childZone.equals("CREATE")) {
            addZone();
            ui.print("Merci de retaper le nom de la zone enfant.");
            childZone = ui.write();
        }
        Zone pZone = gestZone.getZoneFromName(parentZone);
        Zone cZone = gestZone.getZoneFromName(childZone);
        if (pZone != null && cZone != null) {
            gestZone.addZoneToZone(pZone, cZone);
        }
    }

    private void removeZone() {
        ui.print("Quelle zone voulez-vous supprimer ?");
        String name = ui.write();
        Boolean state = gestZone.removeZone(name);
        if (state) {
            ui.print("Suppression effectué.");
        } else {
            ui.print("Erreur lors de la suppression.");
        }
    }

    public void getListNotification() {
        ui.print("Voici la liste des notifications : ");
        ArrayList<Notification> list = gestAlerte.getNotifs();
        ui.print(list.toString());
    }

    private void removeAllNotifications() throws InterruptedException {
        ui.print("Suppression de toutes les notifications en cours...");
        gestAlerte.removeAllNotifs();
    }

    /**
     * Generate a false alert to test how the device react
     */
    private void generateFalseAlerte() {
        ui.print("📣 Génération d'une alerte en cours...");
        gestDispositif.generateFalseAlert(gestAlerte);
    }

    /**
     * Edit action perform when an alert is triggered
     */
    private void editAlertAction() {
        ui.print("Voici toutes les actions actuellement possible : ");
        ui.showAllAlerteAction(gestAlerte.getAlerteActions().toString());
        ui.print("Voici les IDs des actions actives");
        ui.print(gestAlerte.getAlerteActionsActivated().toString());
        ui.print("Choisissez les actions que vous voulez activer (Entrez l'id des actions séparé par des virgules)");
        String idActions = ui.write();
        gestAlerte.editAlertAction(idActions);
    }

    /**
     * Allow a gestionnaire to switch to his user interface
     *
     * @throws InterruptedException if a waiting/loading thread is interrupted
     */
    public void switchInterfaceHabitant() throws InterruptedException {
        ui.print("Vous allez être basculé vers l'interface Habitant.");
        ui.loading();
        typeOfUser = "habitant";
    }

    /**
     * Stop the app
     * Save all the informations
     */
    private void stop() {
        try {
            ui.print("💾 Enregistrement des données...");
            ui.loading();
            ArrayList allData = new ArrayList();
            allData.add(gestHabitant.getListHabitant()); // Add all habitants
            allData.add(gestGestionnaire.getCurrentGestionnaire()); // Add current gestionnaire
            allData.add(gestDispositif.getListDispositif()); // Add all dispositifs
            allData.add(gestZone.getListZone()); // Add all zones
            allData.add(gestAlerte.getNotifs()); // Add all notifications
            allData.add(gestAlerte.getAlerteActions()); // Add all alerteActions
            Memory.save(allData, "sauvegarde.txt");
        } catch (Exception e) {
            ui.print("⚠️ Erreur");
            throw new RuntimeException();
        }
        ui.print("👋 Au revoir.");
        System.exit(0);
    }
}