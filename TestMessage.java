import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import jdk.net.SocketFlow.Status;

public class TestMessage {
	
	/**
	 * First Message Object
	 * Using default constructor
	 */
	String text1 = "Don't be a bad kitty!";
	String sender1 = "Cordie";
	String recipient1 = "Moro";
	Message.Status status1 = Message.Status.READ;
	Message message1 = new Message(text1, sender1, recipient1, status1);

	/**
	 * Second Message Object
	 * Using short constructor
	 */
	String text2 = "Give me treats!";
	String sender2 = "Moro";
	String recipient2 = "Cordie";
	Message message2 = new Message(text2, sender2, recipient2);
	
	@Test
	@DisplayName("Get Text")
	void testGetText() {
		assertEquals(text1, message1.getText());
	}
	
	
}
