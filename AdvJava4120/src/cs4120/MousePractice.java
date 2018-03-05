package cs4120;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
 import javafx.scene.shape.Circle;
 import javafx.scene.paint.*;


public class MousePractice extends Application{

	@Override
	public void start(Stage primaryStage) {
		
		Label coordsLabel = new Label("(?, ?)");
		
		StackPane pane = new StackPane();
		pane.getChildren().add(coordsLabel);
		
		Circle circle = new Circle();
		circle.setRadius(50);
		circle.setFill(Color.LAVENDER);
		circle.setStroke(Color.BLACK);
		
		pane.getChildren().add(circle);
		
		
		pane.setOnMouseMoved(e-> updateCords(e, coordsLabel));
		
		
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setTitle("Move Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		pane.requestFocus();
	}
	
	public static void updateCords(MouseEvent e,Label coordsLabel ) {
		String text = "(" +e.getX()+ "," + e.getY()+")";
		text += "\n";
		coordsLabel.setText(text);
		
		
	}
	public static void main(String[] args) {
	    launch(args);
	}

}
