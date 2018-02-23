package cs4120;
//Exercise 19.3
import java.util.ArrayList;
import java.util.Random;

public class DistinctElementsInArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<>(100);

		Random rand = new Random();
		for (int i = 0; i<100; i++) {
			intList.add(rand.nextInt(10));
		}
		System.out.println("Original intList: "+ intList);

		ArrayList<Integer> newIntList = new ArrayList<Integer>();
		newIntList = removeDuplicates(intList);
		System.out.println("new intList: "+ newIntList);
		System.out.println();

		ArrayList<Character> charList = new ArrayList<>(100);
		for (int i = 0; i<100; i++) {
			charList.add((char)(97 + rand.nextInt(26)));
		}
		System.out.println("Original charList: "+ charList);

		ArrayList<Character> newCharList = new ArrayList<>();
		newCharList = removeDuplicates(charList);
		System.out.println("new charList: " + newCharList);

	}
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> newList = new ArrayList<>(list.size());

		for(int i = 0; i < list.size(); i++) {
			if(!newList.contains(list.get(i))) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}
}
