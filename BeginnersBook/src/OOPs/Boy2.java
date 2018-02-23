package OOPs;
//Static binding example
class Human2{
	public static void walk()
	{
		System.out.println("Human walks");
	}
}
public class Boy2 extends Human2{
	public static void walk(){
		System.out.println("Boy walks");
	}
	public static void main( String args[]) {
		/* Reference is of Human type and object is
		 * Boy type
		 */
		Human2 obj = new Boy2();
		/* Reference is of HUman type and object is
		 * of Human type.
		 */
		Human2 obj2 = new Human2();
		obj.walk();
		obj2.walk();
	}
}
