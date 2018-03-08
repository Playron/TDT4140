package tdt4140.gr1805.app.ui.registration;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class RegMain extends Application {
	private Stage registrationStage;
	private BorderPane registrationLayout;
	
	@Override
	public void start(Stage registrationStage) throws IOException {
		this.registrationStage = registrationStage;
		this.registrationStage.setTitle("RegistrationForm");
		showRegistrationView();
		//showMainItems();
	}
	
	public void showRegistrationView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(RegMain.class.getResource("view/MainView.fxml"));
		registrationLayout = loader.load();
		Scene scene = new Scene(registrationLayout);
		registrationStage.setScene(scene);
		registrationStage.show();
	}
	
	@FXML
	public void registrationButtonClicked() {
		System.out.println("Bruker er registrert!");
	}
	
/*	public void showMainItems() throws IOException {
		FXMLLoader loader1 = new FXMLLoader();
		loader1.setLocation(RegMain.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader1.load();
		registrationLayout.setCenter(mainItems);
		
	}
*/
	public static void main(String[] args) {
		launch(args);
	}
}
