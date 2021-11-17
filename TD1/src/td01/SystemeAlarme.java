package td01;

import console.UserConsole;
import dispositif.GestionDispositif;
import gestionnaire.Gestionnaire;
import habitant.Habitant;

import java.util.Set;

/**
 *
 */
public class SystemeAlarme {
    private String adress;
    private Administrateur administrateur;
    private Gestionnaire gestionnaire;
    private Set<Habitant> habitants;
    private GestionDispositif gestDispositif;
    private Gestionnaire registre = new Gestionnaire("default", "default");
    private UserConsole ui = new UserConsole();

    /**
     * Default constructor
     */
    public SystemeAlarme() {
    }

    public boolean seConnecter(Habitant habitant) {
        return habitant.getName() == "Arthur" && habitant.getPassword() == "toto";
    }

    /**
     *
     */
    public void test() {
        // TODO implement here
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public Set<Habitant> getHabitants() {
        return habitants;
    }

    public void setHabitants(Set<Habitant> habitants) {
        this.habitants = habitants;
    }

    public GestionDispositif getGestDispositif() {
        return gestDispositif;
    }

    public void setGestDispositif(GestionDispositif gestDispositif) {
        this.gestDispositif = gestDispositif;
    }

    public void start() throws Exception {
        String commande = ui.lireCommande();
        switch (commande.charAt(0)) {
            case UserConsole.COM_CREER_FORUM:
                start();
                break;
            case UserConsole.COM_CREER_CANAL:
                start();
                break;
            case UserConsole.COM_CREER_CANAL_DE_BREVES:
                start();
                break;
            case UserConsole.COM_POSTER_MESSAGES:
                start();
                break;
            case UserConsole.COM_LIRE_MESSAGES:
                start();
                break;
            case UserConsole.COM_CHANGER_MEMBRE:
                start();
                break;
            case UserConsole.COM_INSCRIRE:
                start();
                break;
            case UserConsole.COM_STOP:
                ui.afficher("Au revoir ");
                break;

            default:
                ui.afficher("La commande spécifiée n'existe pas\n");
                start();
        }
    }

}