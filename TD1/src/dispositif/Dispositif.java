package dispositif;

import zone.Zone;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Dispositif class
 */
public class Dispositif implements Serializable, IDispositif {
    private String name;
    private static Integer count = 0;
    private Integer id;
    private Boolean state = false;
    private String[] logs = new String[]{};
    private Zone zone;

    public Dispositif(String name) {
        this.name = name;
        this.id = count;
        count++;
    }

    public Dispositif(String name, Zone z) {
        this.name = name;
        this.zone = z;
        this.id = count;
        count++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public void setZone(Zone z) {
        this.zone = z;
    }

    @Override
    public Boolean getState() {
        return state;
    }

    @Override
    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String[] getLogs() {
        return logs;
    }

    @Override
    public void setLogs(String[] s) {
        this.logs = s;
    }

    @Override
    public void clearLog() {
        this.logs = null;
    }

    /**
     * All the possibilities with this device
     *
     * @return string that list all possibilities
     */
    @Override
    public String possibilities() {
        return "Vous pouvez : \n" + "1- Activer ou désactiver votre dispositif\n" + "2- Obtenir les logs de votre dispositif\n" + "3- Connaître la zone du dispositif\n";
    }

    @Override
    public String toString() {
        return "Dispositif n°" + this.getId() + " nommé " + this.getName() + " dans " + this.getZone();
    }
}