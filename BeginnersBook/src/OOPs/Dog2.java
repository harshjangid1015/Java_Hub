package OOPs;
//Abstract class Example

//abstract parent class
abstract class Animal2{
	//abstract method
	public abstract void sound();
}
//Dog class extends Animal class

public class Dog2 extends Animal2 {
	public void sound(){
		System.out.println("Woof");
	}
	public static void main(String args[]){
		Animal2 obj = new Dog2();
		obj.sound();
	}
}
