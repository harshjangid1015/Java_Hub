package JavaPractice;
//Find all prime numbers between 2 and 100
public class PrimeNumbers {
	public static void main(String[] args) {
		System.out.println("Prime numbers are: ");
		for (int n=2;n<=100;n++) {
			boolean isPrime = true;
			for (int i=2;i<n;i++) {
				if (n%i==0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(n+",");
			}
		}
	}
}
