package tdt4140.gr1805.app.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StatisticsScreenController 
{
	public MasterScreenController screenController;
	@FXML
	private Button showMeanButton;
	
	
	
	
	 //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}

}
