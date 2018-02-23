package OOPs;

class ParentClass{
	//Parent class constructor
	ParentClass(){
		System.out.println("Constructor of Parent");
	}
	void disp(){
		System.out.println("Parent Method");
	}
}

public class InheritanceAndMethodOverriding extends ParentClass {
	InheritanceAndMethodOverriding(){
		System.out.println("Constructor of Child");
	}
	void disp(){
		System.out.println("Child Method");
		//Calling the disp() method of parent class
		super.disp();
	}
	public static void main(String args[]){
		//Creating the object of child class
		InheritanceAndMethodOverriding obj = new InheritanceAndMethodOverriding();
		obj.disp();
	}
}
