package cs4120;

public class ToStringCount {
	public static void main(String[] args) {
		Integer o1 = new Integer(99);
		Double o2 = new Double(3.14);
		String o3 = "Hello";
		
		System.out.println(o1);
		System.out.println(toStringCount(o1));
		System.out.println(o2);
		System.out.println(toStringCount(o2));
		System.out.println(o3);
		System.out.println(toStringCount(o3));
	}
	
	public static <E> int toStringCount(E object) {
		String s = object.toString();
		return object.toString().length();
	}
}
