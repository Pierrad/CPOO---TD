package td2;


package dispositif;

public class Alarme extends Dispositif {
	
	boolean activate_alarme ;
	
    public Alarme(String name, Integer id) {
        super(name, id);
    }
    
    /* Méthode pour activer l'alarme */
    public void start() {
        System.out.println("alarme");
        activate_alarme = true ;
    }

    /* Méthode pour arreter l'alarme */ 
    public void stop() {
    	activate_alarme = false ;
    	System.out.println("ok");
    }
    
}
