package JavaPractice;

import java.util.Scanner;

public class Hypot {
	public static void main(String[] args) {
		double x;
		double y;
				
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter value of Base x: ");
		x = scan.nextDouble();
		System.out.println("Enter value of Height y: ");
		y = scan.nextDouble();
		
		double z= Math.pow(x, 2) + Math.pow(y, 2);
		
		z = Math.sqrt(z);
		System.out.println("value of Hypotanious is z= "+z);
	}

}
