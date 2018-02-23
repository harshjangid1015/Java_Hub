package javaCW;

public class DistanceDemo {
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
	}
	public static void main(String[] args) {
		System.out.println("distance is "+ distance(1,1,10,1));
		System.out.println("distance is "+ distance(2,2,5,6));
		System.out.println("distance is "+ distance(3,3,4,5));
		
	}

}
