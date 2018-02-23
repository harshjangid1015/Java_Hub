package OOPs;

public class ConstructorExample {
	String name;
	int age;
	
	//Default Constructor
	ConstructorExample(){
		this.name = "Harsh";
		this.age = 30;
	}
	
	//Parameterized constructor
	ConstructorExample(String n, int a){
		this.name = n;
		this.age = a;
	}
	public static void main(String[] args) {
		ConstructorExample obj1 = new ConstructorExample();
		ConstructorExample obj2 = new ConstructorExample("Chaitanya", 28);
		
		System.out.println(obj1.name + " " + obj1.age);
		System.out.println(obj2.name + " " + obj2.age);
	}
}
