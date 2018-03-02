package cs4120;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class MultithreadedAreaServer {
	public static void main(String[] args) {
		try {
			int clientID = 1;
			int port = 8000;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server started");
			
			while(true) {
				Socket socket  = serverSocket.accept();
				
				System.out.println("Client " +clientID+ " connected");
				HandleClientTask task = new HandleClientTask(socket, clientID);
				
				Thread thread = new Thread(task);
				thread.start();
				clientID++;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
class HandleClientTask implements Runnable{
	private Socket socket;
	private int id;
	
	HandleClientTask(Socket socket, int id){
		this.socket = socket;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				double radius = inputFromClient.readDouble();
				
				System.out.println("Received radius " + radius + "from client " + this.id);
				
				double area = radius*radius*Math.PI;
				
				outputToClient.writeDouble(area);
				
				System.out.println("sent area "+ area + " to clent " + this.id);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
}
