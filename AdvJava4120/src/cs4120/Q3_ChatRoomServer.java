package cs4120;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Q3_ChatRoomServer extends Application{

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		
		TextField inputTextField = new TextField();
		
		Button send = new Button("SEND");
		HBox hBox = new HBox();
		hBox.getChildren().add(inputTextField);
		hBox.getChildren().add(send);
		
		
		borderPane.setBottom(hBox);
		Scene scene = new Scene(borderPane, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ChatRoomServer");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

//	public static void main(String[] args) {
//		try {
//			int clientID = 1;
//			int port = 8000;
//			ServerSocket serverSocket = new ServerSocket(port);
//			System.out.println("Server started");
//
//			while(true) {
//				Socket socket  = serverSocket.accept();
//				System.out.println("Client " +clientID+ " connected");
//
//				ReadFromClientThread readTask = new ReadFromClientThread(socket, clientID);
//				WriteToServertThread writeTask = new WriteToServertThread(socket, clientID);
//				//				HandleClientTask task = new HandleClientTask(socket, clientID);
//
//				Thread thread1 = new Thread(readTask);
//				Thread thread2 = new Thread(writeTask);
//				thread1.start();
//				thread2.start();
//				clientID++;
//			}
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//	}

}
class ReadFromClientThread implements Runnable{
	private Socket socket;
	private int id;

	ReadFromClientThread(Socket socket, int id){
		this.socket = socket;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
			//			ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());

			while(true) {

				String message = (String) inputFromClient.readObject();
				System.out.println("Client: " + message);
				//				double radius = inputFromClient.readDouble();
				//				
				//				System.out.println("Received radius " + radius + "from client " + this.id);
				//				
				//				double area = radius*radius*Math.PI;
				//				
				//				outputToClient.writeDouble(area);
				//				
				//				System.out.println("sent area "+ area + " to clent " + this.id);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}	
	}	
}
class WriteToServertThread implements Runnable{
	private Socket socket;
	private int id;

	WriteToServertThread(Socket socket, int id){
		this.socket = socket;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
			Scanner input = new Scanner(System.in);
			while(true) {
				//				String message = input.next();
				String message = input.nextLine();
				//				System.out.println("Server: " + message);
				outputToClient.writeObject(message);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}	
	}	
}
