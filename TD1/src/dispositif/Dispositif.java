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

    private Integer id;

    private Boolean state;

    private Set<LogMessages> logs;

    private Zone zone;

    /**
     * Default constructor
     */
    public Dispositif(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.state = false;
    }

    /**
     * @return
     */
    public Boolean clearLog() {
        for (LogMessages log : logs) {
            log = null;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Set<LogMessages> getLogs() {
        return logs;
    }

    public void setLogs(Set<LogMessages> logs) {
        this.logs = logs;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public Boolean switchDispositif(boolean b) {
        return null;
    }
}