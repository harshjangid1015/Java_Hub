package javaCW;

// this will not compile
class X{
	int a;
	
	X(int i){ a= i;}
}
class Y extends X {
//	int a;
	
//	Y(int i) {a=i;}
	Y(int i) {
		super(i);
	}
}

public class IncompatibleRef {
	public static void main(String[] args) {
		X x = new X(10);
		X x2;
		Y y = new Y(5);
		
		x2 = x;	// Ok, both of same type
		
		x2 = y;	// Error, not of same type
	}

}
