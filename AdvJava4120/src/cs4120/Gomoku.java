package cs4120;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class Gomoku extends Application {
	
	char whoseTurn = 'X';

	Cell[][] cell =  new Cell[19][19];
	
	Label lblStatus = new Label("X's turn to play");

	@Override
	public void start(Stage primaryStage){

		GridPane gridPane = new GridPane();
		for(int i = 0; i<19; i++) {
			for(int j = 0; j< 19; j++) {
				gridPane.add(cell[i][j] = new Cell(), j, i);
			}
		}
		
		Circle A = new Circle();
		A.setRadius(15);
		A.setStroke(Color.BLACK);
		A.setFill(Color.BLACK);
//		gridPane.getChildren().add(A);
		
		Circle B = new Circle();
		B.setRadius(15);
		B.setStroke(Color.BLACK);
		B.setFill(Color.WHITE);
//		gridPane.getChildren().add(B);


		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-border-color: red");
		borderPane.setCenter(gridPane);
		borderPane.setBottom(lblStatus);
		BackgroundFill fill = new BackgroundFill(Color.BEIGE, null, null);
		Background background = new Background(fill);
		gridPane.setBackground(background);


		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Gomoku");
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}

}

class Cell extends Pane{

	public Cell() {
		setStyle("-fx-border-color: black");
		this.setPrefSize(50, 50);
		this.setOnMouseClicked(e -> handleMouseClick());
	}
	
	public void handleMouseClick(){
		
	}
}
