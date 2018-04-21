package cs4120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
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

		borderPane.setTop(hBox);
		borderPane.setRight(scrollPane);

		sb.setOnAction(ev -> {
			ta.clear();

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
						("select word, definition from entry where word like "+"'%"+tf.getText()+"%'" );

				ArrayList<String> matchWords = new ArrayList<>();
				ArrayList<String> matchDef = new ArrayList<>();

				while (resultSet.next()) {

					matchWords.add(resultSet.getString(1));
					matchDef.add(resultSet.getString(2));
				}
				ListView<String> lv = new ListView<>
				(FXCollections.observableArrayList(matchWords));
				lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
				borderPane.setLeft(new ScrollPane(lv));

				lv.getSelectionModel().selectedItemProperty().addListener(ov -> { 
					ta.clear();
					for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
						ta.appendText(matchDef.get(i));
					}
				});

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
