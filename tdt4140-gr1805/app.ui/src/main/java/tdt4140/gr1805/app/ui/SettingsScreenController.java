package tdt4140.gr1805.app.ui;

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
}
