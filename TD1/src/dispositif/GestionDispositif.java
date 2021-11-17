package dispositif;

import java.util.ArrayList;

/**
* Classe de Gestion Dispositif
 * @author Enzo
*/
public class GestionDispositif {
    private Dispositif dispositif;
    private ArrayList<Dispositif> listDispositif;


    /**
     * Renvoi LE dispositif actuel
     * @return Dispositif
     */
    public Dispositif getDispositif() {
        return dispositif;
    }

    /**
     * Change le dispositif acutel
     * @param dispositif
     */
    public void setDispositif(Dispositif dispositif) {
        this.dispositif = dispositif;
    }

    /**
     * Renvoi la liste de tous les dispositifs
     * @return List<Dispositif>
     */
    public ArrayList<Dispositif> getDispositifs() {
        return listDispositif;
    }

    /**
     * Change la liste des dispositifs
     * @param List<Dispositif>
     */
    public void setDispositifs(ArrayList<Dispositif> dispositifs) {
        this.listDispositif = dispositifs;
    }

    /**
     * Change la Zone du dispositif actuel
     * @param Dispositif dispositif, Zone zone
     */
    public changeZone() {
        //TODO
    }

    /**
     * Retire une zone
     * @param Zone zone
     */
    public removeZone() {
        //TODO
    }

    /**
     * Active tous les dispositifs d'une Zone
     * @param Zone zone
     */
    public activateAll() {
        //TODO
    }

    /**
     * Désactive tous les dispositifs d'une Zone
     * @param Zone zone
     */
    public deactivateAll() {
        //TODO
    }

    /**
     * Ajoute un dispositif à la Zone
     * @param Dispositif dispositif, String name, Zone zone
     */
    public addDispositif() {
        //TODO
    }

    /**
     * Active un dispositif
     * @param Dispositif dispositif
     */
    public activate() {
        //TODO
    }

    /**
     * Désactive un dispositif
     * @param Dispositif dispositif
     */
    public deactivate() {
        //TODO
    }

    /**
     * Allume un dispositif
     * @param Dispositif dispositif
     */
    public turnOn() {
        //TODO
    }

    /**
     * Éteint un dispositif
     * @param Dispositif dispositif
     */
    public turnOff() {
        //TODO
    }

}
