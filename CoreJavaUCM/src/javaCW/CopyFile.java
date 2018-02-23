package javaCW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void main(String[] args) {
		int i;
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		//  making sure that both files has been specified
		if(args.length != 2) {
			System.out.println("Usage: CopyFile from to");
			return;
		}
		
		try {
			fin = new FileInputStream(args[0]);
			fout = new FileOutputStream(args[1]);
			
			do {
				i = fin.read();
				if (i != -1) 
					System.out.print((char)i);
					fout.write(i);
			}
			while(i != -1);
			fin.close();
			fout.close();
		}
		catch (FileNotFoundException exc) {
			System.out.println("FileNotFoundException happened - ignored");
		}
		catch (IOException exc) {
			System.out.println("IOException happened - ignored");
		}

	}

}
