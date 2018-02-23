package OOPs;
// Overloading – Different Number of parameters in argument list
class DisplayOverloading1
{
	public void disp(char c)
	{
		System.out.println(c);
	}
	public void disp(char c, int num)  
	{
		System.out.println(c + " "+num);
	}
}

public class MethodOverloading {
	public static void main(String args[])
	{
		DisplayOverloading1 obj = new DisplayOverloading1();
		obj.disp('a');
		obj.disp('a',10);
	}
}
