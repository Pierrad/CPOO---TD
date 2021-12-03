package alerte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * The Alert controler that handle AlerteAction and Notification class
 */
public class GestionAlerte implements Serializable, IGestionAlerte {
    private ArrayList<Notification> notifs = new ArrayList<Notification>();
    private ArrayList<AlerteAction> actionsList = new ArrayList<AlerteAction>();

    public GestionAlerte() {
    }

    /**
     * Initialisation of 2 AlerteAction at the first start of the app
     */
    @Override
    public void initializeActionAlerte() {
        actionsList.add(new AlerteAction(0, "Allumer toutes les sirènes & alarme"));
        actionsList.add(new AlerteAction(1, "Allumer toutes les caméras"));
    }

    @Override
    public ArrayList<Notification> getNotifs() {
        return notifs;
    }

    @Override
    public void addNotif(Notification n) {
        if (!notifs.contains(n)) {
            notifs.add(n);
        }
    }

    @Override
    public void removeNotif(Notification n) {
        notifs.remove(n);
    }

    @Override
    public void removeAllNotifs() {
        notifs.clear();
    }

    @Override
    public ArrayList<AlerteAction> getAlerteActions() {
        return actionsList;
    }

    /**
     * Get all activated AlerteAction
     *
     * @return an Array list of activated alerteAction
     */
    @Override
    public ArrayList<AlerteAction> getAlerteActionsActivated() {
        ArrayList<AlerteAction> aaFiltered = new ArrayList<AlerteAction>();
        for (AlerteAction aa : this.actionsList) {
            if (aa.getActive()) {
                aaFiltered.add(aa);
            }
        }
        return aaFiltered;
    }

    @Override
    public void addAlerteAction(AlerteAction aa) {
        if (!actionsList.contains(aa)) {
            actionsList.add(aa);
        }
    }

    @Override
    public void addAlerteAction(int id, String description) {
        AlerteAction aa = new AlerteAction(id, description);
        if (!actionsList.contains(aa)) {
            actionsList.add(aa);
        }
    }

    @Override
    public void removeAlerteAction(AlerteAction aa) {
        actionsList.remove(aa);
    }

    @Override
    public void removeAlerteAction(int id, String description) {
        actionsList.removeIf(h -> h.getId() == id);
    }

    /**
     * Activate AlerteAction based on Input
     * If the method receive 0,1 then AlerteAction 0 and 1 will be activated
     *
     * @param idActions a string of id separated by comma
     */
    @Override
    public void editAlertAction(String idActions) {
        List<String> idSplited = Arrays.asList(idActions.split("/,/"));
        for (AlerteAction aa : actionsList) {
            aa.setActive(idSplited.contains(String.valueOf(aa.getId())));
        }
    }

    /**
     * Check if an ID of AlerteAction is in activated AlerteAction list
     *
     * @param id an int id
     * @return the state
     */
    @Override
    public boolean activatedListContainsId(int id) {
        return getAlerteActionsActivated().stream().anyMatch(o -> o.getId() == id);
    }
}
