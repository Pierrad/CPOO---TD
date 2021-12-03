package dispositif;

public interface IAlarme {
    Boolean getSwitchState();

    void setSwitchState(Boolean s);

    String possibilities();
}
