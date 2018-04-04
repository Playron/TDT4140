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
	private TextField ID_TextField;
	@FXML
	private Label duHarLoggetInn;
	@FXML
	AnchorPane rootPane;
	
	
    //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
	
	//Logic for the LoginButton.
	public void logInButtonClicked() {
		int id = Integer.parseInt(ID_TextField.getText());
		
		if(checkLoginInt(ID_TextField, id) == true) 
		{
			//Checking for admin ID (Which is zero)
			
			if(Integer.parseInt(ID_TextField.getText()) == 0) {
				screenController.activate("AdminScreen");
			}
			else {
				duHarLoggetInn.setText(ID_TextField.getText() + " har logget inn!");
				screenController.setCurrentUserID(id);
				screenController.activate("MenuScreen");
			}
		}
		else {
			duHarLoggetInn.setText("Login-ID must be an integer!");
		}
	}
	//Method checks if login-textField only inputs INTEGER. Throws a NumberFormatException if input is not an INTEGER.
	public boolean checkLoginInt(TextField input, int id) {
		try {
			
			System.out.println("User id is: " + id);
			return true;
			
		}catch(NumberFormatException e) {
		System.out.println("ID must be an integer");
		return false;
		}
		
		
	}
	
	//Changing scenes on clicking the registration button
	@FXML
	public void signupUser(ActionEvent event) throws IOException {
		
		screenController.activate("RegistrationScreen");
		
	}
}

