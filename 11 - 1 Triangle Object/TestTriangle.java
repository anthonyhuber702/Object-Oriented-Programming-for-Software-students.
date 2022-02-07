package oop;
import java.util.Scanner;
public class TestTriangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter side 1: ");
		double side1 = input.nextDouble();
		System.out.print("Enter side 2: ");
		double side2 = input.nextDouble();
		System.out.print("Enter side 3: ");
		double side3 = input.nextDouble();
		System.out.print("What color?: ");
		String color = input.next();	
		System.out.print("Is it filled? (true or false): ");
		String filled = input.next();
		boolean filledIn;
		if(filled.equals("true")) {
			filledIn = true; 
		}
		else filledIn = false;
		
		Triangle triangle = new Triangle(side1, side2, side3, color, filledIn);
		System.out.print(triangle.toString());
		System.out.printf("\nArea: %.2f\n", triangle.getArea());
		System.out.print("Perimeter: " + triangle.getPerimeter());
	
	}

}
