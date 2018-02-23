package javaCW;

public class ArrayDemo {
	public static void main(String[] args) {
		int sample[] = new int[20];
		int i;
		
		for (i=0; i<sample.length; i=i+1)
			sample[i]=i;
				
		for (i = 0; i<sample.length; i=i+1)
			System.out.println("This is sample(" + i + "): "+ sample[i]);
	}

}
