package alerte;

import java.util.ArrayList;

public interface IGestionAlerte {
    void initializeActionAlerte();

    ArrayList<Notification> getNotifs();

    void addNotif(Notification n);

    void removeNotif(Notification n);

    void removeAllNotifs();

    ArrayList<AlerteAction> getAlerteActions();

    ArrayList<AlerteAction> getAlerteActionsActivated();

    void addAlerteAction(AlerteAction aa);

    void addAlerteAction(int id, String description);

    void removeAlerteAction(AlerteAction aa);

    void removeAlerteAction(int id, String description);

    void editAlertAction(String idActions);

    boolean activatedListContainsId(int id);
}
