package javaHW;

import java.util.Scanner;

public class RandomInt {
	public static void main(String[] args) {
		System.out.print("Enter a maximum positive number for random number generation: ");
		Scanner scan = new Scanner(System.in);
		int maxNum = scan.nextInt();
		double r = (maxNum+1)*Math.random();
		
		System.out.println((int)r);
	}

}
