import java.util.ArrayList;

public class Messenger {
	
	private ArrayList<String> usernames;
	private ArrayList<Message> messages;
	
	public Messenger() {
		this.usernames = new ArrayList<String>();
		this.messages = new ArrayList<Message>();
	}
	
	void addUser(String username) {
		if (username.contentEquals(null)) {
			throw new NullPointerException();
		}
		this.usernames.add(username);
	}
	
	void sendMessage(String sender, String receiver, String text) {
		if (sender.contentEquals(null) || receiver.contentEquals(null) || text.contentEquals(null)){
			throw new NullPointerException();
			
		} else if (!usernames.contains(sender)) {
			throw new IllegalArgumentException("Sender not found in usernames");
			
		} else if (!usernames.contains(receiver)) {
			throw new IllegalArgumentException("Receiver not found in usernames");
		}

		Message message = new Message(text, sender, receiver);
		messages.add(message);
	}

}
