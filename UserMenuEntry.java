import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public class UserMenuEntry extends UserEntry{
	private ArrayList<String> options; //= addOptions();
	

	
	public UserMenuEntry(Scanner s, ArrayList<String> l) {
		super(s, "Enter a number from the choices above:");
		//this.options.addAll(l);
		this.options = new ArrayList<String>(l);
	}
	
	public UserMenuEntry(Scanner s) {
		this(s, new ArrayList<String>(0));
	}
		
	public String getUserResponse(){
		String choice = "";
		
		// display options with number (index + 1)
		for (int i = 0; i < this.options.size(); i++) {
			System.out.println((i+1) +": " + this.options.get(i));
		}

		// get user's choice
		while (choice.equals("")) {
			// display prompt
			System.out.print(this.prompt);
			
			choice = this.scan.next();
			int intChoice = 0;
			
			if (isInt(choice)) {
				intChoice = Integer.parseInt(choice);
			}
			
			if (intChoice <= this.options.size() && intChoice >= 1) {
				choice = this.options.get(intChoice - 1);
			} else {
				System.out.println("Invalid entry");
				choice = "";
			}
		}
		System.out.println("User Choice: " + choice);
		return choice;
	}
	
	/**
	 * isInt 
	 * Validates the inputed string, if valid it is safe to convert to integer
	 * (without having to deal with exceptions)
	 * @param t String - input string to be validated
	 * @return boolean true if string is valid, false otherwise
	 */
	private boolean isInt(String t){
		if (t.equals(null)) {
			return false;
		} else if (t.length() <= 0 || t.length() > 2) {
			return false;
		}
		
		if (t.length() == 1) {
			if (t.charAt(0) > '9' || t.charAt(0) < '0') {
				return false;
			}
		} else if (t.length() == 2) {
			if (t.charAt(0) > '9' || t.charAt(0) < '0') {
				return false;
			}
			if (t.charAt(1) > '9' || t.charAt(1) < '0') {
				return false;
			}
		}
		return true;
	}
}
