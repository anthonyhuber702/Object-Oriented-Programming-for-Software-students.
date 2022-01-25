package oop;

class Rectangle {
	double width = 1.0;
	double height = 1.0;
	
	Rectangle() {
	}
	
	Rectangle(double w, double h){
		width = w;
		height = h;
	}
	double getArea() {
		return width * height;
	}
	double getPerimeter() {
		return 2 * (width + height);
	}
	
	}
