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
		
		// create scanner
		Scanner s = new Scanner(System.in);

		// create program object
		MessengerProgram prog = new MessengerProgram(s, new Messenger(), new UserMenuEntry(s, mainMenu()), new UserMenuEntry(s), new MultiLineEntry(s, "Enter your message: "), "");
		
		// execute the program
		prog.execute();
		
		// close scanner
		s.close();
		
		// end program
		System.exit(0);
	}
	
	/**
	 * Class Constructor
	 * @param sc
	 * @param msg
	 * @param main
	 * @param user
	 * @param text
	 * @param active
	 */
	public MessengerProgram(Scanner sc, Messenger msg, UserMenuEntry main, UserMenuEntry user, MultiLineEntry text, String active) {
		this.scan = sc;
		this.messenger = msg;
		this.mainMenu = main;
		this.userMenu = user;
		this.textEntry = text;
		this.activeUser = active;
	}
	
	public void execute() {
		
		boolean exit = false;
		
		// user enters all the users' names
		this.messenger.addUsers(scanUsers(this.scan));
		this.userMenu.addOptions(this.messenger.getUsers());
		
		// user selects their user name from the list
		System.out.println("Who are you?");
		this.activeUser = this.userMenu.getUserResponse();
		
		// main program loop
		while (!exit) {
			
			// user selects what to do next
			String selection = this.mainMenu.getUserResponse();
			int index = getIndex(selection, mainMenu());
			
			switch(index) {
				case 0: System.out.println(this.messenger.getReceivedMessages(this.activeUser));
					break;
				case 1: System.out.println(this.messenger.getReceivedMessages(this.activeUser, Message.Status.UNREAD));
					break;
				case 2: System.out.println("Who would you like to send a message to?");
					String textRecipient = this.userMenu.getUserResponse();
					String messageText = this.textEntry.getUserResponse();
					this.messenger.sendMessage(this.activeUser, textRecipient, messageText);
					break;
				case 3: System.out.println("Who would you like to send a smile to?");
					String smileRecipient = this.userMenu.getUserResponse();
					this.messenger.sendSmile(this.activeUser, smileRecipient);
					break;
				case 4: System.out.println("Which user would you like to change to?");
					this.activeUser = this.userMenu.getUserResponse();
					break;
				case 5: System.out.println(this.toString());
					break;
				case 6: exit = true;
					System.out.println("Goodbye!");
			}
		}

	}
	
	/**
	 * 
	 * @param t
	 */
	public void setActiveUser(String t) {
		if (t.equals(null)) {
			throw new NullPointerException();
		}
		this.activeUser = t;
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
				if (line.length() == 0) {
					reading = false;
				} else {
					list.add(line);
				}
			}
		}
		return list;
	}
	
	/**
	 * Used 
	 * @param s
	 * @return
	 */
	private static int getIndex(String s, ArrayList<String> menu) {
		for (int i = 0; i < menu.size(); i++) {
			if (s.equals(mainMenu().get(i))) {
				return i;
			}
		}
		return 99;
	}
	
	@Override
	public String toString() {
		String info = "*** Messenger Stats *** \n";
		info += "Active user: " + this.activeUser + "\n";
		info += "Users: " + this.messenger.getUsers() + "\n";
		info += "Number of messages exchanged: " + this.messenger.getNumberOfMessages() + "\n";
		return info;
	}
}
