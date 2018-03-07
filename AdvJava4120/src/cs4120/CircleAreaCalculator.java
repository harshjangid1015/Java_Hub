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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
 import javafx.scene.shape.Circle;
 import javafx.scene.paint.*;
 import javafx.scene.shape.Rectangle;
 import javafx.scene.control.Button;
 import javafx.scene.control.Button;
 
 
 
public class CircleAreaCalculator extends Application{
	
	public void start(Stage primaryStage) {
		
		BorderPane borderPane = new BorderPane();
		Label radiusLabel = new Label("Radius");
		Label areaLabel = new Label("Area");
		Button calculateButton = new Button("Calculate");
		TextField radiusTextField = new TextField();
		
		borderPane.setBottom(calculateButton);
		borderPane.setTop(radiusTextField);
		borderPane.setLeft(radiusLabel);
		borderPane.setCenter(areaLabel);
		
		
		calculateButton.setOnAction(e -> {
			String text = radiusTextField.getText();
			double radius = Double.parseDouble(text);
			double area = radius*radius*Math.PI;
			areaLabel.setText("Area " + area);
			
		});
		
		
		
		Scene scene = new Scene(borderPane, 600, 600);
		primaryStage.setTitle("CircleAreaCalculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	public static void main(String[] args) {
	    launch(args);
	}


}
