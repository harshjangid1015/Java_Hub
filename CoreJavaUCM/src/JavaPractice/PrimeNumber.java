package JavaPractice;

public class PrimeNumber {
	static boolean isPrime(int n) {
		for (int i=2;i<n;i++)
			if(n%i==0)
				return false;
		return true;				
	}
	public static void main(String[] args) {
		int i;
		int maxNum = 100;
		
		for(int num=2; num<maxNum; num++) {
			if(isPrime(num)) System.out.println(num+" is a prime number.");
			else System.out.println(num+"is NOT a prime number.");
		}
	}

}
