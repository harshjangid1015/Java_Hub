package cs4120;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;


public class RandomLines extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane  = new Pane();
		
		for(int i = 0; i< 100; i++) {
			int startX = (int)(Math.random()*600);
			int startY = (int)(Math.random()*600);
			int endX = (int)(Math.random()*600);
			int endY = (int)(Math.random()*600);
			Line line = new Line(startX, startY, endX,endY );
			line.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			
			pane.getChildren().add(line);
			
		}
		
		
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setTitle("Random Lines");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
//	public static void main(String[] args) {
//    launch(args);
//  }
}
