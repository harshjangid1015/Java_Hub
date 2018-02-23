package cs4120;
//Exercise 19.5
import java.util.Random;

public class MaxElementInArray {
	public static void main(String[] args) {
		Integer[] intList = new Integer[100];		
		Random rand = new Random();
		for (int i = 0; i<intList.length; i++) {
			intList[i] = rand.nextInt(10001);
		}
		System.out.print("Original intList: ");
		for (int i = 0; i<intList.length; i++) {
			System.out.print(intList[i] + ", ");
		}
		System.out.println();
		System.out.println("MaxIntElement: "+ MaxElementInArray.max(intList));
		System.out.println();
		
		Double[] doubList = new Double[100];
		for (int i = 0; i<doubList.length; i++) {
			doubList[i] = rand.nextDouble();
		}
		System.out.print("Original doubList: ");
		for (int i = 0; i<doubList.length; i++) {
			System.out.print(doubList[i] + ", ");
		}
		System.out.println();
		System.out.println("MaxDoubElement: "+ MaxElementInArray.max(doubList));
	}
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for(int i = 0; i<list.length; i++) {
			if(list[i].compareTo(max) > 0) {
				max = list[i];
			}
		}
		return max;
	}
	
}