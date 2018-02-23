package JavaPractice;

public class UpperCase {
	public static void main(String[] args) {
		char ch;
		
		for (int i=0; i<10; i++)
			ch = (char) ('a' + i);
			System.out.print(ch);
			
			// This statement turns off the 6th bits
			ch = (char)((int)ch & 65503); //ch is now uppercase
			
			System.out.print(ch + " ");
	}

}
