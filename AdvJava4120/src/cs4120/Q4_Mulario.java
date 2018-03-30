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
		
		
		for(int i=0; i<20;i++) {
			Circle cir = new Circle();
			cir.setRadius(10+(Math.random()*40));
			cir.setCenterX(50+Math.random()*1150);
			cir.setCenterY(50+Math.random()*950);
			cir.setStroke(Color.RED);
			cir.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			pane.getChildren().add(cir);
		}
		
		
		

		Circle c = new Circle();
		c.setRadius(50);
		c.setCenterX(50+Math.random()*1150);
		c.setCenterY(50+Math.random()*950);
		c.setStroke(Color.BLACK);
		c.setFill(Color.GREEN);
		pane.getChildren().add(c);

		pane.setOnKeyPressed(e -> keyHandler(e, c));

		Scene scene = new Scene(borderPane, 1200, 1000);
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
