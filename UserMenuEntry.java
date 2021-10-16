import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public class UserMenuEntry extends UserEntry{
	private ArrayList<String> options = addOptions();
	

	
	public UserMenuEntry(Scanner s, ArrayList<String> l) {
		super(s, "Enter a number from the coices above:");
		this.options.addAll(l);
	}
	
	private ArrayList<String> addOptions() {
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
	
	public String getUserResponse() {
		String choice = "";
		
		// display options with number (index + 1)
		for (int i = 0; i < this.options.size(); i++) {
			System.out.println((i+1) +": " + this.options.get(i));
		}

		// get user's choice
		while (choice.equals("")) {
			// display prompt
			System.out.print(this.prompt);
			
			choice = this.scan.nextLine();
			int intChoice = Integer.parseInt(choice);
			
			if (intChoice <= this.options.size() && intChoice >= 0) {
				choice = this.options.get(intChoice - 1);
			} else {
				System.out.println("Invalid entry \n");
			}
		}
		
		
		return choice;
	}
}
