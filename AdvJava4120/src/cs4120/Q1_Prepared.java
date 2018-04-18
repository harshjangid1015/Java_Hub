package cs4120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;


public class Q1_Prepared {
	public static void main(String[] args) {
		int totalEntries = 10000;
		Random rand = new Random();
		String[] fname = new String[totalEntries];
		String[] lname = new String[totalEntries];
		Integer[] money = new Integer[totalEntries];

		String Alphabets = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < totalEntries; i++) {
			int name_length = 3 + rand.nextInt(10);
			String Str1 = "";
			String Str2 = "";			
			for(int j = 0; j<name_length; j++) {
				char c = Alphabets.charAt(rand.nextInt(26));
				char d = Alphabets.charAt(rand.nextInt(26));				
				Str1 = Str1 + c;
				Str2 = Str2 + d;				
			}			
			fname[i] =  Str1;
			lname[i] = Str2;
			money[i] = 0 + rand.nextInt(1000000);

		}


//		for(int i = 0; i<totalEntries; i++) {
//			System.out.println(fname[i] + "\t " + lname[i] +"\t " + money[i] );
//		}

		long startTime = System.currentTimeMillis();
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

			// Establish a connection
			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/dictionary", "root", "root");
			System.out.println("Database connected");

			
			for(int i=0; i<totalEntries; i++) {
				PreparedStatement preparedStatement = connection.prepareStatement
						("insert into midterm.watchlist (first_name, last_name, money) " +"values (?, ?, ?)");
				
				preparedStatement.setString(1, fname[i]);
			    preparedStatement.setString(2, lname[i]);
			    preparedStatement.setInt(3, money[i]);
			    
			    preparedStatement.executeUpdate();
			}
			
			connection.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken " +(endTime- startTime) + " miliseconds");
	}

}
