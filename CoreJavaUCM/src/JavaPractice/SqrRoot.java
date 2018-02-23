package JavaPractice;
//show the square roots of 1 to 99 and the rounding error
public class SqrRoot {
	public static void main(String[] args) {
		double num, sroot, rerr;
		for(num=1; num<100; num++) {
			sroot = Math.sqrt(num);
			System.out.println("Square root of "+num+" is "+sroot);
			
			//computing error
			rerr = num - (sroot*sroot);
			System.out.println("Rounding error is "+rerr);
			System.out.println();
		}
	}
}
