package oop;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4, 40);
		System.out.println("Rectangle 1");
		System.out.println("Width: " + rectangle1.width);
		System.out.println("Height: " + rectangle1.height);
		System.out.println("Area: " + rectangle1.getArea());
		System.out.println("Perimeter: " + rectangle1.getPerimeter());
		
		System.out.println();
		
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("Rectangle 2");
		System.out.println("Width: " + rectangle2.width);
		System.out.println("Height: " + rectangle2.height);
		System.out.printf("Area: %.2f\n" , rectangle2.getArea());
		System.out.print("Perimeter: " + rectangle2.getPerimeter());

	}

}
