package cs4120;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
//import javafx.scene.control.Cell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;

public class PixelPaint extends Application {
	
	char whichColor = 'G';
	
	Cell[][] cell = new Cell[32][32];
	
	Label lblStatus = new Label("GREEN Brush Selected");

	@Override
	public void start(Stage primaryStage) {
		
		GridPane gridPane = new GridPane();
		for(int i=0; i<32; i++) {
			for (int j=0; j<32; j++) {
				gridPane.add(cell[i][j] = new Cell(), j, i);
			}
		}
		
		Button RED = new Button("RED");
		Button GREEN = new Button("GREEN");
		Button BLUE = new Button("BLUE");
		HBox hBox = new HBox();
		hBox.getChildren().add(RED);
		hBox.getChildren().add(GREEN);
		hBox.getChildren().add(BLUE);
//		RED.setOnAction(e -> whichColor = 'R');
		RED.setOnAction(e -> {
			whichColor = 'R';
			lblStatus.setText("Red Brush Selected");});
		GREEN.setOnAction(e -> {
			whichColor = 'G';
			lblStatus.setText("GREEN Brush Selected");});
		BLUE.setOnAction(e -> {
			whichColor = 'B';
			lblStatus.setText("BLUE Brush Selected");});
		
		BorderPane borderPane  = new BorderPane();
		borderPane.setStyle("-fx-border-color: red");
		borderPane.setTop(hBox);
		borderPane.setCenter(gridPane);
		borderPane.setBottom(lblStatus);
		
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Pixel Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	class Cell extends StackPane{
		private char brush = ' ';
				
		public Cell() {
			setStyle("-fx-border-color: black");
			this.setPrefSize(25, 25);
			this.setOnMouseClicked(e -> handleMouseClick());
		}
		
		public char getBrush() {
			return brush;
		}

		/** Set a new token */
		public void setBrush(char c) {
			brush = c;

			if (brush == 'R') {
				
				Rectangle r =new Rectangle();
				r.setWidth(23);
				r.setHeight(23);
//				r.setStroke(Color.BLACK);
				r.setFill(Color.RED);
				getChildren().add(r);
//				Circle A = new Circle();
//				A.setRadius(15);
//				A.centerXProperty().bind(this.widthProperty().divide(2));
//				A.centerYProperty().bind(this.heightProperty().divide(2));
//				A.setStroke(Color.BLACK);
//				A.setFill(Color.BLACK);
//				getChildren().add(A);
			}
			else if  (brush == 'G'){				
				Rectangle g =new Rectangle();
				g.setWidth(23);
				g.setHeight(23);
//				r.setStroke(Color.BLACK);
				g.setFill(Color.GREEN);
				getChildren().add(g);
			}
			else if  (brush == 'B'){				
				Rectangle b =new Rectangle();
				b.setWidth(23);
				b.setHeight(23);
//				r.setStroke(Color.BLACK);
				b.setFill(Color.BLUE);
				getChildren().add(b);
			}
		}

		public void handleMouseClick() {
			
			if (brush == ' ' && whichColor != ' ') {
				setBrush(whichColor); // Set token in the cell

				// Check game status
//				if (isWon(whoseTurn)) {
//					lblStatus.setText(whoseTurn + " won! The game is over");
//					
//					whoseTurn = ' '; // Game is over
//				}
//				else if (isFull()) {
//					lblStatus.setText("Draw! The game is over");
//					whoseTurn = ' '; // Game is over
//				}
//				else {
//					// Change the turn
//					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
//					// Display whose turn
//					lblStatus.setText(whoseTurn + "'s turn");
//				}
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
