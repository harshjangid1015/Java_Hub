package OOPs;
interface A
{
	int x=10;
}
interface B
{
	int x=100;
}

public class Interfacedemo3 implements A, B {
	public static void Main(String args[])
	{
		/* reference to x is ambiguous both variables are x
		 * so we are using interface name to resolve the 
		 * variable
		 */
		//System.out.println(x); 	error- ambiguous
		System.out.println(A.x * 5);
		System.out.println(B.x);
	}
}
