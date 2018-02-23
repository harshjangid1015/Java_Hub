package javaCW;

public class Empty3 {
	public static void main(String[] args) {
		//int i;
		int sum = 0;
		
		//sum the numbers through 5
		for (int i=1; i<=5;  sum+= ++i);		//no body in this loop
		//with i++ sum is 15
		// we can also initialise variables in the for loop too
		System.out.println("Sum is "+ sum);
	}

}
