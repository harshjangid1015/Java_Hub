package Basic;

public class TernaryOperatorDemo {
	public static void main(String args[]) {
		int num1, num2;
		num1 = 25;
		/* num1 is not equal to 10 that's why
		 * the second value after colon is assigned
		 * to the variable num2
		 */
		num2 = (num1 == 10) ? 100: 200;
		System.out.println( "num2: "+num2);

		/* num1 is equal to 25 that's why
		 * the first value is assigned
		 * to the variable num2
		 */
		num2 = (num1 == 25) ? 100: 200;
		System.out.println( "num2: "+num2);
	}
}
