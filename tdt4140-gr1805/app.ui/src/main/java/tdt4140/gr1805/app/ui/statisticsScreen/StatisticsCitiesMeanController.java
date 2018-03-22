package tdt4140.gr1805.app.ui.statisticsScreen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import tdt4140.gr1805.app.ui.MasterScreenController;


public class StatisticsCitiesMeanController 
{
	public MasterScreenController screenController;

	
	
	
	
	 //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}
	
	//Changing scenes on clicking the registration button
	@FXML
	public void backToMenu(ActionEvent event) throws IOException 
	{
		screenController.activate("MenuScreen");
	}

}
