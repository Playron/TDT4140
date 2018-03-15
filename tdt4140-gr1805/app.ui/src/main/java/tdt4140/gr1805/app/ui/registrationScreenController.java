package tdt4140.gr1805.app.ui;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tdt4140.gr1805.app.ui.*;
import tdt4140.gr1805.app.core.*;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;
import javafx.stage.Stage;

public class registrationScreenController{

	ObservableList<Gender> genderList = FXCollections.observableArrayList(Gender.MALE, Gender.FEMALE); //Creates List with Gender-Enum
	MasterScreenController screenController;
	
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
	Button backButton;
	@FXML
	AnchorPane rootPane;
	
	@FXML
	public void initialize() {
		gender.setItems(genderList); 		//Initialize List

	}
	
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
	
	//Logic for the register user button
	@FXML
	public void registerUser() {
		
			//Next bit of code is parsing from textField to Int
			//Need to write validation for invalid inputs
		int dag = Integer.parseInt(day_ID.getText());   			
		int maaned = Integer.parseInt(month_ID.getText());
		int aar = Integer.parseInt(year_ID.getText());
		
			//Checks if choiceBox-choices is an instance of the Gender enum.
		
		if(gender.getSelectionModel().getSelectedItem() instanceof Gender) {			
			Person person = new Person(aar, maaned, dag, (Gender)gender.getSelectionModel().getSelectedItem()); //Må caste Gender for å returnere
			System.out.println(person);																		  //	type Gender. ChoiceBox viser 
		}else {																								  //info fra observableList
			
			throw new IllegalArgumentException("Not an instance of Gender-Enum!");  //Should never trigger, since Gender-enum is only option.
		}
	}
	
	//Changing scenes on clicking the back button
	@FXML
	public void backButtonClicked() 
	{
		screenController.activate("LoginScreen");
	}
	
	
	
}
