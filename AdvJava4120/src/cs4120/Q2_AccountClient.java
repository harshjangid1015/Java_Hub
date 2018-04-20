package cs4120;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
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
		Label label = new Label("Hi");

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
		// Socket socket = null;

		System.out.println("Try block start");

		try {
			socket = new Socket("localhost", port);
			System.out.println("Client conncetd to server");

			outputToServer = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("out");
			// inputFromServer = new ObjectInputStream(socket.getInputStream());
			System.out.println("in");

		} catch (IOException e1) {
			System.out.println("catch block start");
			e1.printStackTrace();

		}

		new Thread(()->{
			try {
				while(true) {
					//					System.out.println("Before Register");
					register.setOnAction(ev -> {
						// int port = 8000;
						// Socket socket = null;
						//
						System.out.println("Before Try register");
						try {
							System.out.println("In Try register");
							// socket = new Socket("localhost", port);
							//
							// System.out.println("Client conncetd to server");

							// DataInputStream inputFromServer = new
							// DataInputStream(socket.getInputStream());
							// ObjectOutputStream outputToServer = new
							// ObjectOutputStream(socket.getOutputStream());

							// outputToServer = new ObjectOutputStream(socket.getOutputStream());
							// inputFromServer = new ObjectInputStream(socket.getInputStream());
							//
							//							while(true) {
							//								System.out.println("In Try register: variable");
							String usr = userInput.getText();
							String pas = passInput.getText();

							//								System.out.println("In Try register: outputToServer");
							outputToServer.writeObject(usr);
							outputToServer.writeObject(pas);

							//								System.out.println("In Try register: Variable clear");
							userInput.clear();
							passInput.clear();

							// ObjectInputStream inputFromServer = new
							// ObjectInputStream(socket.getInputStream());
							//								System.out.println("In Try register: inputFromServer"+socket.getInputStream().toString());

							//								inputFromServer = new ObjectInputStream(socket.getInputStream());

							//								System.out.println("In Try register: readObject");
							//								String msg = (String) inputFromServer.readObject();
							//								label.setText(msg);

							// while(true) {
							// System.out.print("Enter a radius ");
							// double radius = input.nextDouble();
							// System.out.println("radius entered: " + radius);
							//
							// outputToServer.writeDouble(radius);
							//
							// double area = inputFromServer.readDouble();
							//
							// System.out.println("Area received: " + area);
							//
							// }
							//							}

							inputFromServer = new ObjectInputStream(socket.getInputStream());
							System.out.println("In Try register: readObject");
							String msg = (String) inputFromServer.readObject();
							System.out.println(msg);
//							Platform.runLater(() ->
//							label.setText(msg));
							label.setText(msg);

						} catch (IOException ex) {
							System.out.println("In Try register: catch");
							ex.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					});

					//					ta.appendText("Server started at " + new Date() + '\n'));
					//					label.setText(msg);
					//					String message = (String)inputFromServer.readObject();					
					//					ta.appendText(message);
				}
			}catch(Exception ex) {

			}
		}).start();

		new Thread(()->{



		}).start();


		System.out.println("opening window");

		Scene scene = new Scene(borderPane, 400, 200);
		primaryStage.setTitle("Register Account");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
