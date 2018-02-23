package OOPs;
//Dynamic binding example

class Human3{
	//Overridden Method
	public void walk()
	{
		System.out.println("Human walks");
	}
}
public class Boy3 extends Human3 {
	//Overriding Method
	public void walk(){
		System.out.println("Boy walks");
	}
	public static void main( String args[]) {
		/* Reference is of Human type and object is
		 * Boy type
		 */
		Human3 obj = new Boy3();
		/* Reference is of HUman type and object is
		 * of Human type.
		 */
		Human3 obj2 = new Human3();
		obj.walk();
		obj2.walk();
	}
}
