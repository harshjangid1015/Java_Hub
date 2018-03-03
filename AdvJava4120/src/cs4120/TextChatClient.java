package cs4120;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TextChatClient {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 8000);
			System.out.println("client connected to client");
			
			ReadFromServerThread readTask = new ReadFromServerThread(socket);
			WriteToServerThread writeTask = new WriteToServerThread(socket);
			
			Thread thread1 = new Thread(readTask);
			Thread thread2 = new Thread(writeTask);
			
			thread1.start();
			thread2.start();
			
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

class ReadFromServerThread implements Runnable{
	private Socket socket;
	public ReadFromServerThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			ObjectInputStream inputFromServer = new ObjectInputStream(socket.getInputStream());
			while(true) {
				String message = (String)inputFromServer.readObject();
				System.out.println("Server: " + message);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
}

class WriteToServerThread implements Runnable{
	private Socket socket;
	public WriteToServerThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			ObjectOutputStream outputToServer = new ObjectOutputStream(socket.getOutputStream());
			Scanner input = new Scanner(System.in);
			while(true) {
				String message = input.nextLine();
				outputToServer.writeObject(message);
				
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
}
