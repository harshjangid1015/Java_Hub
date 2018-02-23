package cs4120;

import java.util.Random;
import java.util.concurrent.*;

/*30.13 (Generic parallel merge sort) Revise Listing 30.10, ParallelMergeSort.java, to
define a generic parallelMergeSort method as follows:
public static <E extends Comparable<E>> void parallelMergeSort(E[] list) */
public class GenericParallelMergeSort {
	public static void main(String[] args) {
		int size = 2000;
		Integer[] intArray = new Integer[size];


		for(int i=0; i<size; i++) {
			intArray[i] = (int)(Math.random()*1000);
		}
		System.out.print("Integer Array List: " );
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + ", ");
		}
		System.out.println();
		parallelMergeSort(intArray);
		System.out.print("Sorted Integer Array List: " );
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + ", ");
		}

		System.out.println();
		System.out.println();
		//Generating random strings
		Random rand = new Random();
		String Alphabets = "abcdefghijklmnopqrstuvwxyz";
		String[] strArray = new String[size];
		for(int i = 0; i < strArray.length; i++) {
			String Str1 = "";
			int randStrLen = 5;
			for(int j = 0; j<randStrLen; j++) {
				char c = Alphabets.charAt(rand.nextInt(26));
				Str1 = Str1 + c;
				strArray[i] =  Str1;
			}
		}

		//print string array
		System.out.print("Random String Array List: " );
		for (int i = 0; i < size; i++) {
			System.out.print(strArray[i] + ", ");
		}
		System.out.println();
		parallelMergeSort(strArray);
		System.out.print("Sorted String Array List: " );
		for (int i = 0; i < size; i++) {
			System.out.print(strArray[i] + ", ");
		}

	}

	public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
		RecursiveAction mainTask = new sortTask<E>(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);
	}

	private static class sortTask <E extends Comparable<E>> extends RecursiveAction {
		private E[] list;
		private int Threshold = 500;
		public sortTask(E[] list) {
			this.list = list;			
		}

		@Override
		protected void compute() {
			if(list.length < Threshold) {
				java.util.Arrays.sort(list);
			}
			else {
				//obtain the first part
				E[] firstHalf = (E[])(new Comparable[list.length/2]);
				System.arraycopy(list, 0, firstHalf, 0, list.length/2);

				//obtain the second half
				int secondHalfLength = list.length - list.length/2;
				E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
				System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);

				//Recursively sort the two halves
				invokeAll(new sortTask(firstHalf), new sortTask(secondHalf));

				//Merge first half with second half into list

				merge(firstHalf, secondHalf, list);
			}

		}
		public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
			int current1 = 0; // Current index in list1
			int current2 = 0; // Current index in list2
			int current3 = 0; // Current index in temp

			while (current1 < list1.length && current2 < list2.length) {
				if (list1[current1].compareTo(list2[current2]) < 0 )
					temp[current3++] = list1[current1++];
				else
					temp[current3++] = list2[current2++];
			}

			while (current1 < list1.length)
				temp[current3++] = list1[current1++];

			while (current2 < list2.length)
				temp[current3++] = list2[current2++];
		}

	}
}
