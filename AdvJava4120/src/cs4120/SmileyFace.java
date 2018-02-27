package cs4120;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class SmileyFace extends Application{
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Circle face = new Circle(300, 300,300);
		face.setStroke(Color.BLACK);
		face.setFill(Color.YELLOW);
		pane.getChildren().add(face);
		
		//eye
		Circle leftEye = new Circle(150, 150, 50);
		leftEye.setFill(Color.BLACK);
	    pane.getChildren().add(leftEye);
		
	    Circle rightEye = new Circle(450, 150, 50);
		rightEye.setFill(Color.BLACK);
		pane.getChildren().add(rightEye);
		
		//Mouth
		Ellipse mouth = new Ellipse(300, 350, 200, 100);
		mouth.setFill(Color.BLACK);
		pane.getChildren().add(mouth);
		
		
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setTitle("Smiley face");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
//	public static void main(String[] args) {
//	    launch(args);
//	  }
}
