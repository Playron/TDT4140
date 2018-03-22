package tdt4140.gr1805.app.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StatisticsScreenController 
{
	public MasterScreenController screenController;
	@FXML
	private Button statisticsScreenShowMeanButton;
	@FXML
	private TextField statisticsScreenShowMeanField;
	@FXML
	private TextArea statisticsScreenTextArea1;
	@FXML
	private Button statisticsScreenBackToMenyButton;
	
	
	
	
	 //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}
	
	//Changing scenes on clicking the Back to Menu button
	@FXML
	public void backToMenu(ActionEvent event) throws IOException 
	{
		screenController.activate("MenuScreen");
	}
	
	//Changing scenes on clicking the Back to Menu button
		@FXML
		public void toPersonalStatistics(ActionEvent event) throws IOException 
		{
			screenController.activate("StatisticsMean");
		}
	
		
		//Changing scenes on clicking the Back to Menu button
		@FXML
		public void toCityStatistics(ActionEvent event) throws IOException 
		{
			screenController.activate("StatisticsCitiesMean");
		}
	

}
