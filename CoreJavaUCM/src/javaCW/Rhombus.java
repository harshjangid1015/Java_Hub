package javaCW;

public class Rhombus {
	private double side, angleInDeg;
	
	public Rhombus(double side, double angleInDeg) {
		this.side = side;
		this.angleInDeg = angleInDeg;
	}
	public double perimeter() {
		return side*4;
	}
	public double area() {
		return side*side*Math.sin(Math.toRadians(angleInDeg));
	}
	public double getSide() {
		return side;
	}
}
