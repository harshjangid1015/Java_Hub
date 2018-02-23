package cs4120;
import java.io.*;
import java.net.*;

public class AreaServer {
	public static void main(String[] args) {
		System.out.println("Server started");
		int port = 8000;
		try {
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("waiting for client");
		
		Socket socket = serverSocket.accept();
		System.out.println("");
		
		DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
		DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			double radius = inputFromClient.readDouble();
			System.out.println("Received radius "+ radius);
			
			double area = radius*radius*Math.PI;
			outputToClient.writeDouble(area);
			
			System.out.println();
			
		}
		}
		catch(IOException ex) {}
	}
}
