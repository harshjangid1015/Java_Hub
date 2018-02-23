package javaHW;
import java.util.Scanner;

public class SumDigits {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number between0 and 1000: ");
		int num = scan.nextInt();
		int a=num/10;
		int b=num%10;
		int c=a/10;
		int d=a%10;
		int e=b+d+c;
		System.out.println("The sum of the digits is "+e);
	}

}
