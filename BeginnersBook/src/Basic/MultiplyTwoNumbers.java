package Basic;

import java.util.Scanner;

public class MultiplyTwoNumbers {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter First Number: ");
		int num1 = sc.nextInt();
		
		System.out.print("Enter Second Number: ");
		int num2 = sc.nextInt();
		
		sc.close();
		
		int product = num1 * num2;
		
		System.out.println("product of two numbers: " + product);
		
	}

}
