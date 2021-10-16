import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public class MultiLineEntry extends UserEntry {
	
	public MultiLineEntry(Scanner s, String t) {
		super(s,t);
		
	}
	
	public String getUserResponse() {
		boolean read = true;
		String text = "";
		while(read) {
			if (this.scan.nextLine() == "") {
				read = false;
			} else {
				text += this.scan.nextLine() + "\n";
			}
		}
		return text;
	}
	
}
