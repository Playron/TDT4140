package tdt4140.gr1805.app.ui;


import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class FxAppController extends Application implements EventHandler<ActionEvent> {
	private Stage registrationStage;
	private BorderPane registrationLayout;
	
	
	@Override
	public void start(Stage registrationStage) throws Exception {
		this.registrationStage = registrationStage;
		this.registrationStage.setTitle("RegistrationForm");
		showRegistrationView();
	}
	
	private void showRegistrationView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxAppController.class.getResource("src/tdt4140/gr1805/app/ui/RegistrationView.fxml"));
		registrationLayout = loader.load();
		Scene scene = new Scene(registrationLayout);
		registrationStage.setScene(scene);
		registrationStage.show();
	}
	
	
	public void initialize() {
		
	}


	@Override
	public void handle(ActionEvent event) {
			
		}

		
	}



