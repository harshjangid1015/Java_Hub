package javaCW;

public class recusrsionDemo {
	static int factorial(int n) {
		System.out.println("factorial: "+n);
		if(n==1) return 1;
		int res = n*factorial(n-1);
		System.out.println("res: "+res);
		return res;
	}
	
	static int fib(int n) {
		System.out.println("fib: "+n);
		if(n<3) return 1;
		return fib(n-1)+fib(n-2);
	}
	
	static int sumUpto(int n) {
		//sum from 1 through n
		if(n==1) return 1;
		return n + sumUpto(n-1);
//		int sum = 0;
//		for (int i=1; i<=n; i++) {			
//			System.out.println(i);
//			sum += i;
//			}				
//		return sum;
	}
	
	static int sumFromTo(int a, int b) {
		//sum from a to b inclusively
//		if(a==b) return a; // or b
		if(a>b) return 0;
		return a + sumFromTo(a+1, b);
		
//		return sumUpto(b) - sumUpto(a-1);
		
//		int sum=0;
//		for (int i= a; i<=b; i++) {
//			System.out.println(i);
//			sum +=i;
//			}
//		return sum;			
	}
	
//	public void printAlphabetsTo(char ch) 
		// print from 'A' to ch
		//for example, printAlphabetsTo('C') will print "ABC"
		// do it iteratively(using loop) and recursively
		
		static char printAlphabetsToIteratively(char ch) {
			for (char alphabet = 'A'; alphabet < ch; alphabet++) {
			    System.out.print(alphabet);
			}
			return ch;
		}

		
		static void printAlphabetsTo(char ch){			
			if(ch == 'A'){
				System.out.print(ch);
			}
			else{ 
				 printAlphabetsTo((char)(ch - 1));
				 System.out.print((char)(ch));
			}
		}
		
	
	public static void main(String[] args) {
//		System.out.println("factorial(4): "+ factorial(4));
//		System.out.println("fib(4): "+fib(4));
		System.out.println("sumUpto(4): "+ sumUpto(4));
//		System.out.println("sumFromTo(2, 4): "+ sumFromTo(2, 4));
		System.out.println(printAlphabetsToIteratively('H'));
		printAlphabetsTo('K');
	}
}
