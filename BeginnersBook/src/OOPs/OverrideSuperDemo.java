package OOPs;
//Super keyword in Method Overriding
class ABC2{
	public void myMethod()
	{
		System.out.println("Overridden method");
	}	   
}
public class OverrideSuperDemo extends ABC2{
	public void myMethod(){
		//This will call the myMethod() of parent class
		super.myMethod();
		System.out.println("Overriding method");
	}
	public static void main( String args[]) {
		OverrideSuperDemo obj = new OverrideSuperDemo();
		obj.myMethod();
	}
}
