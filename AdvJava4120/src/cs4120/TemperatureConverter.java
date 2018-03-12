package cs4120;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TemperatureConverter extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		BorderPane pane = new BorderPane();

		Button convertButton = new Button("Convert");
		Label resultLabel = new Label("???");
		Label temperatureLabel = new Label("Enter Temperature:");
		TextField inputTextField = new TextField();
		inputTextField.setText("0");


		HBox top = new HBox();
		top.getChildren().add(temperatureLabel);
		top.getChildren().add(inputTextField);

		pane.setTop(top);
		pane.setBottom(convertButton);
		pane.setCenter(resultLabel);

		VBox right = new VBox();
		RadioButton fToCRadioButton = new RadioButton("F to C");
		RadioButton cToFRadioButton = new RadioButton("C to F");
		fToCRadioButton.setSelected(true);

		ToggleGroup group = new ToggleGroup();
		fToCRadioButton.setToggleGroup(group);
		cToFRadioButton.setToggleGroup(group);

		right.getChildren().add(fToCRadioButton);
		right.getChildren().add(cToFRadioButton);

		pane.setRight(right);

		convertButton.setOnAction(e -> {
			double t = Double.parseDouble(inputTextField.getText());

			if (fToCRadioButton.isSelected())
			{
				double c = (t - 32) * 5.0 / 9.0;
				resultLabel.setText("" + c + " \u00b0C");
			}
			else if (cToFRadioButton.isSelected())
			{
				double f = t * 9.0 / 5.0 + 32;
				resultLabel.setText("" + f + " \u00b0F");
			}
		});


		Scene scene = new Scene(pane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
