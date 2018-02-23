package cs4120;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AreaClient {
	public static void main(String[] args) {
		//clent started
		System.out.println("client started");
		Scanner input = new Scanner(System.in);
		
		int port = 8000;
		Socket socket = null;
		try {
			socket = new Socket("localhost", port);
		
		System.out.println("Enter ");
		
		
		DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
		DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			System.out.println("Enter a radius ");
			double radius = input.nextDouble();
			System.out.println("radius entered: " + radius);
			
			outputToServer.writeDouble(radius);
			
			double area = inputFromServer.readDouble();

			System.out.println("Area: " + area);		
			
		}
		}
		catch(IOException ex ){
			ex.printStackTrace();
		}

	}
}
