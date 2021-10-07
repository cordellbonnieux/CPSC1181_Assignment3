import java.util.Scanner;
/**
 * 
 * @author cordell
 *
 */
public abstract class UserEntry {
	protected final Scanner scan;
	protected final String text;
	
	public UserEntry(Scanner s, String t) {
		this.scan = s;
		this.text = t;
	}
	
	public abstract String getUserResponse();
}
