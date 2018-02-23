package javaCW;

public class EqTriangle {
	private double side;
	
	public EqTriangle(double side) {
		this.side = side;
	}
	public double perimeter() {
		return side*3;
	}
	public double area() {
		return (Math.sqrt(3)*side*side)/4;
	}
	public double getSide() {
		return side;
	}

}
