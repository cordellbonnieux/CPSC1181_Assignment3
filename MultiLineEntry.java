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
		String text = "";
		boolean read = true;
		String line = "";
		this.scan.nextLine();
		
		while(read) {
			line = this.scan.nextLine();
			if (line.equals("")) {
				read = false;
			} else {
				text += line + "\n";
			}
		}
		return text.trim();
	}
}
