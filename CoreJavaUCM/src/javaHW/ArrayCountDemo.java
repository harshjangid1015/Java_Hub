package javaHW;

public class ArrayCountDemo {
	public static int arrayCount(int[] A, int minN, int maxN) {

		int count = 0;
		for(int i=0; i<A.length; i++) {
			if (A[i]>= minN && A[i]<=maxN) {
				count++;
			}
			
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println("the count is "+ arrayCount(new int[] {1}, -1, 5));
		System.out.println("the count is "+ arrayCount(new int[] {-1, 5}, -1, 5));
		System.out.println("the count is "+ arrayCount(new int[] {1, -1, 2, 4}, -1, 5));
		System.out.println("the count is "+ arrayCount(new int[] {1, -1, 12, 4}, -1, 5));
	}

}
