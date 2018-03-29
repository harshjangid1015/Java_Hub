package cs4120;


import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Q3_ChatRoomServer extends Application {
	// Text area for displaying contents
	private TextArea ta = new TextArea();
	Button send = new Button("SEND");
	TextField inputTextField = new TextField();

	// Number a client

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(ta);

//		TextField inputTextField = new TextField();
//		Button send = new Button("SEND");
		HBox hBox = new HBox();
		hBox.getChildren().addAll(inputTextField, send);
		hBox.setAlignment(Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 400, 600);
		borderPane.setBottom(hBox);
		borderPane.setCenter(scrollPane);
		primaryStage.setTitle("MultiThreadServer"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		
		new Thread(()->{try {
			int clientID = 1;
			int port = 8000;
			ServerSocket serverSocket = new ServerSocket(port);
			Platform.runLater(() ->
			ta.appendText("Server started at " + new Date() + '\n'));
			while(true) {				
				Socket socket = serverSocket.accept();
				ta.appendText("Client " +clientID+ " connected"+ '\n');
				HandleClientTasks task = new HandleClientTasks(socket, clientID);
				Thread thread = new Thread(task);
				thread.start();
				clientID++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}}).start();
		
		
//		int clientID = 1;
//		new Thread( () -> {
//			int port = 8000;
//			try {
//				ServerSocket serverSocket = new ServerSocket(port);
//				ta.appendText("Server started at " + new Date() + '\n');
//				
//				 //Listen for a connection request
//				Socket socket = serverSocket.accept();
//				ta.appendText("server connected");
////				HandleClientTasks(socket, clientID);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		}).start();
		
		
//		int clientID = 1;
//		new Thread( () -> {
//			try {
//				
//				int port = 8000;
//				// Create a server socket
//				ServerSocket serverSocket = new ServerSocket(port);
//				Platform.runLater(() ->
//				ta.appendText("Server started at " + new Date() + '\n'));
//
//				// Listen for a connection request
//				Socket socket = serverSocket.accept();
//				ta.appendText("server connected");
//
//				// Create data input and output streams
//				ObjectInputStream  inputFromClient = new ObjectInputStream(socket.getInputStream());
//				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
//				while (true) {
//					
//					String	message = (String)inputFromClient.readObject();
//					ta.appendText("Client: "+message + '\n');
//					
//					send.setOnAction(event -> {						
//						try {							
//							String	message2 = inputTextField.getText();
//							outputToClient.writeObject(message2);
//							ta.appendText("Server: "+message + '\n');
//							outputToClient.flush();
//							inputTextField.clear();
//							
//						} catch (IOException e) {
//							e.printStackTrace();
//						}					
//				});
//				}				
//			}
//			catch(IOException ex) {
//				ex.printStackTrace();
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			}
//		}).start();
//		clientID++;
	}

	public static void main(String[] args) {
		launch(args);
	}
	class HandleClientTasks implements Runnable{
		private Socket socket;
		private int id;
		
		HandleClientTasks(Socket socket, int id){
			this.socket = socket;
			this.id = id;
		}

		@Override
		public void run() {
			try {
				ObjectInputStream  inputFromClient = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
				
				while(true) {
					String	message = (String)inputFromClient.readObject();
					ta.appendText("Client: "+this.id+" "+message + '\n');
					
					send.setOnAction(event -> {
						try {
						String	message2 = inputTextField.getText();
						outputToClient.writeObject(message2);
						ta.appendText("Server: "+message + '\n');
						outputToClient.flush();
						inputTextField.clear();
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					});
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}



