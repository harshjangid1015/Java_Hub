package cs4120;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;


public class MoveCircle extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		
		Pane pane = new Pane();
		
		HBox stackPane = new HBox();
		
//		StackPane  stackPane = new StackPane();
				
		Circle circle = new Circle();
		circle.setCenterX(300);
		circle.setCenterY(300);
		circle.setRadius(50.0);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.LAWNGREEN);
		pane.getChildren().add(circle);
		
		
		Button  moveButton = new Button("Move");
		Button  colorButton = new Button("Color");
		stackPane.getChildren().add(moveButton);
		stackPane.getChildren().add(colorButton);
				
		moveButton.setOnAction(e -> moveCircle(circle));
		colorButton.setOnAction(e -> changeColor(circle));
								
		borderPane.setCenter(pane);
		borderPane.setBottom(stackPane);
		
		Scene scene = new Scene(borderPane, 600, 600);
		primaryStage.setTitle("Move Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}
	public static void moveCircle(Circle circle){
		circle.setCenterX((int)(Math.random()*600));
		circle.setCenterY((int)(Math.random()*600));

	}
	
	public static void changeColor(Circle circle){
		circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		circle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
}
