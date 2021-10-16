import java.util.Scanner;
public class TestUserEntry {
	public static void main(String[] args) {
		MultiLineEntry test1 = new MultiLineEntry(new Scanner(System.in), "Enter text here:");
		System.out.println(test1.getUserResponse());
	}
}
