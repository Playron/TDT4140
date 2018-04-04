package tdt4140.gr1805.app.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import tdt4140.gr1805.app.core.data.Database;

public class SettingsScreenController 
{
	public MasterScreenController screenController;
	@FXML
	private Button settingsScreenBackToMenu;
	@FXML
	private Button deleteUserButton;
	
	
	
	
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}
	
	@FXML
	public void backToMenu(ActionEvent event) throws IOException 
	{
		screenController.activate("MenuScreen");
	}
	@FXML
	public void deleteUser(ActionEvent event) throws IOException 
	{
		Database db = new Database();
		//Removing person by current ID
		db.removePerson(screenController.getCurrentUserID());
		screenController.activate("LoginScreen");
	}
	
	
}
