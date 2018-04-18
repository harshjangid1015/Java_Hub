package cs4120;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Dictionary extends Application{

	private TextArea ta = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane  = new BorderPane();
		ScrollPane scrollPane = new ScrollPane(ta);
		HBox hBox = new HBox();
		TextField tf = new TextField();
		Button sb = new Button("SEARCH");
		hBox.getChildren().addAll(tf, sb);


//		ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2","Item 3", "Item 4", "Item 5", "Item 6");
//		ListView<String> lv = new ListView<>(items);
//		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



		borderPane.setTop(hBox);
		//		borderPane.setCenter(scrollPane);
		borderPane.setRight(scrollPane);
//		borderPane.setLeft(new ScrollPane(lv));

		sb.setOnAction(ev -> {
			//			int r = Integer.parseInt(tfr.getText());
			//			int g = Integer.parseInt(tfg.getText());
			//			int b = Integer.parseInt(tfb.getText());
			//			c.setFill(Color.rgb(r, g, b));
			//			tfr.clear();
			//			tfg.clear();
			//			tfb.clear();
			//			pane.requestFocus();

			try {
				// Load the JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded");

				// Establish a connection
				Connection connection = DriverManager.getConnection
						("jdbc:mysql://localhost/dictionary", "root", "root");
				System.out.println("Database connected");

				// Create a statement
				Statement statement = connection.createStatement();

				// Execute a statement
				//				
				ResultSet resultSet = statement.executeQuery
						//						("select word, definition from entry where word " + " = 'hello' ");
						("select word, definition from entry where word " + " = '"+tf.getText()+"' ");

				//			    ("select firstName, mi, lastName from Student where lastName "
				//			            + " = 'Smith'");

				
				
				ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2","Item 3", "Item 4", "Item 5", "Item 6");
//				ObservableList<String> items = FXCollections.observableArrayList(resultSet.getString(1));
				ListView<String> lv = new ListView<>(items);
				lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				borderPane.setLeft(new ScrollPane(lv));
				
				// Iterate through the result and print the student names
				while (resultSet.next()) {
					ta.appendText(resultSet.getString(1) + '\n' +resultSet.getString(2)+ '\n');
				}
					
				//					System.out.println(resultSet.getString(1) + "\t" +resultSet.getString(2));

				tf.clear();
				// Close the connection
				connection.close();
			}catch(Exception ex) {

			}
		});

		Scene scene = new Scene(borderPane, 600, 400);
		primaryStage.setTitle("Dictionary");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
