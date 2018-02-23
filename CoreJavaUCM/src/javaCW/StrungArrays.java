package javaCW;

public class StrungArrays {
	public static void main(String[] args) {
		String strs[] = {"This", "is", "a", "test."};
		
		System.out.println("Original array: ");
		for(String s : strs)
			System.out.print(s + " ");
		System.out.println("\n");
		
		strs[1] = "was";
		strs[3] = "test, tool";
		
		System.out.println("Modified array: ");
		for(String s : strs)
			System.out.print(s + " ");
	}

}
