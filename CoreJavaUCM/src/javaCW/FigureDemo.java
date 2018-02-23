package javaCW;

public class FigureDemo {
	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(10.0);
		System.out.println("c1.radius: "+c1.getRadius());
		System.out.println("c1.area: "+c1.area());
		System.out.println("c1.perimeter: "+c1.perimeter());
		
				
		Square s1 = new Square(5);
		System.out.println("s1.side: "+s1.getSide());
		System.out.println("s1.area: "+s1.area());
		System.out.println("s1.perimeter: "+s1.perimeter());
		
		Rectangle r1 = new Rectangle(4, 3);
		System.out.println("r1.height: "+r1.getHeight());
		System.out.println("r1.area: "+r1.area());
		System.out.println("r1.perimeter: "+r1.perimeter());
		
		System.out.println(Circle.count);				
		System.out.println(Square.count);				
		System.out.println(Square.count);
		
		EqTriangle et1 = new EqTriangle(5);
		System.out.println("et1.side: "+et1.getSide());
		System.out.println("et1.area: "+et1.area());
		System.out.println("et1.perimeter: "+et1.perimeter());
		
		Rhombus rh1 = new Rhombus(5, 30);
		System.out.println("rh1.side: "+rh1.getSide());
		System.out.println("rh1.area: "+rh1.area());
		System.out.println("rh1.perimeter: "+rh1.perimeter());
	}

}
