package recursion;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = input.next();
		System.out.print(s + " backwards is ");
		reverseDisplay(s);
	}
	public static void reverseDisplay(String value) {
		if (value.length() == 1) {
			System.out.println(value);
		}
		else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}

}
