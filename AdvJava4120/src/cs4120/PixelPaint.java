package cs4120;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class PixelPaint extends Application {
	
	ColorPicker colorPicker = new ColorPicker();
	Cell[][] cell = new Cell[32][32];
	Color whichColor;

	@Override
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		BorderPane borderPane  = new BorderPane();
		borderPane.setStyle("-fx-border-color: red");
		gridPane.setStyle("-fx-border-color: green");
		HBox hBox = new HBox();
		borderPane.setTop(hBox);
		borderPane.setCenter(gridPane);
		Button SAVE = new Button("SAVE");
		Button LOAD = new Button("LOAD IMAGE");
		hBox.getChildren().add(colorPicker);
		hBox.getChildren().add(SAVE);
		hBox.getChildren().add(LOAD);
		
		for(int i=0; i<32; i++) {
			for (int j=0; j<32; j++) {
				gridPane.add(cell[i][j] = new Cell(), j, i);
			}
		}
		
		colorPicker.setOnAction(e -> {
			whichColor = colorPicker.getValue();
		});
		
		SAVE.setOnAction(e -> {
			File aFile = new File("newFile.txt");
			try {
				PrintWriter writer = new PrintWriter(aFile);
				for(int i=0; i<32; i++) {
					for (int j=0; j<32; j++) {					
							if(cell[i][j].getBackground() != null) {
								Background bb = cell[i][j].getBackground();
								BackgroundFill fill2 = bb.getFills().get(0);
								Paint p = fill2.getFill();
								Color d = (Color)p;
								int red = (int) (d.getRed()*255);
								int green = (int) (d.getGreen()*255);
								int blue = (int) (d.getBlue()*255);
//								System.out.println(red + "\t" + green + "\t" + blue);
								writer.println(red + "\t" + green + "\t" + blue);
							}					
					}
				}

				writer.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		LOAD.setOnAction(e -> {
			File aFile = new File("newFile.txt");
			Color col;
			try {
				Scanner reader = new Scanner(aFile);
				//int i = 0 ; int j=0;
				while(reader.hasNext()) {
//					int red = reader.nextInt();
//					int green = reader.nextInt();
//					int blue = reader.nextInt();
//					System.out.println(red + "\t" + green + "\t" + blue);
					
					
//					col = Color.rgb(red, green, blue);
//					BackgroundFill fill = new BackgroundFill(col, null, null);
//					Background background = new Background(fill);
//					cell[i][j].setBackground(background);
//					i++;
//					if(i%32 ==0)
//					{
//						j++;
//						i = 0;
//					}
					
					for(int i=0; i<32; i++) {
						for (int j=0; j<32; j++) {
							int red = reader.nextInt();
							int green = reader.nextInt();
							int blue = reader.nextInt();
							col = Color.rgb(red, green, blue);
							BackgroundFill fill = new BackgroundFill(col, null, null);
							Background background = new Background(fill);
							cell[i][j].setBackground(background);
						}
					}
						
				}
				
				
				reader.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Pixel Paint");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	class Cell extends StackPane{
		
		public Cell() {
			setStyle("-fx-border-color: black");
			this.setPrefSize(25, 25);
			BackgroundFill fill = new BackgroundFill(Color.WHITE, null, null);
			Background background = new Background(fill);
			this.setBackground(background);
			this.setOnMouseClicked(e -> handleMouseClick());
		}
		
		public Color getColor() {
			return whichColor;
		}
		
		
		public void setColor(Color c) {
			whichColor = c;
//			this.setStyle("-fx-border-color: red");
			BackgroundFill fill = new BackgroundFill(whichColor, null, null);
			Background background = new Background(fill);
			this.setBackground(background);
		}
		
		public void handleMouseClick() {
			setColor(whichColor);
		}
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
