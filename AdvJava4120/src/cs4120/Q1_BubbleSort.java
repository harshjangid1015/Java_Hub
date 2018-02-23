package cs4120;

/*Create a generic bubble sort method. Refer to Exercise 7.18 in the textbook for a description of
the sorting algorithm. Your method must be able to sort an array of any type of objects that
implements the Comparable interface. The method is also to have a Boolean parameter called
isAscending to indicate whether the array is to be sorted in ascending or descending order.
Create a main method that creates an array of 1000 integers. The integers are to be randomly
selected, ranging from 0 to 99, inclusive. Also create an array of 1000 strings. The strings are to
be randomly generated, consisting of only lowercase letters, and ranging in a randomly selected
length from 1 to 10 characters. Display the contents of both arrays before sorting, after sorting in
ascending order, and after sorting in descending order.
 * */

public class Q1_BubbleSort {
	public static void main(String[] args) {
		//Random Integers
		int size = 1000;
		Integer[] randIntArray = new Integer[size];
		for(int i=0; i<randIntArray.length; i++) {
			randIntArray[i] = (int) (Math.random()*100);
		}
		//Printing Random integer array
		System.out.print("Random integer array: ");
		for(int i=0; i<randIntArray.length; i++) {
			System.out.print(randIntArray[i] + ", ");
		}
		System.out.println();
		//sorting in Ascending order		
		bubbleSort(randIntArray, true);
		//Printing Random integer array
		System.out.print("Sorted integer array: ");
		for(int i=0; i<randIntArray.length; i++) {
			System.out.print(randIntArray[i] + ", ");
		}
		System.out.println();
		//sorting in Descending order		
		bubbleSort(randIntArray, false);
		//Printing Random integer array
		System.out.print("Descending Sorted array: ");
		for(int i=0; i<randIntArray.length; i++) {
			System.out.print(randIntArray[i] + ", ");
		}
		
		
		
		
		System.out.println();
		System.out.println();
		//Random Strings
		String Alphabets = "abcdefghijklmnopqrstuvwxyz";
		String[] randStrArray = new String[size];
		for(int i=0; i<randStrArray.length; i++) {
			String tempStr = ""; 
			int strLen = (int)(1+ Math.random()*10);
			for(int j=0; j<strLen; j++) {
				char c = Alphabets.charAt((int) (Math.random()*26));
				tempStr += c;
				randStrArray[i] = tempStr;
			}
		}
		//Printing Random String array
		System.out.print("Random String array: ");
		for(int i=0; i<randStrArray.length; i++) {
			System.out.print(randStrArray[i] + ", ");
		}
		System.out.println();
		//sorting & printing
		bubbleSort(randStrArray, true);
		System.out.print("Sorted String array: ");
		for(int i=0; i<randStrArray.length; i++) {
			System.out.print(randStrArray[i] + ", ");
		}
		
		System.out.println();
		//sorting in Descending order		
		bubbleSort(randStrArray, false);
		//Printing Random integer array
		System.out.print("Descending Sorted array: ");
		for(int i=0; i<randStrArray.length; i++) {
			System.out.print(randStrArray[i] + ", ");
		}
		

	}

	public static <E extends Comparable<E>>void bubbleSort(E[] list, boolean AscOrDesc) {
		boolean change;
		boolean isAscending = AscOrDesc;
				
		if (isAscending == true) {
			do {
				change = false;
				for (int i = 0; i < list.length - 1; i++) {
					//if(list[i] >= list[i+1]) {
					if (list[i].compareTo(list[i + 1]) > 0) {
						E temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;
						change = true;
					}
				}
			} while (change);
		}
		else if(isAscending == false){
			do {
				change = false;
				for (int i = 0; i < list.length - 1; i++) {
					//if(list[i] >= list[i+1]) {
					if (list[i].compareTo(list[i + 1]) < 0) {
						E temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;
						change = true;
					}
				}
			} while (change);
		}
	}

}
