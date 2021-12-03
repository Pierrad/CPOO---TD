package gestionnaire;

public interface IGestionGestionnaire {
    Gestionnaire getCurrentGestionnaire();

    void defineNewGestionnaire(String name, String password);

    Boolean isGestionnaire(String name);

    void disconnect();

}
