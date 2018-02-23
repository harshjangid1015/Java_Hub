package javaHW;
class Circle2{

	private double radius;
	private double x;
	private double y;
	static double PI = 3.14;

	public Circle2(double radius, double x, double y) {
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	public double perimeter() {
		return (2*PI*radius);
	}
	public double area() {
		return (PI*radius*radius);
	}
	public boolean includePoint(double x1, double y1) {
		double dist = Math.sqrt(Math.pow((x-x1), 2)+ Math.pow((y-y1), 2));
		if (dist < radius) {
			return true;
		}
		return false;
	}

}
public class CircleDemo{
	public static void main(String[] args) {
		Circle2 c1 = new Circle2(2.0, 10, 20);
		System.out.println(c1.includePoint(10, 21));
		System.out.println(c1.includePoint(10, 22));
		System.out.println(c1.includePoint(10, 23));
		System.out.println(c1.includePoint(11, 21));
	}
}






