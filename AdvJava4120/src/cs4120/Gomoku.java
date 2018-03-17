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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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

		for (int i =0; i<19; i++) {
			for (int j = 0; j<19; j++) {
				if(cell[i][j].getToken() == token
						&& cell[i][j+1].getToken() == token
						&& cell[i][j+2].getToken() == token
						&& cell[i][j+3].getToken() == token
						&& cell[i][j+4].getToken() == token) {
					cell[i][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i][j+1].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i][j+2].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i][j+3].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i][j+4].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					return true;
				}
			}
		}
		
		for (int i =0; i<19; i++) {
			for (int j = 0; j<19; j++) {
				if(cell[i][j].getToken() == token
						&& cell[i+1][j].getToken() == token
						&& cell[i+2][j].getToken() == token
						&& cell[i+3][j].getToken() == token
						&& cell[i+4][j].getToken() == token) {
					cell[i][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+1][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+2][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+3][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+4][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					return true;
				}
			}
		}
		
		for (int i =0; i<19; i++) {
			for (int j = 0; j<19; j++) {
				if(cell[i][j].getToken() == token
						&& cell[i+1][j+1].getToken() == token
						&& cell[i+2][j+2].getToken() == token
						&& cell[i+3][j+3].getToken() == token
						&& cell[i+4][j+4].getToken() == token) {
					cell[i][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+1][j+1].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+2][j+2].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+3][j+3].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i+4][j+4].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					return true;
				}
			}
		}

		
		for (int i =0; i<19; i++) {
			for (int j = 0; j<19; j++) {
				if(cell[i][j].getToken() == token
						&& cell[i-1][j+1].getToken() == token
						&& cell[i-2][j+2].getToken() == token
						&& cell[i-3][j+3].getToken() == token
						&& cell[i-4][j+4].getToken() == token) {
					cell[i][j].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i-1][j+1].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i-2][j+2].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i-3][j+3].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					cell[i-4][j+4].setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
					return true;
				}
			}
		}

		return false;
	}


	public class Cell extends StackPane{
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
				A.centerXProperty().bind(this.widthProperty().divide(2));
				A.centerYProperty().bind(this.heightProperty().divide(2));
				A.setStroke(Color.BLACK);
				A.setFill(Color.BLACK);
				getChildren().add(A);


			}
			else if (token == 'O') {
				Circle B = new Circle();
				B.setRadius(15);
				B.centerXProperty().bind(this.widthProperty().divide(2));
				B.centerYProperty().bind(this.heightProperty().divide(2));
				B.setStroke(Color.BLACK);
				B.setFill(Color.WHITE);
				getChildren().add(B);


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


