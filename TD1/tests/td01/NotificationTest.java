package td01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dispositif.Notification;

class NotificationTest {
private Notification n1;
private Notification n2;
private Notification n3;

@BeforeEach
void setUp() {
	n1= new Notification(2, "Salut");
	n2= new Notification(6,"Bonjour");
	n3= new Notification(11, "Re");
}
	@Test
	void TestSetterMessage() {
		n1.setMessage("Salut");
		 Assertions.assertEquals("Salut", n1.getMessage());
		n2.setMessage("Bonjour");
		 Assertions.assertEquals("Bonjour", n2.getMessage());
		n3.setMessage("Re");
		Assertions.assertEquals("Re", n3.getMessage());
		}
	@Test
	void TestSetterId() {
		n1.setId(5);
		Assertions.assertEquals(5, n1.getId());
		n2.setId(20);
		 Assertions.assertEquals(20, n2.getId());
		n3.setId(65);
		Assertions.assertEquals(65, n3.getId());
	}

}
