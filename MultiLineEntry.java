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
		System.out.println(this.prompt);
		String text = ""; //this.scan.next();
		//this.scan.nextLine();
		boolean read = true;
		
		while(read) {
			String line = this.scan.nextLine();
			if (line.contentEquals("")) {
				read = false;
			} else {
				text += line + "\n";
			}
		}
		return text.trim();
	}
}
