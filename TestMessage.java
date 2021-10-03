import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestMessage {
	
	/**
	 * First Message Object
	 * Using default constructor
	 * @return Message message1
	 * @Ignore 
	 */
	public static Message message1() {
		String text1 = "Don't be a bad kitty!";
		String sender1 = "Cordie";
		String recipient1 = "Moro";
		Message.Status status1 = Message.Status.READ;
		Message message1 = new Message(text1, sender1, recipient1, status1);
		return message1;
	}


	/**
	 * Second Message Object
	 * Using short constructor
	 * @return Message message2
	 * @Ignore
	 */
	public static Message message2() {
		String text2 = "Give me treats!";
		String sender2 = "Moro";
		String recipient2 = "Cordie";
		Message message2 = new Message(text2, sender2, recipient2);
		return message2;
	}

	
	/**
	 * Tests For Get Methods
	 */
	
	
	@Test
	@DisplayName("Get Text")
	void testGetText() {
		System.out.println("entered get text test");
		assertEquals("Don't be a bad kitty!", message1().getText());
		assertEquals("Give me treats!", message2().getText());
	}
	
	@Test
	@DisplayName("Get Sender")
	void testGetSender() {
		System.out.println("entered get sender test");
		assertEquals("Cordie", message1().getSender());
		assertEquals("Moro", message2().getSender());
	}
	
	@Test
	@DisplayName("Get Recipient")
	void testGetRecipient() {
		System.out.println("entered get recipient test");
		assertEquals("Moro", message1().getRecipient());
		assertEquals("Cordie", message2().getRecipient());
	}
	
	@Test
	@DisplayName("Get Status")
	void testGetStatus() {
		System.out.println("entered get status test");
		assertEquals(Message.Status.READ, message1().getStatus());
		assertEquals(Message.Status.UNREAD, message2().getStatus());
	}
	
	@Test
	@DisplayName("Get Counter Index")
	void testGetCounterIndex() {
		System.out.println("entered get index test");
		// every instance's is accumulated in Message.java
		// reset the counter for accurate results
		Message.resetCounter();
		
		assertEquals(0, message1().getCounterIndex());
		assertEquals(1, message2().getCounterIndex());
	}
	
	/**
	 * Tests For Set Method
	 */
	
	
	@Test
	@DisplayName("Set Status")
	void testSetStatus() {
		// starred status for testing
		Message.Status starred = Message.Status.STARRED;
		
		Message message1 = message1();
		Message message2 = message2();
		
		assertEquals(Message.Status.READ, message1.getStatus());
		assertEquals(Message.Status.UNREAD, message2.getStatus());
		
		// Set both to starred
		message1.setStatus(starred);
		message2.setStatus(starred);
		
		assertEquals(starred, message1.getStatus());
		assertEquals(starred, message2.getStatus());		
	}
	
	
	/**
	 * Tests for Static Methods
	 */
	
	
	@Test
	@DisplayName("Get Total Number Of Messages")
	void testGetTotalNumberOfMessages() {
		Message.resetCounter();
		assertEquals(0, Message.getTotalNumberOfMessages());
		Message message1 = message1();
		Message message2 = message2();
		assertEquals(2, Message.getTotalNumberOfMessages());
	}
	
	@Test
	@DisplayName("Get Total Number Of Characters")
	void testGetTotalNumberOfChars() {
		Message.resetCounter();
		Message message1 = message1();
		Message message2 = message2();
		assertEquals(message1.getText().length() + message2.getText().length(), Message.getTotalNumberOfChars());
	}
	
	@Test
	@DisplayName("Get Number Of Characters")
	void testGetNumberOfChars() {
		Message.resetCounter();
		Message message1 = message1();
		Message message2 = message2();
		assertEquals(message1.getText().length(), Message.getNumberOfChars(message1.getCounterIndex()));
		assertEquals(message2.getText().length(), Message.getNumberOfChars(message2.getCounterIndex()));
	}
}
