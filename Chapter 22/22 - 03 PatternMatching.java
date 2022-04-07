package dsandalgs;
import java.util.*;
public class PatternMatching {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.next();

		int index = 0;
		for (int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == s2.charAt(0)) {
				index = i;
			}
		}
		if (index >= 0) {
			System.out.println("matched at index " + index);
		}
		else {
			System.out.println("No matched index");
		}
	}

}
