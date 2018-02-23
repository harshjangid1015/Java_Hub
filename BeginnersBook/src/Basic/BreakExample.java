package Basic;

public class BreakExample {
	public static void main(String[] args) {
		int num = 0;
		while (num <=100) {
			System.out.println("value of the variable num is: "+num);
			if(num == 4) {
				break;
			}
			num++;
		}
		System.out.println("out of the while loop");
	}
}
