import java.util.ArrayList;
import java.util.Scanner;

public class MessengerProgram {
	private Scanner scan; 
	private Messenger messenger;
	private UserMenuEntry mainMenu;
	private UserMenuEntry userMenu;
	private MultiLineEntry textEntry;
	private String activeUser;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Messenger msg = new Messenger();

		
		MessengerProgram prog = new MessengerProgram(s, );
		prog.execute();
	}
	
	public MessengerProgram(Scanner sc, Messenger msg, UserMenuEntry main, UserMenuEntry user, MultiLineEntry text, String active) {
		this.scan = sc;
		this.messenger = msg;
		this.mainMenu = main;
		this.userMenu = user;
		this.textEntry = text;
		this.activeUser = active;
	}
	
	public void execute() {
		
	}
	
	private ArrayList<String> mainMenu() {
		ArrayList<String> list = new ArrayList<String>(7);
		list.add("See All Messages");
		list.add("See Unread Messages");
		list.add("Send Message");
		list.add("Send Smile");
		list.add("Switch Active User");
		list.add("See Messenger Stats");
		list.add("Exit");
		return list; 
	}
	
	private ArrayList<String> addUsers(Scanner s) {
		System.out.println("Please add some users (one per line).");
		ArrayList<String> list = new ArrayList<String>();
		boolean reading = true;
		while (reading) {
			String line = s.nextLine();
			if (!line.equals(null)) {
				if (line.length() > 0) {
					reading = false;
				} else {
					list.add(line);
				}
			}
		}
		return list;
	}
}
