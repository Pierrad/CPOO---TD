package zone;

import java.util.ArrayList;

/**
 * Classe GestionZone
 *
 * @author Marie ORFILA
 */

public class GestionZone {
    private ArrayList<Zone> listZones = new ArrayList<Zone>();


    public GestionZone() {
        listZones = new ArrayList<Zone>();
    }

    /**
     * Renvoi la liste de toutes les zones
     *
     * @return List<Zone>
     */

    public ArrayList<Zone> getZones() {
        return listZones;
    }

    /**
     * Change la liste des zones
     *
     * @param List<Zone>
     */
    public void setZones(ArrayList<Zone> zone) {
        this.listZones = zone;
    }

    /**
     * Ajout une zone
     *
     * @param nom
     * @param description
     */
    public void addZone(String nom, String description) {
        ArrayList<Zone> listZones = this.getZones();
        listZones.add(new Zone(nom, description));
    }

    /**
     * Supprime une zone
     *
     * @param zone
     */
    public void removeZone(Zone zone) {
        ArrayList<Zone> listZones = this.getZones();
        listZones.remove(zone);
    }

    public ArrayList<Zone> list() {
        for (Zone zone : this.getZones()) {
            System.out.println(zone.toString());
        }
        return this.getZones();
    }

}
