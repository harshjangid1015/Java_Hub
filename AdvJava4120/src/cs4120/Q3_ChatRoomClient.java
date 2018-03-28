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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Q3_ChatRoomClient extends Application {
	ObjectOutputStream outputToServer = null;
	ObjectInputStream  inputFromServer = null;
	private TextArea ta = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(ta);

		TextField inputTextField = new TextField();

		Button send = new Button("SEND");
		HBox hBox = new HBox();
		hBox.getChildren().add(inputTextField);
		hBox.getChildren().add(send);

		borderPane.setBottom(hBox);
		borderPane.setCenter(scrollPane);
		Scene scene = new Scene(borderPane, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ChatRoomClient");
		primaryStage.show();
;
		ta.appendText("clent started" + '\n');;
		try {
			Socket socket = new Socket("localhost", 8000);
			ta.appendText("clent connected to server" + '\n');

			 outputToServer = new ObjectOutputStream(socket.getOutputStream());
			  inputFromServer = new ObjectInputStream(socket.getInputStream());
		}catch(Exception ex) {

		}
		new Thread(()->{
		
//		inputTextField.setOnAction(e -> {
			try {
				while(true) {
					String message;
					send.setOnAction(event -> {
						try {
							String message1 = inputTextField.getText();
							outputToServer.writeObject(message1);
							outputToServer.flush();
							inputTextField.clear();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
					message = (String)inputFromServer.readObject();
					ta.appendText("Server: "+message + '\n');
				}
			}catch(Exception ex) {

			}
//		});
		}).start();

	}
	public static void main(String[] args) {
		launch(args);
	}

}
