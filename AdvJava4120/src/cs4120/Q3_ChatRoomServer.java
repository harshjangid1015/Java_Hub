package cs4120;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

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
	
	private Hashtable<Socket, ObjectOutputStream> clientList = new Hashtable<Socket, ObjectOutputStream>();
//	private ArrayList<client> clientList = new ArrayList<>();
	

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(ta);

		HBox hBox = new HBox();
		hBox.getChildren().addAll(inputTextField, send);
//		hBox.setAlignment(Pos.CENTER);

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
			
			send.setOnAction(event -> {
				try {
				String	message2 = inputTextField.getText();
				int toAll = 0;
			    sendToAll(message2,toAll);
				inputTextField.clear();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			});
			while(true) {		
				String userName = "";
				Socket socket = serverSocket.accept();
				ta.appendText("Client " +clientID+ " connected"+ '\n');
				HandleClientTasks task = new HandleClientTasks(socket, clientID);
//				new HandleClientTasks(socket, clientID);
				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
				clientList.put(socket, outputToClient);
				
				
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
	Enumeration getOutputStreams() {
		return clientList.elements();
	}
	public void sendToAll(String message, int id) {
		synchronized(clientList) {
			if(id!=0) {
				//if message of any client
//				ta.appendText("Client "+id+" "+message+'\n');
				ta.appendText(message+'\n');
			}else {
				//if server sending message
				ta.appendText("Server message to all client: "+message+'\n');
			}
			for(Enumeration e = getOutputStreams();e.hasMoreElements();) {
				//...get the outputStrams
				ObjectOutputStream outputToClient = (ObjectOutputStream )e.nextElement();
                // ...and sendvthe message
				try
                {
              	if(id!=0){
//              	    outputToClient.writeObject("Client: "+id+" "+message + '\n');
              	    outputToClient.writeObject(message + '\n');
              	}
              	else
              	{
              		outputToClient.writeObject("Server: "+message + '\n');
              	}
                
                } catch(IOException ie ) { System.out.println(ie ); }
			}
		}
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
				
				while(true) {
					String	message = (String)inputFromClient.readObject();
					sendToAll(message, id);					
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		}		
	}
}

class client{
	String userName;
	Socket socket;
	ObjectOutputStream outputToClient;
	
	client(String userName, Socket socket, ObjectOutputStream outputToClient){
		this.userName = userName;
		this.socket = socket;
		this.outputToClient = outputToClient;
	}
}



