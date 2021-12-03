package console;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * The ui interface of the app that contains all the commands to show
 */
public class UserConsole {
    Scanner sc = new Scanner(System.in);

    // Habitant
    public static final String CREATE_HABITANT = "ch";
    public static final String REMOVE_HABITANT = "rh";
    public static final String GET_LIST_HABITANT = "glh";
    // Gestionnaire
    public static final String GET_CURRENT_GESTIONNAIRE = "gcg";
    public static final String DEFINE_NEW_GESTIONNAIRE = "dng";
    // Dispositif
    public static final String GET_LIST_DISPOSITIF = "gld";
    public static final String GET_LIST_DISPOSITIF_BY_ZONE = "gldbz";
    public static final String ADD_DISPOSITIF = "ad";
    public static final String REMOVE_DISPOSITIF = "rd";
    public static final String CHANGE_ZONE_OF_DISPOSITIF = "czod";
    public static final String SELECT_DISPOSITIF = "sd";
    public static final String ACTION_ON_ALL_DISPOSITIF_IN_ZONE = "aoadiz";
    // Zone
    public static final String GET_LIST_ZONE = "glz";
    public static final String ADD_ZONE = "az";
    public static final String ADD_ZONE_TO_ZONE = "aztz";
    public static final String REMOVE_ZONE = "rz";
    // Alert
    public static final String GET_LIST_NOTIFICATION = "gln";
    public static final String REMOVE_ALL_NOTIFICATIONS = "ran";
    public static final String GENERATE_FALSE_ALERTE = "gfa";
    public static final String EDIT_ALERT_ACTION = "eaa";
    // Other
    public static final String CHANGE_TO_HABITANT_INTERFACE = "cthi";
    public static final String STOP = "s";
    // Color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private void sop(String s) {
        System.out.println(s);
    }

    public String readCommandeGestionnaire() {
        sop("---------- COMMANDES ----------");
        sop("HABITANT-------------------");
        sop("Créer un habitant : " + CREATE_HABITANT);
        sop("Supprimer un habitant : " + REMOVE_HABITANT);
        sop("Obtenir la liste des habitants : " + GET_LIST_HABITANT);
        sop("GESTIONNAIRE-------------------");
        sop("Obtenir le gestionnaire courant : " + GET_CURRENT_GESTIONNAIRE);
        sop("Définir un nouveau gestionnaire : " + DEFINE_NEW_GESTIONNAIRE);
        sop("DISPOSITIF---------------------");
        sop("Obtenir la liste des dispositifs : " + GET_LIST_DISPOSITIF);
        sop("Obtenir la liste des dispositifs pour une zone spécifique : " + GET_LIST_DISPOSITIF_BY_ZONE);
        sop("Ajouter un dispositif : " + ADD_DISPOSITIF);
        sop("Supprimer un dispositif : " + REMOVE_DISPOSITIF);
        sop("Changer la zone d'un dispositif : " + CHANGE_ZONE_OF_DISPOSITIF);
        sop("Sélectionner un dispositif afin de faire une action : " + SELECT_DISPOSITIF);
        sop("Activer ou désactiver tous les dispositifs d'une zone : " + ACTION_ON_ALL_DISPOSITIF_IN_ZONE);
        sop("ZONE---------------------------");
        sop("Obtenir la liste des zones : " + GET_LIST_ZONE);
        sop("Ajouter une zone : " + ADD_ZONE);
        sop("Ajouter une zone dans une autre zone : " + ADD_ZONE_TO_ZONE);
        sop("Supprimer une zone : " + REMOVE_ZONE);
        sop("ALERTE---------------------------");
        sop("Obtenir la liste des notifications du système d'alerte : " + GET_LIST_NOTIFICATION);
        sop("Supprimer toutes les notifications du système d'alerte : " + REMOVE_ALL_NOTIFICATIONS);
        sop("Générer une fausse alerte : " + GENERATE_FALSE_ALERTE);
        sop("Gérer les actions lors d'une alerte : " + EDIT_ALERT_ACTION);
        sop("AUTRE-------------------------------");
        sop("Basculer sur l'interface habitant : " + CHANGE_TO_HABITANT_INTERFACE);
        sop("Stopper l'application : " + STOP);
        sop("Que voulez-vous faire ?");
        String str = sc.nextLine().toLowerCase();
        sop("Vous avez saisi la commande: " + str);
        return str;
    }

    public String readCommandeHabitant() {
        sop("---------- COMMANDES ----------");
        sop("HABITANT-------------------");
        sop("Obtenir la liste des habitants : " + GET_LIST_HABITANT);
        sop("GESTIONNAIRE-------------------");
        sop("Obtenir le gestionnaire courant : " + GET_CURRENT_GESTIONNAIRE);
        sop("DISPOSITIF---------------------");
        sop("Obtenir la liste des dispositifs : " + GET_LIST_DISPOSITIF);
        sop("Sélectionner un dispositif afin de faire une action : " + SELECT_DISPOSITIF);
        sop("ZONE---------------------------");
        sop("Obtenir la liste des zones : " + GET_LIST_ZONE);
        sop("ALERTE---------------------------");
        sop("Obtenir la liste des notifications du système d'alerte : " + GET_LIST_NOTIFICATION);
        sop("AUTRE-------------------------------");
        sop("Stopper l'application : " + STOP);
        sop("Que voulez-vous faire ?");
        String str = sc.nextLine().toLowerCase();
        sop("Vous avez saisi la commande: " + str);
        return str;
    }

    public String readCommandeDispositif(String possibilities) {
        sop("<><><><><>COMMANDES DISPOSITIF<><><><><>");
        print(possibilities);
        sop("Veuillez choisir un chiffre correspondant à une action");
        String str = sc.nextLine().toLowerCase();
        sop("Vous avez saisi le chiffre: " + str);
        return str;
    }

    public void showAllAlerteAction(String s) {
        sop("<><><><><>ALERTE ACTION<><><><><>");
        sop(s);
    }

    public void print(String str) {
        sop(ANSI_RED + str + ANSI_RESET);
    }

    public String getNomUser() {
        sop("Quel est votre nom ?");
        return sc.nextLine();
    }

    public String getPasswordUser() {
        sop("Quel est le mot de passe ?");
        return sc.nextLine();
    }

    public String write() {
        return sc.nextLine();
    }

    /**
     * Fake loading
     *
     * @throws InterruptedException if the waiting/loading thread is interrupted
     */
    public void loading() throws InterruptedException {
        sop(".");
        TimeUnit.SECONDS.sleep(1);
        sop("..");
        TimeUnit.SECONDS.sleep(1);
        sop("...");
    }

}
