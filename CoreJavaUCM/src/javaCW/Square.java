package javaCW;

public class Square {
	private double side;
	
	static int count=0;
	
	public Square(double side) {
		this.side = side;
		count++;
	}
	public double perimeter() {
		return (4*getSide());
	}
	public double area() {
		return (getSide()*getSide());
	}
	public double getSide() {
		return side;
	}
}
