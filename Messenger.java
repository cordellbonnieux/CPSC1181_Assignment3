import java.util.ArrayList;

public class Messenger {
	
	private ArrayList<String> usernames;
	private ArrayList<Message> messages;
	
	public Messenger() {
		this.usernames = new ArrayList<String>();
		this.messages = new ArrayList<Message>();
	}
	
	public void addUser(String username) {
		if (username.equals(null)) {
			throw new NullPointerException();
		}
		this.usernames.add(username);
	}
	
	public void sendMessage(String sender, String receiver, String text) {
		if (sender.equals(null) || receiver.equals(null) || text.equals(null)){
			throw new NullPointerException();
			
		} else if (!usernames.contains(sender)) {
			throw new IllegalArgumentException("Sender not found in usernames");
			
		} else if (!usernames.contains(receiver)) {
			throw new IllegalArgumentException("Receiver not found in usernames");
		}

		Message message = new Message(text, sender, receiver);
		messages.add(message);
	}
	
	public ArrayList<Message> getReceivedMessages(String user, Message.Status status) {
		if (status.equals(null)) {
			throw new NullPointerException();
			
		} else if (user.equals(null)) {
			throw new NullPointerException();
			
		} else if (!usernames.contains(user)) {
			throw new IllegalArgumentException("User not found in usernames");
		}
		
		ArrayList<Message> list = new ArrayList<Message>();
		
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getStatus().equals(status)) {		
				if (status.equals(Message.Status.UNREAD)) {
					messages.get(i).setStatus(Message.Status.READ);	
				}
				list.add(messages.get(i));
			}
		}
		
		return list;
	}
	
	public ArrayList<Message> getReceivedMessages(String user) {
		if (user.equals(null)) {
			throw new NullPointerException();
			
		} else if (!usernames.contains(user)) {
			throw new IllegalArgumentException("User not found in usernames");
		}
		
		ArrayList<Message> list = new ArrayList<Message>();
		
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getStatus().equals(Message.Status.UNREAD)) {
				messages.get(i).setStatus(Message.Status.READ);
			}
			list.add(messages.get(i));
		}
		
		return list;
	}

}
