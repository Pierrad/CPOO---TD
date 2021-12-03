package alerte;

import java.io.Serializable;

/**
 * @author Vasseur Pierre-Adrien
 * <p>
 * Notification class, a notification hold a message with an id
 */
public class Notification implements Serializable, INotification {
    private String message;
    private static Integer count = 0;
    private Integer id;

    public Notification(String message) {
        this.message = message;
        this.id = count;
        count++;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
