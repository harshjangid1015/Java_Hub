package Basic;

public class NaturalNumbersSum {
	public static void main(String[] args) {
		int num = 100;
		int sum = 0;
		
		for(int i = 0; i<=num; i++) {
			sum = sum + i;
		}
		
		System.out.println("sum of first 100 natural numbers is: " + sum);
	}
}
