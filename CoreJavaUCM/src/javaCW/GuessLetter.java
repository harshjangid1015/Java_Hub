package javaCW;

import java.util.Scanner;

public class GuessLetter {
	public static void main(String[] args) throws java.io.IOException{
		
		char minNum = 'A', maxNum ='Z';
		char ch;
		
		double r = (maxNum+1)*Math.random()+minNum;
		char answer = (char)r;
		
		System.out.println(answer);
		
		System.out.println("I am thinking of a letter between A and Z.");
		ch=(char)System.in.read();
//		Scanner.scan = new Scanner(System.in);
//		
//		System.out.println("Enter a maximum numver for random genaration:");
//		int maxNum = scan.nextInt();
//		double r = (maxNum+1)*Math.random();
//		System.out.println(r);
//		System.out.println((int)r);
//		
//		char ch, answer = 'K';
//		System.out.println("I am thinking of a letter between A and Z.");
//		System.out.print("Can you guess it: ");
//		ch= (char) System.in.read();
//		if(ch==answer) System.out.println("**Right**");
//		else {
//			System.out.print("...Sorry, you are ");
//			if(ch<answer)System.out.println("too low");
//			else System.out.println("too high");
//			
//		}
//			
		
	}

}
