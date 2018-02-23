package cs4120;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class TexterServer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Server started");
		try {
		ServerSocket  serverSocket = new ServerSocket(8000);
		
		System.out.println("server waiting for client");
		
		Socket socket = serverSocket.accept();
		
		System.out.println("client conncted to server");
		
		ObjectInputStream  inputFromClient = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
		
		while(true) {
			
			String message = (String)inputFromClient.readObject();
			
			System.out.println("Client: " +message );
			
			System.out.println("Enter a message: ");
			
			message = input.nextLine();
			
			outputToClient.writeObject(message);
			
		}}catch(Exception ex) {System.out.println(ex);}
	}

}
