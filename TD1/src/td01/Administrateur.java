package td01;

import java.util.Set;

/**
 *
 */
public class Administrateur {

    /**
     * Default constructor
     */
    public Administrateur() {
    }

    /**
     *
     */
    private Set<SystemeAlarme> systemesAlarme;

    /**
     *
     */
    public void installUpdate() {
        System.out.println("Install update...");
    }

    public Set<SystemeAlarme> getSystemesAlarme() {
        return systemesAlarme;
    }

    public void setSystemesAlarme(Set<SystemeAlarme> systemesAlarme) {
        this.systemesAlarme = systemesAlarme;
    }

}