package tdt4140.gr1805.app.ui;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

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
import tdt4140.gr1805.app.core.data.Database;
import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;
import javafx.stage.Stage;

public class registrationScreenController{

	ObservableList<Gender> genderList = FXCollections.observableArrayList(Gender.MALE, Gender.FEMALE); //Creates List with Gender-Enum 
	ObservableList<City> cityList = FXCollections.observableArrayList(City.BERGEN, City.KRISTIANSAND, City.OSLO, City.TROMSOE, City.TRONDHEIM, City.STAVANGER);
	MasterScreenController screenController; //Initiate MasterScreen in registrationScreen.
	
	@FXML
	ChoiceBox cityBox;
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
		//Initialize List
		gender.setItems(genderList);
		cityBox.setItems(cityList);
	}
	
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
		//Logic for the register user button
	
	@FXML
	public void registerUser() throws FileNotFoundException, ClassNotFoundException, IOException, URISyntaxException {
		
		//Next bit of code is parsing from textField to Int
		//Need to write validation for invalid inputs
		
		
		
		
		int dag = Integer.parseInt(day_ID.getText());   			
		int maaned = Integer.parseInt(month_ID.getText());
		int aar = Integer.parseInt(year_ID.getText());
		
		
		//Checks if choiceBox-choices is an instance of the Gender enum.
		//Have to Cast Gender, and CITY
		if(gender.getSelectionModel().getSelectedItem() instanceof Gender) {			
			Person person = new Person(aar, maaned, dag, (Gender)gender.getSelectionModel().getSelectedItem(), 
					(City) cityBox.getSelectionModel().getSelectedItem()); 
			
			
			//Writes the person-Object to the corresponding JSON file. Automatically keeps track of ID
			//Person-objects is beeing saved as HAshMap<ID, person>
			Database db = new Database();
			db.addPerson(person);
			db.writeObjects();
			System.out.println(person);																		  
		}else {																								  
			//Should never trigger, since Gender-enum is only option.	
			throw new IllegalArgumentException("Not an instance of Gender-Enum!");  
		}
	}
	
	
	@FXML
	public void backButtonClicked() 
	{
		//Changing scenes on clicking the back button
		screenController.activate("LoginScreen");
	}
	
	
	
}
