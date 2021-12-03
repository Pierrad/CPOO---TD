package alerte;

public interface IAlerteAction {
    int getId();

    String getDescription();

    void setId(int id);

    void setDescription(String description);

    Boolean getActive();

    void setActive(Boolean active);
}
