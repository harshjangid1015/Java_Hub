package JavaPractice;

public class CircleDemo {
	public static void main(String[] args) {
		Circle c1 = new Circle(1.0);
		System.out.println(Circle.count);
		System.out.println(c1.getRadius());
		System.out.println(c1.perimeter());
		System.out.println(c1.area());
		
		Circle c2 = new Circle(2.0);
		System.out.println(Circle.count);
		System.out.println(c2.getRadius());
		System.out.println(c2.perimeter());
		System.out.println(c2.area());
		
		System.out.println("PI=" + c1.PI);
		c1.PI = 3.0;
		System.out.println("PI=" + c1.PI);
		c1.PI = 2.0;
		System.out.println("PI=" + c1.PI);
	}
}
