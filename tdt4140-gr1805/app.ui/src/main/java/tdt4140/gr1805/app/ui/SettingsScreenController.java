package tdt4140.gr1805.app.ui;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import tdt4140.gr1805.app.core.data.Database;
import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;

public class SettingsScreenController 
{
	public MasterScreenController screenController;
	@FXML
	private Button settingsScreenBackToMenu;
	@FXML
	private Button deleteUserButton;
	
	Database db;


	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
		this.db = this.screenController.getDatabase();
	}

	@FXML
	public void backToMenu(ActionEvent event) throws IOException 
	{
		screenController.activate("MenuScreen");
	}
	@FXML
	public void deleteUser(ActionEvent event) throws IOException, URISyntaxException 
	{
		//Removing person by current ID
		db.removePerson(screenController.getCurrentUserID());
		db.writeObjects();
		screenController.activate("LoginScreen");
	}

	@FXML
	public void toggleGPS(ActionEvent event) throws IOException, URISyntaxException {
		Person p=db.getPerson(screenController.getCurrentUserID());	
		p.setGatherLocation(!p.isGatherLocation());
		System.out.println("Location gathering is set to " + p.isGatherLocation());
		db.updatePerson(p);
		db.writeObjects();
		db.readPeople();
		System.out.println(p.isGatherLocation());
	}

}
