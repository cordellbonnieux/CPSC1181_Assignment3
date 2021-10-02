
public class Message {
	
	public enum Status { READ, UNREAD, STARRED };
	private String text;
	private String sender;
	private String recipient;
	private Status current;
	
	void Message(String t, String s, String r, Status x) {
		this.text = t;
		this.sender = s;
		this.recipient = r;
		this.current = x;
	}
	
	void Message(String t, String s, String r) {
		this.text = t;
		this.sender = s;
		this.recipient = r;
		this.current = Status.UNREAD;
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
		Status s = this.current;
		return s;
	}
	public void setStatus(Status s) {
		this.current = s;
	}
	
}
