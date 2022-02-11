package oop;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
	private int sides;
	
	Octagon() {
		
	}
	public Octagon(int sides){
		this.sides = sides;
	}
	public double getArea() {
		double area = (2 + (4/Math.sqrt(2))) * sides * sides;
		return area;
	}
	public int compareTo(Octagon o) {
		if (getArea() > o.getArea()) {
			return 1;
		}
		else if (getArea() < o.getArea()) { 
			return -1;
		}
		else
			return 0;
	}
	@Override
	public double getPerimeter() {
		return 0;
	}
	@Override
	public String toString() {
		return super.toString() + "Area: " + getArea();
	}
	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException ex) {
			return null;
		}
	}
}