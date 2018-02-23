package javaHW;

import java.util.Scanner;

public class RandomIntWhile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maxNum=1;
		
		while (maxNum!=0) {
			System.out.print("Enter a maximum positive number for random generation (0 to quit): ");
			maxNum = scan.nextInt();
			double r = (maxNum+1)*Math.random();
			System.out.println((int)r);

		}

	}

}

