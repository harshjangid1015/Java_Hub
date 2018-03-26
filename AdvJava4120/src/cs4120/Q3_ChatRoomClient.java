package cs4120;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Q3_ChatRoomClient extends Application {

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
		primaryStage.setTitle("ChatRoomClientr");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

//	public static void main(String[] args) {
//		
//		try {
//			Socket socket = new Socket("localhost", 8000);
//			System.out.println("client connected to server");
//			
//			ReadFromServerThread readTask = new ReadFromServerThread(socket);
//			WriteToServerThread writeTask = new WriteToServerThread(socket);
//			
//			Thread thread1 = new Thread(readTask);
//			Thread thread2 = new Thread(writeTask);
//			
//			thread1.start();
//			thread2.start();
//			
//		}catch (Exception ex) {
//			System.out.println(ex);
//		}
//	}
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
//				System.out.println("Client: " + message);
				outputToServer.writeObject(message);
				
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
}
