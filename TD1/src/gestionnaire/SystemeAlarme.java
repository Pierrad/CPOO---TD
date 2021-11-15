package gestionnaire;

import dispositif.GestionAlerte;
import dispositif.GestionDispositif;
import habitant.GestionHabitant;
import zone.GestionZone;

public class SystemeAlarme {

	private GestionHabitant gestHabitant;
	private GestionGestionnaire gestGestionnaire;
	private GestionZone gestZone;
    private GestionDispositif gestDispositif;
    private GestionAlerte gestAlerte;    

    /**
     * Default constructor
     */
    public SystemeAlarme() {
    }

	public GestionHabitant getGestHabitant() {
		return gestHabitant;
	}

	public void setGestHabitant(GestionHabitant gestHabitant) {
		this.gestHabitant = gestHabitant;
	}

	public GestionGestionnaire getGestGestionnaire() {
		return gestGestionnaire;
	}

	public void setGestGestionnaire(GestionGestionnaire gestGestionnaire) {
		this.gestGestionnaire = gestGestionnaire;
	}

	public GestionZone getGestZone() {
		return gestZone;
	}

	public void setGestZone(GestionZone gestZone) {
		this.gestZone = gestZone;
	}

	public GestionDispositif getGestDispositif() {
		return gestDispositif;
	}

	public void setGestDispositif(GestionDispositif gestDispositif) {
		this.gestDispositif = gestDispositif;
	}

	public GestionAlerte getGestAlerte() {
		return gestAlerte;
	}

	public void setGestAlerte(GestionAlerte gestAlerte) {
		this.gestAlerte = gestAlerte;
	}

}