package Basic;

public class EnhancedForloop {
	public static void main(String[] args) {
		int arr[] = {2, 11, 45, 9};
		String arr2[] = {"hi", "hello", "bye"};
		
		for(int num : arr) {
			System.out.println(num);
		}
		
		for(String str : arr2) {
			System.out.println(str);
		}
	}
}
