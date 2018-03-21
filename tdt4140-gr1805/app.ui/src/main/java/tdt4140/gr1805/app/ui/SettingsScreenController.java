package tdt4140.gr1805.app.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SettingsScreenController 
{
	public MasterScreenController screenController;
	@FXML
	private Button settingsScreenBackToMenu;
	
	
	
	
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}
	
	@FXML
	public void backToMenu(ActionEvent event) throws IOException 
	{
		screenController.activate("MenuScreen");
	}
	
	
}
