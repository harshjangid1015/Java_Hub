package javaHW;

import java.util.Scanner;

public class CalculateGratuity {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Subtotal and gratuaty rate: ");
		double a = scan.nextDouble();	//a as subtotal
		double b = scan.nextDouble();	//b as gratuaty rate
		double g = (a*b)/100;			//g as gratuaty
		double t = a+g;					//t as total

		System.out.println("gratuaty is " +g+" and the total is "+t);


	}


}


