package javaCW;

public class Power {
	public static void main(String[] args) {
		int e;
		int result;

		for (int i=0; i<10;i++) {
			result=i;
			e=1;
			while(e>0) {				//also try with for loop
				result*=2;
				e--;
			}
			System.out.println("2 to the "+ i+ " power is " +result);
			
		}

	}
}