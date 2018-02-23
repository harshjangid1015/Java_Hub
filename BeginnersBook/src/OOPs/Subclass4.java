package OOPs;
//use super keyword in case of method overriding
class Parentclass4
{
	//Overridden method
	void display(){
		System.out.println("Parent class method");
	}
}

public class Subclass4 extends Parentclass4{
	//Overriding method
	void display(){
		System.out.println("Child class method");
	}
	void printMsg(){
		//This would call Overriding method
		display();
		//This would call Overridden method
		super.display();
	}
	public static void main(String args[]){		
		Subclass4 obj= new Subclass4();
		obj.printMsg(); 
	}
}

