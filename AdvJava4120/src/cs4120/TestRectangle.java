package cs4120;

import java.util.Arrays;

public class TestRectangle {
	public static void main(String[] args) {
		Rectangle[] array = new Rectangle[100];
		
		for (int i = 0; i < array.length; i++) 
		{
			array[i] = new Rectangle((int)(Math.random()*10), ((int)Math.random()*10));
		}
		
		Arrays.sort(array);
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array[i].toString());
		}
	}

}
