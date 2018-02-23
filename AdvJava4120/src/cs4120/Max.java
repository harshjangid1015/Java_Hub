package cs4120;

public class Max {
	/** Return the maximum of two objects */
	public static Comparable max(Comparable o1, Comparable o2) {
		if (o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}
	public static void main(String[] args) {
		System.out.println("Max: " + max("Hello", "13"));
	}
}
