package recursion;
import java.util.Scanner;
public class GCD {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 2 integers to find their greatest common divisor.");
		System.out.print("Number 1: ");
		int num1= input.nextInt();
		System.out.print("Number 2: ");
		int num2 = input.nextInt();
		
		System.out.println("The greatest common divisor of " + num1 + " and " + num2 + " is " + gcd(num1, num2));
	}
	public static int gcd(int n1, int n2) {
		int gcd = 0;
		if (n1 % n2 == 0) {
			return gcd = n2;
		}
		else {
			return gcd(n2, n1 % n2);  
		}
	}

}
