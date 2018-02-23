package javaHW;

import java.util.Scanner;

public class RandomIntRangeWhile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maxNum=1;
		int minNum=0;
		while (maxNum!=minNum) {
			System.out.print("Enter a maximum positive number for random generation (same numbers to quit): ");
			minNum = scan.nextInt();
			maxNum = scan.nextInt();
			double r = minNum+(maxNum-minNum+1)*Math.random();
			System.out.println((int)r);

		}
		
		
	}
}
