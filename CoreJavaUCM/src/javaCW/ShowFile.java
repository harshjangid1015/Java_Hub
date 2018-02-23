package javaCW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
	public static void main(String[] args) throws IOException {
		int i;
		FileInputStream fin;

//		fin = new FileInputStream(".project");
		fin = new FileInputStream(args[0]);
		// can also print class file (used- bin\javaCW\ArrayDemo.class )
		
		do {
			i = fin.read();
			if (i != 1) System.out.print((char)i);
		}while(i != -1);
		fin.close();
	}

}
