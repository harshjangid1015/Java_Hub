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

//		Circle A = new Circle();
//		A.setRadius(15);
//		A.setStroke(Color.BLACK);
//		A.setFill(Color.BLACK);
//		//		gridPane.getChildren().add(A);
//
//		Circle B = new Circle();
//		B.setRadius(15);
//		B.setStroke(Color.BLACK);
//		B.setFill(Color.WHITE);
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

	public boolean isFull() {
		for(int i= 0; i< 19; i++) {
			for(int j= 0; j< 19; j++) {
				if (cell[i][j].getToken() == ' ')
					return false;
			}
		}
		return true;
	}

	public boolean isWon(char token) {
		for (int i = 0; i < 3; i++)
			if (cell[i][0].getToken() == token
			&& cell[i][1].getToken() == token
			&& cell[i][2].getToken() == token) {
				return true;
			}

		for (int j = 0; j < 3; j++)
			if (cell[0][j].getToken() ==  token
			&& cell[1][j].getToken() == token
			&& cell[2][j].getToken() == token) {
				return true;
			}

		if (cell[0][0].getToken() == token 
				&& cell[1][1].getToken() == token        
				&& cell[2][2].getToken() == token) {
			return true;
		}

		if (cell[0][2].getToken() == token
				&& cell[1][1].getToken() == token
				&& cell[2][0].getToken() == token) {
			return true;
		}

		return false;
	}


	public class Cell extends Pane{
		// Token used for this cell
		private char token = ' ';

		public Cell() {
			setStyle("-fx-border-color: black");
			this.setPrefSize(50, 50);
			this.setOnMouseClicked(e -> handleMouseClick());
		}

		public char getToken() {
			return token;
		}

		/** Set a new token */
		public void setToken(char c) {
			token = c;

			if (token == 'X') {
				Circle A = new Circle();
				A.setRadius(15);
				A.setStroke(Color.BLACK);
				A.setFill(Color.BLACK);
				getChildren().add(A);
				
//				Line line1 = new Line(10, 10, 
//						this.getWidth() - 10, this.getHeight() - 10);
//				line1.endXProperty().bind(this.widthProperty().subtract(10));
//				line1.endYProperty().bind(this.heightProperty().subtract(10));
//				Line line2 = new Line(10, this.getHeight() - 10, 
//						this.getWidth() - 10, 10);
//				line2.startYProperty().bind(
//						this.heightProperty().subtract(10));
//				line2.endXProperty().bind(this.widthProperty().subtract(10));
//
//				// Add the lines to the pane
//				this.getChildren().addAll(line1, line2); 
			}
			else if (token == 'O') {
				Circle B = new Circle();
				B.setRadius(15);
				B.setStroke(Color.BLACK);
				B.setFill(Color.WHITE);
				getChildren().add(B);
				
//				Ellipse ellipse = new Ellipse(this.getWidth() / 2, 
//						this.getHeight() / 2, this.getWidth() / 2 - 10, 
//						this.getHeight() / 2 - 10);
//				ellipse.centerXProperty().bind(
//						this.widthProperty().divide(2));
//				ellipse.centerYProperty().bind(
//						this.heightProperty().divide(2));
//				ellipse.radiusXProperty().bind(
//						this.widthProperty().divide(2).subtract(10));        
//				ellipse.radiusYProperty().bind(
//						this.heightProperty().divide(2).subtract(10));   
//				ellipse.setStroke(Color.BLACK);
//				ellipse.setFill(Color.WHITE);
//
//				getChildren().add(ellipse); // Add the ellipse to the pane
			}
		}

		public void handleMouseClick(){
			// If cell is empty and game is not over
			if (token == ' ' && whoseTurn != ' ') {
				setToken(whoseTurn); // Set token in the cell

				// Check game status
				if (isWon(whoseTurn)) {
					lblStatus.setText(whoseTurn + " won! The game is over");
					whoseTurn = ' '; // Game is over
				}
				else if (isFull()) {
					lblStatus.setText("Draw! The game is over");
					whoseTurn = ' '; // Game is over
				}
				else {
					// Change the turn
					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
					// Display whose turn
					lblStatus.setText(whoseTurn + "'s turn");
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}


