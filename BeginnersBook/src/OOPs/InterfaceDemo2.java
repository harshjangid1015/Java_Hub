package OOPs;
//we have two interfaces Inf1 and Inf2. Inf2 extends Inf1 so If class implements the Inf2 it has to provide implementation of all the methods of interfaces Inf2 as well as Inf1.

interface Inf1{
	public void method1();
}
interface Inf2 extends Inf1 {
	public void method2();
}

public class InterfaceDemo2 implements Inf2 {
	/* Even though this class is only implementing the
	 * interface Inf2, it has to implement all the methods 
	 * of Inf1 as well because the interface Inf2 extends Inf1
	 */
	public void method1(){
		System.out.println("method1");
	}
	public void method2(){
		System.out.println("method2");
	}
	public static void main(String args[]){
		Inf2 obj = new InterfaceDemo2();
		obj.method2();
		obj.method1();
	}
}
