package javaCW;

public class SamplePaper {
	static int factorial(int n) {
		System.out.println("factorial:"+n);
		if (n==1) return 1;
		int res = n * factorial(n-1);
		System.out.println("about to return "+ res);
		return res;		
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
}
