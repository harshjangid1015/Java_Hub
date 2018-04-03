package cs4120;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Q4_Mulario extends Application{
	private ArrayList<Circle> nodes = new ArrayList<>();
	Pane pane = new Pane();
	Circle c = new Circle();
	TextField tfr = new TextField();
	TextField tfg = new TextField();
	TextField tfb = new TextField();
	HBox hBox = new HBox();
	Button colButton = new Button("set color");
	CheckBox cb = new CheckBox("Display Radius");
	Text text = new Text("User");
	

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-border-color: blue");
//		StackPane stackPane = new StackPane();
//		stackPane.setStyle("-fx-border-color: green");
		pane.setStyle("-fx-border-color: red");
//		stackPane.getChildren().add(pane);
		text.setFont(new Font(20));

		borderPane.setTop(hBox);
		borderPane.setCenter(pane);

		cb.setOnAction(e -> {
			if(cb.isSelected()) {
				pane.getChildren().add(text);				
			}else {
				pane.getChildren().remove(text);
			}
		});

		colButton.setOnAction(ev -> {
			int r = Integer.parseInt(tfr.getText());
			int g = Integer.parseInt(tfg.getText());
			int b = Integer.parseInt(tfb.getText());
			c.setFill(Color.rgb(r, g, b));
			tfr.clear();
			tfg.clear();
			tfb.clear();
			pane.requestFocus();
		});

//		hBox.getChildren().addAll(tfr,tfg,tfb, colButton, cb);
		;
		hBox.getChildren().add(new Label("r"));
		hBox.getChildren().add(tfr);
		hBox.getChildren().add(new Label("g"));
		hBox.getChildren().add(tfg);
		hBox.getChildren().add(new Label("b"));
		hBox.getChildren().add(tfb);		
		hBox.getChildren().add(colButton);
		hBox.getChildren().add(cb);
		
		hBox.setAlignment(Pos.CENTER);

		for(int i=0; i<20;i++) {
			Circle cir = new Circle();
			cir.setRadius(10+(Math.random()*40));
			cir.setCenterX(50+Math.random()*1100);
			cir.setCenterY(50+Math.random()*800);
			cir.setStroke(Color.RED);
			cir.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			nodes.add(cir);
			pane.getChildren().add(cir);			
		}

		c.setRadius(50);
		c.setCenterX(50+Math.random()*1100);
		c.setCenterY(50+Math.random()*800);
		c.setStroke(Color.BLACK);
		c.setFill(Color.GREEN);
		pane.getChildren().add(c);
		text.setX(c.getCenterX());
		text.setY(c.getCenterY());

		pane.setOnKeyPressed(e -> keyHandler(e, c));

		Scene scene = new Scene(borderPane, 1200, 900);
		primaryStage.setTitle("Mulario");
		primaryStage.setScene(scene);
		primaryStage.show();
		pane.requestFocus();

		tfr.setFocusTraversable(false);
		tfg.setFocusTraversable(false);
		tfb.setFocusTraversable(false);
		cb.setFocusTraversable(false);
		colButton.setFocusTraversable(false);
		hBox.setFocusTraversable(false);
	}

	public void keyHandler(KeyEvent e, Circle c) {
		switch(e.getCode()) {
		case UP:
			c.setCenterX(c.getCenterX());
			c.setCenterY(c.getCenterY()-10);
			text.setX(c.getCenterX());
			text.setY(c.getCenterY());
			checkCircleIntersection(c);
			break;
		case DOWN:
			c.setCenterX(c.getCenterX());
			c.setCenterY(c.getCenterY()+10);
			text.setX(c.getCenterX());
			text.setY(c.getCenterY());
			checkCircleIntersection(c);
			break;
		case LEFT:
			c.setCenterX(c.getCenterX()-10);
			c.setCenterY(c.getCenterY());
			text.setX(c.getCenterX());
			text.setY(c.getCenterY());
			checkCircleIntersection(c);
			break;
		case RIGHT:
			c.setCenterX(c.getCenterX()+10);
			c.setCenterY(c.getCenterY());
			text.setX(c.getCenterX());
			text.setY(c.getCenterY());
			checkCircleIntersection(c);
			break;
		default:
			break;
		}
	}

	public void eatCircle(Circle c, Circle cir) {		
		Circle mainCircle = (Circle)c;
		Circle otherCircle = (Circle)cir;
		mainCircle.setRadius(mainCircle.getRadius() + 5);
		double newRadius = mainCircle.getRadius()+5;
		text.setText(Double.toString(newRadius));
		nodes.remove(otherCircle);
		pane.getChildren().remove(otherCircle);
	}

	public void checkCircleIntersection(Circle chk) {
		boolean collisionDetected = false;
		for (Circle static_circle : nodes) {
			if(static_circle != chk) {
				Shape intersect = Circle.intersect(chk, static_circle);
				if(intersect.getBoundsInLocal().getWidth() != -1) {
					collisionDetected = true;
				}
				if(collisionDetected) {
					eatCircle(chk, static_circle);
				}
			}			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
