package javaCW;

public class ExcDemo {
	public static void main(String[] args) {
		int numbers[] = {10, 20, 30, 40, 50};
		int denum[] = {2, 2, 2, 0, 2};
		
		for (int i=0; i<= numbers.length; i++ ) {
			try {
				System.out.println("numbers[i]/denum[i] "+numbers[i]/denum[i]);
			}
			catch (ArrayIndexOutOfBoundsException exc) {
				System.out.println("Index OutOFBound happened - ignored");
			}
			catch (ArithmeticException exc) {
				System.out.println("Airthmatic exception happened - ignored");
			}
			// for every exception
//			catch(Throwable exc) {
//				System.out.println("some exception happened - ignored");
//			}
		}
		System.out.println("Done.");
	}

}
