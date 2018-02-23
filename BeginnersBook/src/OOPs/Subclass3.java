package OOPs;
//Parameterized super() call to invoke parameterized constructor of parent class
class Parentclass3
{
	//no-arg constructor
	Parentclass3(){
		System.out.println("no-arg constructor of parent class");
	}
	//arg or parameterized constructor
	Parentclass3(String str){
		System.out.println("parameterized constructor of parent class");
	}
}

public class Subclass3 extends Parentclass3{
	Subclass3(){
		/* super() must be added to the first statement of constructor 
		 * otherwise you will get a compilation error. Another important 
		 * point to note is that when we explicitly use super in constructor
		 * the compiler doesn't invoke the parent constructor automatically.
		 */
		super("Hahaha");
		System.out.println("Constructor of child class");

	}
	void display(){
		System.out.println("Hello");
	}
	public static void main(String args[]){		
		Subclass3 obj= new Subclass3();
		obj.display();	 
	}
}
