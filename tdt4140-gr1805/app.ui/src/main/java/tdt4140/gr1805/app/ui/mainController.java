package tdt4140.gr1805.app.ui;

import java.lang.ModuleLayer.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class mainController extends Application {
	public loginScreenController loginController;
	public registrationScreenController registrationController;
    public MasterScreenController screenController;
    public Stage stage;
    
    public static void main(String[] args) {
        launch(args);
    }
	
    @Override
    public void start(Stage stage) throws Exception {
    		this.stage = stage;
    	    screenController = new MasterScreenController(new Scene(new AnchorPane()),stage);
    	    
    	    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
    	    screenController.addScreen("LoginScreen",(Pane)loader1.load());
    	    loginScreenController controller1 = loader1.getController();
    	    controller1.setScreenController(screenController);
    	    
    	    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("RegistrationScreen.fxml"));
    	    screenController.addScreen("RegistrationScreen",(Pane)loader2.load());
    	    registrationScreenController controller2 = loader2.getController();
    	    controller2.setScreenController(screenController);
    		
        screenController.activate("LoginScreen");
        
    }
    
    
    public void switchScene(String sceneName) {
    	screenController.activate(sceneName);
    }
    

    
    
}
