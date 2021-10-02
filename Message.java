import java.util.ArrayList;

public class Message {
	
	private static ArrayList<Integer> counter = new ArrayList<Integer>();

	public enum Status { READ, UNREAD, STARRED };
	
	private String text;
	private String sender;
	private String recipient;
	private Status status;
	private int counterIndex;
	
	public Message(String t, String s, String r, Status x) {
		this.text = t;
		this.sender = s;
		this.recipient = r;
		this.status = x;
		counter.add(t.length());
		counterIndex = counter.size() - 1;
	}
	
	public Message(String t, String s, String r) {
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
	
	public int getCounterIndex() {
		int n = this.counterIndex;
		return n;
	}
	
	public static int getTotalNumberOfMessages() {
		int n = counter.size();
		return n;
	}
	
	public static int getTotalNumberOfChars(int index) {
		int n = counter.get(index);
		return n;
	}
		
	public static int getTotalNumberOfChars() {
		int n = 0;
		for (int i = 0; i < counter.size(); i++) {
			n += counter.get(i);
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
