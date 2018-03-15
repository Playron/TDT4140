package tdt4140.gr1805.app.ui;



import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class loginScreenController{
	public MasterScreenController screenController;
	@FXML
	private Button loggInn;
	@FXML
	private TextField ID;
	@FXML
	private Label duHarLoggetInn;
	@FXML
	AnchorPane rootPane;
	
	
    //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
	
	//Logic for the LoginButton
	public void logInButtonClicked() {
		if(checkLoginInt(ID) == true) {
			duHarLoggetInn.setText(ID.getText() + " har logget inn!");
		}
	}
	
	public boolean checkLoginInt(TextField input) {
		try {
			int id = Integer.parseInt(input.getText());
			System.out.println("BrukerID er:" + id);
			return true;
			
		}catch(NumberFormatException e) {
		System.out.println("ID maa vaere heltall");
		return false;
		}
		
		
	}
	
	//Changing scenes on clicking the registration button
	@FXML
	public void signupUser(ActionEvent event) throws IOException {
		
		screenController.activate("RegistrationScreen");
		
	}
}

