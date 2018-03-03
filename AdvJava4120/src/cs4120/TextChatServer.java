package cs4120;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;;

public class TextChatServer {
	public static void main(String[] args) {
		try {
			
			int port = 8000;			
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server started");
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("client connected");
				
				ReadFromClientThread readTask = new ReadFromClientThread(socket);
				WriteToServertThread writeTask = new WriteToServertThread(socket);
				
				Thread thread1 = new Thread(readTask);
				Thread thread2 = new Thread(writeTask);
				
				thread1.start();
				thread2.start();
			}
			
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

class ReadFromClientThread implements Runnable{
	private Socket socket;
	
	public ReadFromClientThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
			while(true) {
				String message = (String)inputFromClient.readObject();
				System.out.println("Client: " + message);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
}

class WriteToServertThread implements Runnable{
	private Socket socket;
	
	public WriteToServertThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
			Scanner input = new Scanner(System.in);
			while(true) {
				String message = input.nextLine();
				outputToClient.writeObject(message);
				
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
}
