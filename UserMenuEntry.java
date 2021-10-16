import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author cordell
 *
 */
public class UserMenuEntry extends UserEntry{
	private ArrayList<String> options = new ArrayList<String>();
	options.add("See All Messages");
	options.add("See Unread Messages");
	options.add("Send Message");
	options.add("Send Smile");
	options.add("Switch Active User");
	options.add("See Messenger Stats");
	options.add("Exit");
	
	public UserMenuEntry(Scanner scan, ArrayList<String> list) {
		// "enter from the choices above" <- set prompt?
		super(scan,list.get(0));
	}
	
	public String getUserResponse() {
		
		
	}
}
