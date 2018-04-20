package cs4120;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import cs4120.Q3_ChatRoomServer.HandleClientTasks;
import javafx.application.Platform;

public class Q2_AccountServer {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Load the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded.");

		// Establish a connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary", "root", "root");
		System.out.println("Connection established.");

		new Thread(() -> {
			try {

				int clientID = 0;
				int port = 8000;
				ServerSocket serverSocket = new ServerSocket(port);
				// Platform.runLater(() ->
				// ta.appendText("Server started at " + new Date() + '\n'));
				System.out.println("Networking setup. Waiting for client.");

				while (true) {
					System.out.println("inside while");
					// String userName = "";
					Socket socket = serverSocket.accept();
					// ta.appendText("Client " +clientID+ " connected"+ '\n');
					System.out.println("Server connected to Client " + clientID + " (localhost at 127.0.0.1)");
					HandleClientTaskAcc task = new HandleClientTaskAcc(socket, clientID);
					System.out.println("in new thread try");

					// ObjectOutputStream outputToClient = new
					// ObjectOutputStream(socket.getOutputStream());
					// clientList.put(socket, outputToClient);

					Thread thread = new Thread(task);
					thread.start();
					clientID++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		// }});

		// // Create a statement
		// Statement statement = connection.createStatement();
		//
		// // Execute a statement
		// ResultSet resultSet = statement.executeQuery
		// ("select word, definition from entry where word "
		// + " = 'hello'");
		//// ("select firstName, mi, lastName from Student where lastName "
		//// + " = 'Smith'");
		//
		// // Iterate through the result and print the student names
		// while (resultSet.next())
		// System.out.println(resultSet.getString(1) + "\t" +
		// resultSet.getString(2));

		// Close the connection
		connection.close();
	}

}

class HandleClientTaskAcc implements Runnable {
	private Socket socket;
	private int id;

	HandleClientTaskAcc(Socket socket, int id) {
		this.socket = socket;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());

			 while(true) {
			String message1 = (String) inputFromClient.readObject();
			String message2 = (String) inputFromClient.readObject();
			// sendToAll(message, id);
			// System.out.println(message);

//			 }
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("Driver loaded.");

			// Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary", "root", "root");
			// System.out.println("Connection established.");

			// Statement statement = connection.createStatement();
			ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("loginValidation");
			if (loginValidation(message1, message2)) {
				System.out.println("if");
				outputToClient.writeObject("Username already exist");
				System.out.println("Client " + id + ": " + "Account " + message1 + " already exists.");
			} else {
				System.out.println("else");
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into midterm.account (username, password) " + "values (?, ?)");
				preparedStatement.setString(1, message1);
				preparedStatement.setString(2, message2);
				preparedStatement.executeUpdate();

				outputToClient.writeObject("Account created");
				System.out.println(
						"Client " + id + ": " + "Account " + message1 + " with password " + message2 + " created.");
			}

			// PreparedStatement preparedStatement = connection.prepareStatement
			// ("insert into midterm.account (username, password) " +"values (?, ?)");
			// preparedStatement.setString(1, message1);
			// preparedStatement.setString(2, message2);
			// preparedStatement.executeUpdate();
			//
			// ObjectOutputStream outputToClient = new
			// ObjectOutputStream(socket.getOutputStream());
			// outputToClient.writeObject("Account created");

			connection.close();

			// System.out.println("Client "+id+": "+"Account "+message1+" with password
			// "+message2+" created.");

			// Statement statement = connection.createStatement();
			 }

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean loginValidation(String userName, String password) throws SQLException {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "select * from midterm.account where username = ? and password = ?";
		System.out.println("loginValidation before try");
		try {
			System.out.println("loginValidation in try");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary", "root", "root");
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("loginValidation in try preparedStatement");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("loginValidation in try resultSet");
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
