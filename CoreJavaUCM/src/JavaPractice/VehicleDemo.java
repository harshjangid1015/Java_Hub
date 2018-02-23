package JavaPractice;

class Vehicle{
	int passengers;
	int fuelcap;
	int mpg;
	
	Vehicle(int p, int f, int m){
		passengers = p;
		fuelcap = f;
		mpg = m;
	}
	int range() {
		return fuelcap*mpg;
	}
}

public class VehicleDemo {
	public static void main(String[] args) {
		Vehicle car1 = new Vehicle(7,20,10);
		Vehicle car2 = new Vehicle(2,10,15);
		Vehicle car3 = new Vehicle(2,10,12);
		
		System.out.println("car1 range = "+car1.range());
		System.out.println("car2 range = "+car2.range());
		System.out.println("car3 range = "+car3.range());
		car2.mpg = car3.mpg;
		car1 = car2;
		System.out.println("car1 range = "+car1.range());
		System.out.println("car2 range = "+car2.range());
		System.out.println("car3 range = "+car3.range());

		
		if (car2.equals(car3))
			System.out.println("car2 and car3 are same");
		else
			System.out.println("car2 and car3 are different");
		
	}

}
