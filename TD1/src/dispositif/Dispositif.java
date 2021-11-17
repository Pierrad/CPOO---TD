package dispositif;

/**
 *
 */
public class Dispositif implements ISwitchable {

    private String name;
    private Integer id;
    private Boolean state;
    private String[] logs;

    /**
     * Default constructor
     */
    public Dispositif(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void triggerDispositif() {
    }

    public String[] getLogs() {
        return logs;
    }

    public void setLogs(String[] s) {
        this.logs = s;
    }

    public void clearLog() {
        this.logs = null;
    }

    @Override
    public Boolean switchDispositif(boolean b) {
        return null;
    }
}