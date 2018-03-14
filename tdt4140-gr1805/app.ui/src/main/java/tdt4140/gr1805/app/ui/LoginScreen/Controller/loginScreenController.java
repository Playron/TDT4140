package tdt4140.gr1805.app.ui.LoginScreen.Controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class loginScreenController extends Application {

	
	@FXML
	public void logInButtonClicked() {
		System.out.println("Du er logget inn!");
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
