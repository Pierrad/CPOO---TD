package td2;


package dispositif;

public class Alarme extends Dispositif {
	
	boolean activate_alarme ;
	
    public Alarme(String name, Integer id) {
        super(name, id);
    }
    
    /* M�thode pour activer l'alarme */
    public void start() {
        System.out.println("alarme");
        activate_alarme = true ;
    }

    /* M�thode pour arreter l'alarme */ 
    public void stop() {
    	activate_alarme = false ;
    	System.out.println("ok");
    }
    
}
