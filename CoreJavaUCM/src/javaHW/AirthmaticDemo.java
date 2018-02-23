package javaHW;

public class AirthmaticDemo {
	public static void main(String[] args) {
		System.out.println(42/5);
		System.out.println(42.0/5);
		System.out.println(42%5);
		System.out.println(40%5);
		System.out.println(1%2);
		System.out.println(2%1);
		System.out.println(45+4*4-2);
		System.out.println(45+43%5*(23*3%2));
		System.out.println(Math.sqrt(10));
		System.out.println(Math.pow(5, 2));
		System.out.println(Math.pow(20.0, 100));
		System.out.println(Math.pow(20.0, 1000));
		System.out.println(Math.pow(0.1,300));
		System.out.println(Math.pow(0.1, 400));
		double x=100;
		double y=100;
		double a=100;
		double b=100;
		double c=100;
		//System.out.println(((3)+(4*x*5))-(10*(y-5)*(a+b+c)*x)+9*(4*x+9+x*y));
		//System.out.println(3+4x5-10(y-5)(a+b+c)x+9(4x+9+xy));
		System.out.println(((3+4*x)/5)-((10*(y-5)*(a+b+c))/x)+(9*(4/x+(9+x)/y)));
		
	}
}
