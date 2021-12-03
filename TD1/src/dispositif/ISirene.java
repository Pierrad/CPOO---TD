package dispositif;

public interface ISirene {
    Boolean getSwitchState();

    void setSwitchState(Boolean s);

    void stop();

    String possibilities();
}
