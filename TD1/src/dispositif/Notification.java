package dispositif;

public class Notification {
	private String	message;
	private Integer id;
	
	public Notification(Integer id, String message) {
		this.message=message;
		this.id=id;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
