package tdt4140.gr1805.app.ui.LoginScreen.Controller;



import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginScreenController extends Application  {
	@FXML
	private Button loggInn;
	@FXML
	private TextField ID;
	@FXML
	private Label duHarLoggetInn;
	@FXML
	
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
		System.out.println("ID må være heltall");
		return false;
		}
		
		
	}
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

