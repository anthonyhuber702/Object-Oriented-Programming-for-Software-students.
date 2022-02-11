package oop;

import java.util.Scanner;

public class TestTriangleClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter side 1: ");
		double side1 = input.nextDouble();
		System.out.print("Enter side 2: ");
		double side2 = input.nextDouble();
		System.out.print("Enter side 3: ");
		double side3 = input.nextDouble();
		System.out.print("Enter a color: ");
		String color = input.next();
		System.out.print("Is the trianlge filled?(true or false): ");
		String filled = input.next();
		boolean filledIn;
		if(filled.equals("true")) {
			filledIn = true;
		}
		else filledIn = false;
		
		TriangleClass triangle = new TriangleClass(side1, side2, side3, color, filledIn);
		System.out.println(triangle.toString());
		System.out.printf("\nArea: %.2f\n", triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
	}

}
