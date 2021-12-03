package habitant;

public interface IHabitant {
    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);

    boolean login(String name, String password);
}
