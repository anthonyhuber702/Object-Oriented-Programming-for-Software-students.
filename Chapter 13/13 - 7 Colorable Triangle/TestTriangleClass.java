package oop;

public class TestTriangleClass {

	public static void main(String[] args) {
		TriangleClass[] objects = new TriangleClass[5];
		objects[0] = new TriangleClass(2, 3, 4, "red", true);
		objects[1] = new TriangleClass(5, 6, 7, "blue", false);
		objects[2] = new TriangleClass(8, 9, 10, "green", true);
		objects[3] = new TriangleClass(11, 12, 13, "purple", false);
		objects[4] = new TriangleClass(14, 15, 16, "yellow", true);
		
		
		for (int i = 0; i < objects.length; i++) {
			System.out.printf("Area: %.2f\n", objects[i].getArea());
		}
		for (int i = 0; i < objects.length; i++) {
			if(objects[i] instanceof Colorable) {
				objects[i].howToColor();
			}
		}
	}

}
