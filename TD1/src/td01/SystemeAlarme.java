package td01;

import dispositif.GestionDispositif;
import habitant.Habitant;

import java.util.Set;

/**
 *
 */
public class SystemeAlarme {

    private String adress;

    private Administrateur administrateur;

    private Set<PhoneNumber> phoneNumbers;

    private Gestionnaire gestionnaire;

    private Set<Habitant> habitants;

    private GestionDispositif gestDispositif;

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

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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

}