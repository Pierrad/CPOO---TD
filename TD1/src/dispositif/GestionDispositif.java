package dispositif;

import java.util.ArrayList;

/**
 *
 */
public class GestionDispositif {

    private Dispositif selected;

    private Dispositif dispositif;

    private ArrayList<Dispositif> listDispositifs = new ArrayList<Dispositif>();


    public GestionDispositif() {
    }


    /**
     *
     */
    public ArrayList<Dispositif> list() {
        for (Dispositif dispositif : this.getListDispositifs()) {
            System.out.println(dispositif.toString());
        }
        return this.getListDispositifs();
    }

    public void select(Dispositif dispositif) {
        // TODO implement here
    }

    public ArrayList<Dispositif> demanderListeDispositif() {
        return this.getListDispositifs();
    }

    /**
     *
     */
    public void testBatteries() {
        // TODO implement here
    }


    public Boolean add(Dispositif dispositif) {
        ArrayList<Dispositif> dispositifs = this.getListDispositifs();
        dispositifs.add(dispositif);
        return true;
    }

    public Dispositif getDispositif() {
        return dispositif;
    }

    public void setDispositif(Dispositif dispositif) {
        this.dispositif = dispositif;
    }

    public Dispositif getSelected() {
        return selected;
    }

    public void setSelected(Dispositif selected) {
        this.selected = selected;
    }


    public ArrayList<Dispositif> getListDispositifs() {
        return listDispositifs;
    }


    public void setListDispositifs(ArrayList<Dispositif> listDispositifs) {
        this.listDispositifs = listDispositifs;
    }


}