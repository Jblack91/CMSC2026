


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */

public class FXMainPane extends VBox {

	private Button helloButton;
	private Button howdyButton;
	private Button chineseButton;
	private Button clearButton;
	private Button exitButton;

	private Label feedbackLabel;
	private TextField feedbackTextField;

	private HBox buttonBox;
	private HBox feedbackBox;
	
	private DataManager dataManager;
	
	
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");

		feedbackLabel = new Label("Feedback:");
		feedbackTextField = new TextField();

		buttonBox = new HBox();
		feedbackBox = new HBox();
		buttonBox.getChildren().addAll
		(
			helloButton,
			howdyButton,
			chineseButton,
			clearButton,
			exitButton
		);
		feedbackBox.getChildren().addAll
		(
			feedbackLabel,
			feedbackTextField
		);
		getChildren().addAll(buttonBox, feedbackBox);
		helloButton.setOnAction(new ButtonHandler());
		howdyButton.setOnAction(new ButtonHandler());
		chineseButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		exitButton.setOnAction(new ButtonHandler());
		
		dataManager = new DataManager();
		Insets inset = new Insets(10);
		HBox.setMargin(helloButton, inset);
		HBox.setMargin(howdyButton, inset);
		HBox.setMargin(chineseButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);
		HBox.setMargin(feedbackLabel, inset);
		HBox.setMargin(feedbackTextField, inset);
		buttonBox.setAlignment(Pos.CENTER);
		feedbackBox.setAlignment(Pos.CENTER);
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
	    @Override
	    public void handle(ActionEvent event)
	    {
	        if(event.getTarget() == helloButton)
	        {
	            feedbackTextField.setText(dataManager.getHello());
	        }
	        else if(event.getTarget() == howdyButton)
	        {
	            feedbackTextField.setText(dataManager.getHowdy());
	        }
	        else if(event.getTarget() == chineseButton)
	        {
	            feedbackTextField.setText(dataManager.getChinese());
	        }
	        else if(event.getTarget() == clearButton)
	        {
	            feedbackTextField.setText("");
	        }
	        else if(event.getTarget() == exitButton)
	        {
	            Platform.exit();
	            System.exit(0);
	        }
	    }
	}
	
}
	
