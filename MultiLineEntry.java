import java.util.Scanner;
/**
 * 
 * @author Cordell Bonnieux
 *
 */
public class MultiLineEntry extends UserEntry {
	
	public MultiLineEntry(Scanner s, String t) {
		super(s, t);
	}
	
	public String getUserResponse() {
		System.out.print(this.prompt);
		boolean reading = true;
		String text = "";
		while(reading) {
			if (this.scan.nextLine() == "") {
				reading = false;
			} else {
				text += this.scan.nextLine() + "\n";
			}
		}
		return text;
	}
	
}
