package tdt4140.gr1805.app.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StatisticsScreenController 
{
	public MasterScreenController screenController;
	@FXML
	private Button showMeanButton;
	@FXML
	private TextField showMeanField;
	@FXML
	private TextArea statisticsScreenTextArea1;
	
	
	
	
	 //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}

}
