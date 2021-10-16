import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public class MultiLineEntry extends UserEntry {
	
	public MultiLineEntry(Scanner s, String p) {
		super(s, p);
	}
	
	public String getUserResponse() {
		System.out.print(this.prompt);
		boolean reading = true;
		String text = "";
		while(reading) {
			if (this.scan.nextLine() == "") {
				reading = false;
			} else {
				// might need to add a new line to the user side console 
				text += this.scan.nextLine() + "\n";
			}
		}
		return text;
	}
	
}
