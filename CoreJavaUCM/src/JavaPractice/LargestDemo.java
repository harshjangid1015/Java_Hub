package JavaPractice;

public class LargestDemo {
	public static int LargestAmongThree(int a, int b, int c) {
		
		// if condition for greatest integer
		if(a > b && a > c)
		{
			return a;
		}
		else
		{
			if(b> c)
				return b;
			else
				return c;
		}  // end of if 
			
	} // end of function LargestAmongThree
	
	public static void main(String[] args) {
		System.out.println("largest is "+LargestAmongThree(4,2,5));
		System.out.println("largest is "+LargestAmongThree(1,3,-5));
	}

}
