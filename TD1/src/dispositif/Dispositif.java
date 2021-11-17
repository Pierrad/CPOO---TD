package dispositif;

import td01.LogMessages;
import td01.Switchable;
import zone.Zone;

import java.util.Set;

/**
 *
 */
public class Dispositif implements Switchable {

    private String name;

    /**
     * Default constructor
     */
    public Dispositif(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void triggerDispositif()
    {

    }

    @Override
    public Boolean switchDispositif(boolean b) {
        return null;
    }
}