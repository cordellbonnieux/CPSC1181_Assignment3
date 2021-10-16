import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public abstract class UserEntry {
	protected final Scanner scan;
	protected final String prompt;
	
	public UserEntry(Scanner s, String p) {
		this.scan = s;
		this.prompt = p;
	}
	
	public abstract String getUserResponse();
}
