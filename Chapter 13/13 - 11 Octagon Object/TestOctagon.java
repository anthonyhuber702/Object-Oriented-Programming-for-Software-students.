package oop;

public class TestOctagon {

	public static void main(String[] args) {
		Octagon octagon1 = new Octagon(5);
				Octagon octagon2 = (Octagon)octagon1.clone();
				System.out.println("octagon area: " + octagon1.toString());
				System.out.println("octagon1 == octagon2 is " + (octagon1 == octagon2));
				System.out.println("octagon1.compareTo(octagon2) is " + (octagon1.compareTo(octagon2)));
			}

}
