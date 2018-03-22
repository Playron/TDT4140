
package tdt4140.gr1805.app.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainController extends Application
{
	public loginScreenController loginController;
	public registrationScreenController registrationController;
	public MasterScreenController screenController;
	public Stage stage;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		// Stage is the root level object of the UI, screenController controls which
		// scene is going to show on the stage.
		this.stage = stage;
		screenController = new MasterScreenController(new Scene(new AnchorPane()), stage);

		// -------- Login Screen ------------ //

		// Loading the FXML-file, injecting the screenController into the constructor of
		// the controllers.
		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
		screenController.addScreen("LoginScreen", (Pane) loader1.load());
		loginScreenController controller1 = loader1.getController();
		controller1.setScreenController(screenController);

		// -------- Registration Screen ------------ //

		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("RegistrationScreen.fxml"));
		screenController.addScreen("RegistrationScreen", (Pane) loader2.load());
		registrationScreenController controller2 = loader2.getController();
		controller2.setScreenController(screenController);

		// -------- Statistics Screen ------------ //

		FXMLLoader loader3 = new FXMLLoader(getClass().getResource("StatisticsScreen.fxml"));
		screenController.addScreen("StatisticsScreen", (Pane) loader3.load());
		StatisticsScreenController controller3 = loader3.getController();
		controller3.setScreenController(screenController);

		// -------- Menu Screen (after login success) ------------ //

		FXMLLoader loader4 = new FXMLLoader(getClass().getResource("MenuScreen.fxml"));
		screenController.addScreen("MenuScreen", (Pane) loader4.load());
		MenuScreenController controller4 = loader4.getController();
		controller4.setScreenController(screenController);

		// -------- Menu Screen (after login success) ------------ //
		FXMLLoader loader5 = new FXMLLoader(getClass().getResource("SettingsScreen.fxml"));
		screenController.addScreen("SettingsScreen", (Pane) loader5.load());
		SettingsScreenController controller5 = loader5.getController();
		controller5.setScreenController(screenController);
		// Activating the relevant scene
		screenController.activate("LoginScreen");

	}

}
