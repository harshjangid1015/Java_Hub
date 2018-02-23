package javaCW;

public class ManhattanDistance {
	public static double abs(double n) {
		if (n>=0) return n;
		return -n;
	}
	public static double manhattanD(double x1, double y1, double x2, double y2) {
		return abs(x1-x2) + abs(y1-y2);
	}
	public static void main(String[] args) {
		System.out.println("Manhattan distance is" + manhattanD(1,1,3,5));
		System.out.println("Manhattan distance is" + manhattanD(-1,-1,3,5));
		System.out.println("Manhattan distance is" + manhattanD(-1,-1,-3,-5));
	}
}
