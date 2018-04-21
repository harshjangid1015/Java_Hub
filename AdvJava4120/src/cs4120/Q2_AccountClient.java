package cs4120;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Q2_AccountClient extends Application {

	ObjectOutputStream outputToServer = null;
	ObjectInputStream inputFromServer = null;
	Socket socket = null;

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Label username = new Label("Username");
		Label password = new Label("Password");
		TextField userInput = new TextField();
		TextField passInput = new TextField();
		Button register = new Button("Register");
		Label label = new Label("");

		HBox top = new HBox();
		top.getChildren().addAll(username, userInput);
		HBox middle = new HBox();
		middle.getChildren().addAll(password, passInput);
		HBox bottom = new HBox();
		bottom.getChildren().addAll(register, label);

		borderPane.setTop(top);
		borderPane.setCenter(middle);
		borderPane.setBottom(bottom);

		int port = 8000;

		try {
			socket = new Socket("localhost", port);
			System.out.println("Client conncetd to server");

			outputToServer = new ObjectOutputStream(socket.getOutputStream());

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		new Thread(()->{
			try {
				while(true) {
					register.setOnAction(ev -> {
						try {						
							String usr = userInput.getText();
							String pas = passInput.getText();
							outputToServer.writeObject(usr);
							outputToServer.writeObject(pas);
							userInput.clear();
							passInput.clear();

							inputFromServer = new ObjectInputStream(socket.getInputStream());
							String msg = (String) inputFromServer.readObject();
							label.setText(msg);

						} catch (IOException ex) {
							ex.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					});
				}
			}catch(Exception ex) {

			}
		}).start();

		Scene scene = new Scene(borderPane, 400, 200);
		primaryStage.setTitle("Register Account");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
