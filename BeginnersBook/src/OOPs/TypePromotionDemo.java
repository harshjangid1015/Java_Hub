package OOPs;
//As you can see that I have passed the float value while calling the disp() method but it got promoted to the double type as there wasn’t any method with argument list as (int, float)

public class TypePromotionDemo {
	void disp(int a, double b){
		System.out.println("Method A");
	}
	void disp(int a, double b, double c){
		System.out.println("Method B");
	}
	public static void main(String args[]){
		TypePromotionDemo obj = new TypePromotionDemo();
		/* I am passing float value as a second argument but
		 * it got promoted to the type double, because there
		 * wasn't any method having arg list as (int, float)
		 */
		obj.disp(100, 20.67f);
	}
}
