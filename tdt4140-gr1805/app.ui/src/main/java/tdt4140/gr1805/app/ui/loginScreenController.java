package tdt4140.gr1805.app.ui;



import java.io.IOException;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tdt4140.gr1805.app.core.data.Database;
import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;

public class loginScreenController{
	public MasterScreenController screenController;
	Database db;
	
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
		this.db = this.screenController.getDatabase();
	}
	
	//Logic for the LoginButton.
	public void logInButtonClicked() {
	
		int id = Integer.parseInt(ID_TextField.getText());
		
		if(checkLoginInt(ID_TextField, id) == false) {
			duHarLoggetInn.setText("Login-ID must be an integer!");
		}
			//Admin ID is 0!
		else if(Integer.parseInt(ID_TextField.getText()) == 0) {
			screenController.activate("StatisticsAdmin");
				//screenController.activate("AdminScreen");
			}
			
			//If user does not exist, throw exception! 
		else if(db.getPerson(id) == null) {
				duHarLoggetInn.setText("The user does not exist!");
				
			}				
				
		else if(db.getPerson(id) != null){
				
				duHarLoggetInn.setText("");
				screenController.setCurrentUserID(id);
				screenController.activate("MenuScreen");
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

