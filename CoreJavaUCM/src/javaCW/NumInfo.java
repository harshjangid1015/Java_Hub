package javaCW;

import java.util.Scanner;

public class NumInfo {
	public static void main(String[] args) throws java,io.IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a positive integer number: ");
		int num = scan.nextInt();
		
		if(isEven(num))System.out.println(num+ "is a even number.");
		else System.out.println(num+ "is a odd number");
		
		if(isPrime(num)) System.out.println(num+ "is a prime number");
		else
		{
			System.out.println(num+ "is not a prime number");
			
			System.out.println("The factors are ");
			printFactors(num);
			System.out.println();
			System.out.println("The prime factors are ");
			printPrimeFactors(num);
		}
		
	}

}
