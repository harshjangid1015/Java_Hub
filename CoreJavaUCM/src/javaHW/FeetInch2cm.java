package javaHW;
import java.util.Scanner;
public class FeetInch2cm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter height in feet and inch. Only Integers! ");
		int feet = scan.nextInt();
		int inch = scan.nextInt();
		double valueInCm = (feet*12*2.54)+(inch*2.54);

		System.out.println("It is "+valueInCm);


	}

}
