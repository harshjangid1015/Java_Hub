package Basic;

public class DoWhileLoopExample {
	public static void main(String[] args) {
		int arr[] = {2, 11, 45, 9};
		
		int i = 0;
		do {
			System.out.println(arr[i]);
			i++;
		}while(i<arr.length);
	}
}
