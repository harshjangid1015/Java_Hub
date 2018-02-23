package JavaPractice;

public class BoolDemo {
	public static void main(String[] args) {
		boolean b;
		
		b = false;
		System.out.println("b is "+b);
		b = true;
		System.out.println("b is "+b);
		
		if (b) {
			System.out.println("This is excuted");
		}
		
		b= false;
		if (b) {
			System.out.println("this is not excuted");
		}
		
		
	}

}
