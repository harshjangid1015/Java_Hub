package javaHW;
import java.util.Scanner;
public class Celsius2Fahrenheit {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a degree in Celsius: ");
		double celsius = scan.nextDouble();
		
		double fahrenheit=((celsius*9/5)+32);
		System.out.println(celsius+ " Celsius is "+fahrenheit+" Fahrenheit" );
		
	}

}
