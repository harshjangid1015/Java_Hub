package OOPs;
//Dynamic Polymorphism Example
class Animal{
	public void animalSound(){
		System.out.println("Default Sound");
	}
}
public class Dog extends Animal{

	public void animalSound(){
		System.out.println("Woof");
	}
	public static void main(String args[]){
		Animal obj = new Animal();
		obj.animalSound();
		// This would call the Animal class method

		Dog obj2 = new Dog();
		obj2.animalSound();
		// This would call the Dog class method

		Animal obj3 = new Dog();
		obj3.animalSound();
		// This would call the Dog class method
	}
}
