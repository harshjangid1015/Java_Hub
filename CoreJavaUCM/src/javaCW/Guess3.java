package javaCW;

public class Guess3 {
	public static void main(String[] args) throws java.io.IOException{
		char ch, answer = 'K';
		System.out.println("I am thinking of a letter between A and Z.");
		System.out.print("Can you guess it: ");
		ch = (char) System.in.read();
		if(ch==answer) System.out.println("**Right**");
		else {
			System.out.print("...Sorry, you are ");
			if(ch<answer)System.out.println("too low");
			else System.out.println("too high");
			
		}
			
		
	}

}
