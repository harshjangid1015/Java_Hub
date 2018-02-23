package javaCW;

public class GetMaxDemo {
	public static int getMax(int[] values) {
		int max = values[0];
		for(int i =0; i<values.length; i++) {
			if(values[i]>max) {
				max = values[i];
				return max;
			}
		}
		return max;
		
	}
	public static void main(String[] args) {
		System.out.println("The max values is " + getMax(new int[] {1, 5, -2, 10}));
		System.out.println("The max values is " + getMax(new int[] {-3}));
		System.out.println("The max values is " + getMax(new int[] {15, 15}));
	}

}
