package javaCW;

class Vehicle{
	int passengers;
	int fuelcap;
	private int mpg;

	Vehicle(int p, int f, int m){
		passengers = p;
		fuelcap = f;
		mpg = m;
	}
	Vehicle(){
		
	}
	int range(){ return fuelcap*mpg;}
	int getMPG() {return mpg;}
	void setMPG(int mpg) {this.mpg=mpg;}
}

public class VehicleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle car1 = new Vehicle(7,20,10);
		Vehicle car2 = new Vehicle(2,10,15);
		Vehicle car3 = new Vehicle(2,10,12);

		System.out.println("car1 range = "+car1.range());
		System.out.println("car2 range = "+car2.range());
		System.out.println("car3 range = "+car3.range());
		car2.setMPG(car3.getMPG());
		car1 = car2;
		System.out.println("car1 range = "+car1.range());
		System.out.println("car2 range = "+car2.range());
		System.out.println("car3 range = "+car3.range());
		if (car2 == car3)
			System.out.println("car2 and car3 are the same");
		else
			System.out.println("car2 and car3 are different");
	}
}