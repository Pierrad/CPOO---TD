package td01;

import dispositif.Dispositif;

import java.util.Set;

/**
 *
 */
public class Zone {

    /**
     * Default constructor
     */
    public Zone() {
    }


    /**
     *
     */
    private String name;

    /**
     *
     */
    private Set<Dispositif> dispositifs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dispositif> getDispositifs() {
        return dispositifs;
    }

    public void setDispositifs(Set<Dispositif> dispositifs) {
        this.dispositifs = dispositifs;
    }


}