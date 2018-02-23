package javaHW;

public class StringDemo {
	public static String stringMerge(String[] words) {
		for(int i=0; i<words.length; i++) {
//			return words[i];
			System.out.print(words[i]+"");
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(stringMerge(new String[] {"Hi", "Guys"}));
		System.out.println(stringMerge(new String[] {"A","-", "Z", "abc"}));
	}

}
