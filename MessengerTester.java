
public class MessengerTester {

	public static void main(String[] args) {
		// Create object and add users
		Messenger conversation = new Messenger();
		conversation.addUser("Donnie");
		conversation.addUser("Bird");
		
		// exchange a few messages
		conversation.sendMessage("Donnie", "Bird", "Would you like a peanut?");
		conversation.sendMessage("Bird", "Donnie", "Yes, a peanut is an acceptable treat.");
		
		// test both receiver methods in mixed order.
		System.out.println(conversation.getReceivedMessages("Bird"));
		System.out.println(conversation.getReceivedMessages("Donnie", Message.Status.UNREAD));
		System.out.println(conversation.getReceivedMessages("Bird", Message.Status.READ));
		System.out.println(conversation.getReceivedMessages("Donnie"));
		
		// test smile message
		// ask - create a getter for the user ArrayList in the normal way??
		conversation.sendSmile("Donnie", "Bird");
		System.out.println(conversation.getReceivedMessages("Bird"));
		System.out.println(conversation.getUsers());
		
	}
}
