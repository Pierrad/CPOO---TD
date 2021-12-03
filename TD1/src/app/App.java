package app;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * The start of the application, it create an instance of the main Controller SystemeAlarme and then start it.
 */
public class App {
    public static void main(String[] args) throws Exception {
        SystemeAlarme controleur;
        try {
            controleur = new SystemeAlarme();
            controleur.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
