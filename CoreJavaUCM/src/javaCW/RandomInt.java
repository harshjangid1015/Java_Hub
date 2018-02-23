package javaCW;

import java.util.Scanner;

public class RandomInt {
	public static void main(String[] args) {
		Scanner.scan = new Scanner(System.in);
		
		System.out.println("Enter a maximum numver for random genaration:");
		int maxNum = scan.nextInt();
		double r = (maxNum+1)*Math.random();
		System.out.println(r);
		System.out.println((int)r);
				
	}

}
