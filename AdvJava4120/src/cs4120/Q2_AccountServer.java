package cs4120;

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
				System.out.println("Networking setup. Waiting for client.");

				while (true) {
					Socket socket = serverSocket.accept();
					System.out.println("Server connected to Client " + clientID + " (localhost at 127.0.0.1)");
					HandleClientTaskAcc task = new HandleClientTaskAcc(socket, clientID);

					Thread thread = new Thread(task);
					thread.start();
					clientID++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

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
				Class.forName("com.mysql.jdbc.Driver");

				// Establish a connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary", "root", "root");

				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());;
				if (loginValidation(message1, message2)) {
					outputToClient.writeObject("Username already exist");
					System.out.println("Client " + id + ": " + "Account " + "'"+message1+"'" + " already exists.");
				} else {
					PreparedStatement preparedStatement = connection
							.prepareStatement("insert into midterm.account (username, password) " + "values (?, ?)");
					preparedStatement.setString(1, message1);
					preparedStatement.setString(2, message2);
					preparedStatement.executeUpdate();

					outputToClient.writeObject("Account created");
					System.out.println(
							"Client " + id + ": " + "Account " +"'"+ message1+"'" + " with password " + "'"+message2+"'" + " created.");
				}

				connection.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean loginValidation(String userName, String password) throws SQLException {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		String query = "select * from midterm.account where username = ?";
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dictionary", "root", "root");
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
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
