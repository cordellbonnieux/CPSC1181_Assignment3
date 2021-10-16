import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public abstract class UserEntry {
	protected final Scanner scan = new Scanner(System.in);
	protected final String text = "Enter a number from the choices above:";
	
	public abstract String getUserResponse();
}
