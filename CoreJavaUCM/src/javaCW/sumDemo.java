package javaCW;

public class sumDemo {
	public static void main(String[] args) {
		int numbers[] = new int[] {10, 1, 5, -6, 4};
		int sum = 0;
		for(int i=0; i<numbers.length; i++) {
			sum += numbers[i];
			System.out.println("number = " + numbers[i] + ", sum = " + sum);
		}
	}
}
