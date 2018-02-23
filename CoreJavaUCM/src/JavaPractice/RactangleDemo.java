package JavaPractice;

class Ractangle{
	double height;
	double width;
	
	Ractangle(double h, double w){
		height = h;
		width = w;
	}
	double area() {
		return height*width;
	}
	double perimeter() {
		return 2*(height+width);
	}
}

public class RactangleDemo {
	public static void main(String[] args) {
		Ractangle rec1 = new Ractangle(3,4);
		Ractangle rec2 = new Ractangle(2,5);
		Ractangle rec;
		
				
		System.out.println("rec1: area="+rec1.area() + ", perimeter="+rec1.perimeter());
		System.out.println("rec2: area="+rec2.area() + ", perimeter="+rec2.perimeter());
		rec = rec1;
		rec.height = 5;
		rec = rec2;
		rec.width = 10;
		System.out.println("rec1: area="+rec1.area() + ", perimeter="+rec1.perimeter());
		System.out.println("rec2: area="+rec2.area() + ", perimeter="+rec2.perimeter());
		
//		System.out.println(rec1);
//		System.out.println(rec2);
//		System.out.println(rec);
				
		System.out.println(rec==rec1);
		System.out.println(rec==rec2);
	}

}
