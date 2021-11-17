package app;

import td01.SystemeAlarme;

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
