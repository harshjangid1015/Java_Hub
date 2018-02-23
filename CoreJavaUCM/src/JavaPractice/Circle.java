package JavaPractice;

public class Circle {
	private double radius;
	static double PI = 3.1;
	static int count = 0;
	public Circle(double radius) {
		this.radius = radius;
		System.out.println("Circle(" + radius + ")");
		count++;
	}
	public double perimeter() {
		return (2*PI*getRadius());
	}
	public double area() {
		return(PI*getRadius()*getRadius());
	}
	public double getRadius() {
		return radius;
	}
}

