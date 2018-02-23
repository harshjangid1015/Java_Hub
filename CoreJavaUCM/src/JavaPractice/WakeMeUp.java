package JavaPractice;

public class WakeMeUp {
	public static void main(String[] args)
	throws java.io.IOException{
		System.out.println("Wake me up by pressing 'q'...");
		while((char)System.in.read()!='q');
		System.out.println("Thank You Prince!");
	}

}
