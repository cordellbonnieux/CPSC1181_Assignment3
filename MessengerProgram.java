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
		
		// set up messenger and add users
		Messenger msg = new Messenger();
		msg.addUsers(scanUsers(s));
		
		// set up main menu
		UserMenuEntry main = new UserMenuEntry(s, mainMenu());
		
		// set up user list
		UserMenuEntry users = new UserMenuEntry(s, msg.getUsers());
		
		// set up text entry
		MultiLineEntry text = new MultiLineEntry(s, "Enter your message: ");
		
		// get active user
		String user = users.getUserResponse();

		MessengerProgram prog = new MessengerProgram(s, msg, main, users, text, user);
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
	
	/**
	 * Main Menu
	 * Sets up a main menu
	 * @return ArrayList<String> each string representing a choice in the menu
	 */
	private static ArrayList<String> mainMenu() {
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
	
	/**
	 * Add Users 
	 * Scans the user's input and creates a list of usernames to be used in the program
	 * @param s Scanner 
	 * @return ArrayList<String> of usernames
	 */
	private static ArrayList<String> scanUsers(Scanner s) {
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
