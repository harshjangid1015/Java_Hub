package javaCW;
//import static java.lang.Math.PI;

public class Circle {
	private double radius;
	static double PI = 3.14159;
//	static final double PI = 3.14159;  //use 'final if you don't want any change after this'
	
	static int count = 0;
	
	public Circle(double radius) {
		this.setRadius(radius);
		count++;
	}
	public double perimeter() {
		return (2*PI*radius);
	}
	public double area() {
		return (PI*getRadius()*getRadius());
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
