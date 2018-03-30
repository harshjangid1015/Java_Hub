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
	
	String userName = "default user...set userName from above";

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(ta);

		TextField inputTextField = new TextField();
		TextField inputUserName = new TextField();

		Button send = new Button("SEND");
		Button setUserName = new Button("setUserName");
		HBox hBox = new HBox();
		hBox.getChildren().add(inputTextField);
		hBox.getChildren().add(send);
		HBox hBox2 = new HBox();
		hBox2.getChildren().addAll(inputUserName,setUserName);

		borderPane.setBottom(hBox);
		borderPane.setTop(hBox2);
		borderPane.setCenter(scrollPane);
		Scene scene = new Scene(borderPane, 400, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ChatRoomClient");
		primaryStage.show();
		;
		ta.appendText("clent started" + '\n');;
		setUserName.setOnAction(e -> {
			userName = inputUserName.getText();
			ta.appendText("user name set to: "+userName+'\n');
		});
		
		try {
			Socket socket = new Socket("localhost", 8000);
			ta.appendText("clent connected to server" + '\n');

			outputToServer = new ObjectOutputStream(socket.getOutputStream());
			inputFromServer = new ObjectInputStream(socket.getInputStream());
		}catch(Exception ex) {

		}
		new Thread(()->{
			try {
				while(true) {
					send.setOnAction(event -> {
						try {
							String message1 = inputTextField.getText();
							outputToServer.writeObject(userName +": " +message1);
							inputTextField.clear();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					});
					String message = (String)inputFromServer.readObject();					
					ta.appendText(message);
				}
			}catch(Exception ex) {

			}
		}).start();

	}
	public static void main(String[] args) {
		launch(args);
	}
}
