import java.util.ArrayList;

public class Message {
	
	private static ArrayList<Integer> numOfChars = new ArrayList<Integer>();

	public enum Status { READ, UNREAD, STARRED };
	
	private String text;
	private String sender;
	private String recipient;
	private Status status;
	
	void Message(String t, String s, String r, Status x) {
		this.text = t;
		this.sender = s;
		this.recipient = r;
		this.status = x;
		numOfChars.add(t.length());
	}
	
	void Message(String t, String s, String r) {
		this.text = t;
		this.sender = s;
		this.recipient = r;
		this.status = Status.UNREAD;
	}
	
	public String getText() {
		String t = this.text;
		return t;
	}
	
	public String getSender() {
		String sender = this.sender;
		return sender;
	}
	
	public String getRecipient() {
		String r = this.recipient;
		return r;
	}
	
	public Status getStatus() {
		Status s = this.status;
		return s;
	}
	public void setStatus(Status s) {
		this.status = s;
	}
	
	public static int getTotalNumberOfMessages() {
		int n = numOfChars.size();
		return n;
	}
	
	public static int getTotalNumberOfChars(int index) {
		int n = numOfChars.get(index);
		return n;
	}
	
	public static int getTotalNumberOfChars() {
		int n = 0;
		for (int i = 0; i < numOfChars.size(); i++) {
			n += numOfChars.get(i);
		}
		return n;
	}
	
	
	public String toString() {
		String out = "*** Message Info ***\n";
		out += "Sender: " + this.sender + "\n";
		out += "Recipient: " + this.recipient + "\n";
		out += "Status: " + this.status + "\n";
		out += "Message Text: " + this.text + "\n";
		return out;
	}
	
}
