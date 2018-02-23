package OOPs;
//Example of Abstract class and method

abstract class MyClass{
	public void disp() {
		System.out.println("Concrete method of parent class");
	}
	abstract public void disp2();
} 
public class AbstractDemo extends MyClass {
	/* Must Override this method while extending
	 * MyClas
	 */
	public void disp2()
	{
		System.out.println("overriding abstract method");
	}
	public static void main(String args[]){
		AbstractDemo obj = new AbstractDemo();
		obj.disp2();
	}
}
