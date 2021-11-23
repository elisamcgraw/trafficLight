//ELISA MASIERO
// LAB 8

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Use as a starting point for lab 8
// Add three radio buttons (red, yellow, green)
// When a radio button is clicked, the correct light has the correct color
public class trafficLight extends Application{

	private RadioButton red, yellow, green;
	private double paneWidth = 200;
	private double paneHeight = 200;
	private Circle greenLight, yellowLight, redLight;
	
	// override
	public void start(Stage pStage) {
		BorderPane pane = new BorderPane();
		// Create HBox for RadioButtons
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(5,5,5,5));
		
		// create the three lights
		redLight = new Circle(paneWidth/2, 25, 10); //(x, y, radius)
		yellowLight = new Circle(paneWidth/2, 55, 10);
		greenLight = new Circle(paneWidth/2, 85, 10);
		redLight.setStroke(Color.BLACK);
		yellowLight.setStroke(Color.BLACK);
		greenLight.setStroke(Color.BLACK);
		redLight.setFill(Color.WHITESMOKE);
		yellowLight.setFill(Color.WHITESMOKE);
		greenLight.setFill(Color.WHITESMOKE);		
		
		// outline of the traffic light
		Rectangle rect = new Rectangle(paneWidth/2 -25, 5, 50, 100);
		rect.setStroke(Color.BLACK);
		rect.setFill(Color.GREY);
		
		
		// Create RadioButtons
		red = new RadioButton("Red");
		yellow = new RadioButton("Yellow");
		green = new RadioButton("Green");
		
		// Create ToggleGroup so only one RadioButton is selected
		ToggleGroup lightGroup = new ToggleGroup();
		red.setToggleGroup(lightGroup);
		yellow.setToggleGroup(lightGroup);
		green.setToggleGroup(lightGroup);
		
		// Register each light
		LightHandler handler = new LightHandler();
		red.setOnAction(handler);
		yellow.setOnAction(handler);
		green.setOnAction(handler);
		
		// Preselect redLight
		yellow.fire(); 
		
		//Create a Stack Pane
		StackPane stackPane = new StackPane();		
		
		// Throw everything onto the screen
		pane.getChildren().addAll( rect, redLight, yellowLight, greenLight);
		hbox.getChildren().addAll(red, yellow, green);
		stackPane.getChildren().addAll();
		pane.setBottom(hbox);
		Scene scene = new Scene(pane, paneWidth, paneHeight);
		pStage.setTitle("Traffic Light");
		pStage.setScene(scene);
		pStage.show();		
	}
	public static void main(String[] args) {
		Application.launch(args);

	}
	
	class LightHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			if (red.isSelected()) {
				redLight.setFill(Color.RED);
				yellowLight.setFill(Color.WHITESMOKE);
				greenLight.setFill(Color.WHITESMOKE);
			}
			else if(yellow.isSelected()) {
				yellowLight.setFill(Color.YELLOW);
				redLight.setFill(Color.WHITESMOKE);
				greenLight.setFill(Color.WHITESMOKE);
			}
			else {
				greenLight.setFill(Color.GREEN);
				yellowLight.setFill(Color.WHITESMOKE);
				redLight.setFill(Color.WHITESMOKE);
			}
				
		}
	}

}
