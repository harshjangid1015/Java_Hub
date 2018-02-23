package JavaPractice;

public class GalToLitTable {
	public static void main(String[] args) {
		double g;
		double l=1;
		
//		g = 3.7854*l;
		for(g=1;g<=30;g++) {
			l=g*3.7854;
			System.out.println(g+" gallons is "+l+" liters.");
			if (g%10==0) {
				System.out.println();
				
			}
		}
	}

}
