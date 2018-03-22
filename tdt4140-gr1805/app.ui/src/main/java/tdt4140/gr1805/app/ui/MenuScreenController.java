package tdt4140.gr1805.app.ui;

import javafx.fxml.FXML;

public class MenuScreenController 
{
	public MasterScreenController screenController;
	
	
	  
	 //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}
	
	@FXML
	public void openSettingsScreen() {
		screenController.activate("SettingsScreen");
	}
	
	@FXML
	public void openStatisticsScreen() {
		screenController.activate("StatisticsScreen");
	}
	
	@FXML
	public void openUserScreen() {
		screenController.activate("UserScreen");
	}
	
	
}
