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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
 import javafx.scene.shape.Circle;
 import javafx.scene.paint.*;
 import javafx.scene.shape.Rectangle;
 
public class ChangeRectangle extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Pane canvas = new Pane();
		
		Rectangle r = new Rectangle();
		r.setWidth(100);
		r.setHeight(200);
		r.setX(300 - r.getWidth()/2);
		r.setY(300 - r.getHeight()/2);
		r.setFill(Color.AQUA);
		r.setStroke(Color.BLACK);
		canvas.getChildren().add(r);
		canvas.setOnKeyPressed(e-> keyHandler(e, r));
		
		canvas.setOnMousePressed(e-> mouseHandler(e, r));
		
		Scene scene = new Scene(canvas, 600, 600);
		primaryStage.setTitle("Move Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		canvas.requestFocus();
		
	}
	
	public static void keyHandler(KeyEvent e, Rectangle r ) {
		
		switch(e.getCode()) {
		case UP:
			r.setHeight(r.getHeight()-10);
			r.setY(300 - r.getHeight()/2);
			break;
		case DOWN:
			r.setHeight(r.getHeight()+10);
			r.setY(300 - r.getHeight()/2);
			break;
		case LEFT:
			r.setWidth(r.getWidth()+10);
			r.setX(300 - r.getWidth()/2);
			break;
		case RIGHT:
			r.setWidth(r.getWidth()-10);
			r.setX(300 - r.getWidth()/2);
			break;
		default:
			break;
			
		}
	}
	
	public static void mouseHandler(MouseEvent e, Rectangle r ) {
		
		switch(e.getButton()) {
		case PRIMARY:
			r.setFill(Color.CRIMSON);
			break;
		case SECONDARY:
			r.setFill(Color.AQUA);
			break;
		case MIDDLE:
			r.setFill(Color.LAWNGREEN);
			break;
		default:
			System.out.println(e.getButton() + " Pressed");
			break;
		
			
		}
		
	}
	public static void main(String[] args) {
	    launch(args);
	}

}
