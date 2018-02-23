package javaHW;

public class GuessLetter {
	public static void main(String[] args) throws java.io.IOException {
		char minNum ='A', maxNum= 'Z';
		double r = (maxNum+1-minNum)*Math.random() + minNum;
		//		System.out.println(r);
		//		System.out.println((char)r);
		char answer = (char)r;
		System.out.println(answer);
		char ch;

		while(true) {

			System.out.print("I am thinking of a letter between A and Z. Enter your guess: ");

			// read a letter, but skip cr/lf
			do {
				ch = (char) System.in.read();
			} while(ch == '\n' | ch == '\r');
			
			if(ch == answer) {
				System.out.println("**Right**");
				break;
			}
			else {
				if(ch < answer) System.out.println("Guess Higher");
				else System.out.println("Guess Lower");
			}


		}
	}

}


