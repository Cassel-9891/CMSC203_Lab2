


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
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
//make the main panel's layout be a VBox
public class FXMainPane extends VBox 
{

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button buttonHello;
	Button buttonHowdy;
	Button buttonChinese;
	Button buttonSpanish; // added another language button
	Button buttonClear;
	Button buttonExit;

	Label label1;

	TextField insertText;

	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager myDataManager;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() 
	{
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		buttonHello = new Button("Hello");
		buttonHowdy = new Button("Howdy");
		buttonChinese = new Button("Chinese");
		buttonSpanish = new Button("Spanish"); // set the text for new button
		buttonClear = new Button("Clear");
		buttonExit = new Button("Exit");

		label1 = new Label("Feedback");

		insertText = new TextField();

		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();


		//student Task #4:
		//  instantiate the DataManager instance
		myDataManager = new DataManager();

		//  set margins and set alignment of the components
		Insets inset = new Insets(10); // object from the Inset class to store the margin setting once

		HBox.setMargin(buttonHello, inset);
		HBox.setMargin(buttonHowdy, inset);
		HBox.setMargin(buttonChinese, inset);
		HBox.setMargin(buttonSpanish, inset); // set margin for new button
		HBox.setMargin(buttonClear, inset);
		HBox.setMargin(buttonExit, inset);

		hbox1.setAlignment(Pos.CENTER); 
		hbox2.setAlignment(Pos.CENTER);


		this.setPadding(new Insets(50)); // padding for the this vbox
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		// added new button to hbox1
		hbox1.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonSpanish, buttonClear, buttonExit); 

		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(label1, insertText);

		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hbox1, hbox2);

		// Button event handlers
		buttonHello.setOnAction(new ButtonClickHandler());
		buttonHowdy.setOnAction(new ButtonClickHandler());
		buttonChinese.setOnAction(new ButtonClickHandler());
		buttonSpanish.setOnAction(new ButtonClickHandler()); // Registering new button with handler
		buttonClear.setOnAction(new ButtonClickHandler());
		buttonExit.setOnAction(new ButtonClickHandler());

		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonClickHandler implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent event) 
		{
			// myDataManager.getHello();
			
			EventTarget target = event.getTarget(); // Saving the target method into a variable, 
			Button clickedButton = (Button)target; // And then casting it to Button type to avoid illegal comparisons,
												  // Then saving it in variable for readability.

			if(clickedButton == buttonHello)
			{
				insertText.setText(myDataManager.getHello()); 
			}
			else if(clickedButton == buttonHowdy)
			{
				insertText.setText(myDataManager.getHowdy());
			}
			else if(clickedButton == buttonChinese)
			{
				insertText.setText(myDataManager.getChinese());
			}
			else if(clickedButton == buttonSpanish) // Added event for new button
			{
				insertText.setText(myDataManager.getSpanish()); 
			}
			else if(clickedButton == buttonClear)
			{
				insertText.setText("");
			}
			else if(clickedButton == buttonExit)
			{
				Platform.exit();
				System.exit(0);
			}

		}
		
	}

}
	
