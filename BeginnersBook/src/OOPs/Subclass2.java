package OOPs;
//Use of super keyword to invoke constructor of parent class
class Parentclass2
{
	Parentclass2(){
		System.out.println("Constructor of parent class");
	}
}

public class Subclass2 extends Parentclass2 {
	Subclass2(){
		/* Compile implicitly adds super() here as the
		 *  first statement of this constructor.
		 */
		System.out.println("Constructor of child class");
	}
	Subclass2(int num){
		/* Even though it is a parameterized constructor.
		 * The compiler still adds the no-arg super() here
		 */
		System.out.println("arg constructor of child class");
	}
	void display(){
		System.out.println("Hello!");
	}
	public static void main(String args[]){
		/* Creating object using default constructor. This 
		 * will invoke child class constructor, which will 
		 * invoke parent class constructor
		 */
		Subclass2 obj= new Subclass2();
		//Calling sub class method 
		obj.display();
		/* Creating second object using arg constructor
		 * it will invoke arg constructor of child class which will
		 * invoke no-arg constructor of parent class automatically 
		 */
		Subclass2 obj2= new Subclass2(10);
		obj2.display();
	}
}
