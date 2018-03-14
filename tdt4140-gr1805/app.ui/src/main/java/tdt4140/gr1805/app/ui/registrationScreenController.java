package tdt4140.gr1805.app.ui;

import org.hamcrest.core.IsInstanceOf;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import tdt4140.gr1805.app.ui.*;
import tdt4140.gr1805.app.core.*;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;
import javafx.stage.Stage;

public class registrationScreenController extends Application {

	ObservableList<Gender> genderList = FXCollections.observableArrayList(Gender.MALE, Gender.FEMALE); //Creates List with Gender-Enum
	
	
	@FXML
	TextField day_ID;
	@FXML
	TextField month_ID;
	@FXML
	TextField year_ID;
	@FXML
	Label logInMessage;
	@FXML
	ChoiceBox gender;
	
	@FXML
	public void initialize() {
		gender.setItems(genderList); 		//Initialize List

	}
	
	
	@FXML
	public void registerUser() {
		
			//Next bit of code is parsing from textField to Int
			//Need to write validation forinvalid inputs
		
		int dag = Integer.parseInt(day_ID.getText());   			
		int maaned = Integer.parseInt(month_ID.getText());
		int aar = Integer.parseInt(year_ID.getText());
		
		//Checks if choiceBox-choices is an instance of the Gender enum.
		if(gender.getSelectionModel().getSelectedItem() instanceof Gender) {			
			Person person = new Person(aar, maaned, dag, (Gender)gender.getSelectionModel().getSelectedItem()); //
			System.out.println(person);
		}else {
			throw new IllegalArgumentException("Not an instance of Gender-Enum!");  //Should never trigger
		}
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
