package cs4120;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Q4_Mulario extends Application{

	@Override
	public void start(Stage primaryStage){
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-border-color: blue");
		Pane pane = new Pane();
		borderPane.setCenter(pane);

		Circle c = new Circle();
		c.setRadius(50);
		c.setCenterX(300);
		c.setCenterY(400);
		c.setStroke(Color.BLACK);
		c.setFill(Color.AQUA);
		pane.getChildren().add(c);

		pane.setOnKeyPressed(e -> keyHandler(e, c));

		Scene scene = new Scene(borderPane, 1000, 800);
		primaryStage.setTitle("Mulario");
		primaryStage.setScene(scene);
		primaryStage.show();
		pane.requestFocus();

	}

	public static void keyHandler(KeyEvent e, Circle c) {
		switch(e.getCode()) {
		case UP:
			c.setCenterX(c.getCenterX());
			c.setCenterY(c.getCenterY()-10);
			break;
		case DOWN:
			c.setCenterX(c.getCenterX());
			c.setCenterY(c.getCenterY()+10);
			break;
		case LEFT:
			c.setCenterX(c.getCenterX()-10);
			c.setCenterY(c.getCenterY());
			break;
		case RIGHT:
			c.setCenterX(c.getCenterX()+10);
			c.setCenterY(c.getCenterY());
			break;
		default:
			break;

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
