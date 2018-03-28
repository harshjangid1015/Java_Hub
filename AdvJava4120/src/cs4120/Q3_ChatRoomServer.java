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
import javafx.stage.Stage;

public class Q3_ChatRoomServer extends Application {
	// Text area for displaying contents
	private TextArea ta = new TextArea();

	// Number a client

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(ta);


		TextField inputTextField = new TextField();
		Button send = new Button("SEND");
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

		new Thread( () -> {
			try {
				// Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() ->
				ta.appendText("Server started at " + new Date() + '\n'));

				// Listen for a connection request
				Socket socket = serverSocket.accept();

				// Create data input and output streams
				ObjectInputStream  inputFromClient = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
				while (true) {
					
					String	message = (String)inputFromClient.readObject();
					ta.appendText("Client: "+message + '\n');
					
					send.setOnAction(event -> {						
						try {							
							String	message2 = inputTextField.getText();
							outputToClient.writeObject(message2);
							outputToClient.flush();
							inputTextField.clear();
							
						} catch (IOException e) {
							e.printStackTrace();
						}					
				});
				}				
			}
			catch(IOException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}).start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}



