package javaHW;

import java.util.Scanner;

public class NumInfo {

	static boolean isEven(int n) {
		if(n % 2 == 0)
			return true;
		else
			return false;
	}

	static boolean isPrime(int n) {
		//for(n=1; n<=100; n++)
			//return true;
		
			for (int i=2; i<n; i++)
				if(n % i == 0)
					return false;

			return true;
	}

	static void printFactors(int n) {
		for(int i= 1; i<=n; i++) {
			if(n % i == 0)
				System.out.print(i+ " ");
		}
	}

	static void printPrimeFactors(int n) {
		for (int i=2; i<n; i++) {
			if(n % i == 0 && isPrime(i))
				System.out.print(i+" ");
		}
	}


	public static void main(String[] args) throws java.io.IOException{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a positive integer number: ");
		int num = scan.nextInt();

		if(isEven(num)) System.out.println(num+ " is an even number.");
		else System.out.println(num+ " is an odd number.");

		if(isPrime(num)) System.out.println(num+ " is a prime number.");
		else {
			System.out.println(num+ " is NOT a prime number.");

			System.out.print("The factors are ");
			printFactors(num);
			System.out.println();
			System.out.print("The prime factors are ");
			printPrimeFactors(num);
		}

	}
}
