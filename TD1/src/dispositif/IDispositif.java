package dispositif;

import zone.Zone;

public interface IDispositif {
    String getName();

    void setName(String name);

    Integer getId();

    void setId(Integer id);

    Zone getZone();

    void setZone(Zone z);

    Boolean getState();

    void setState(Boolean state);

    String[] getLogs();

    void setLogs(String[] s);

    void clearLog();

    String possibilities();

    @Override
    String toString();
}
