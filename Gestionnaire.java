package gestionnaire;


import habitant.Habitant;

//import zone.Zone;

/**
 * @author florianV
 */
public class Gestionnaire extends Habitant implements IGestionnaire {


    public Gestionnaire(String name, String password) {
        super(name, password);
    }
    
   // public void addZone(String nom, String description)
    //{
    //   déjà existante pour GestionZone, nécessité de le faire?
    //}
    
    public void removeHabitant(Habitant a) {
    	 a.setName(null);
    	 a.setPassword(null);
    }
    
    public Habitant addHabitant(String name, String password) {
    	return new Habitant(name,password);
    }


//public static void main(String args[]) {
//	Gestionnaire a = new Gestionnaire("a","b");
//	Habitant florian = a.addHabitant("florian","1234");
//	System.out.println(florian.getName());
//	System.out.println(florian.getPassword());
//	a.removeHabitant(florian);System.out.println("après suppression");
//	System.out.println(florian.getName());
//	System.out.println(florian.getPassword());
//}
}