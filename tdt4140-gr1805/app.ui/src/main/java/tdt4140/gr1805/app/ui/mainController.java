
package tdt4140.gr1805.app.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tdt4140.gr1805.app.ui.statisticsScreen.StatisticsCitiesMeanController;
import tdt4140.gr1805.app.ui.statisticsScreen.StatisticsMeanController;


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
		activateStatisticsScreen();

		// -------- Menu Screen (after login success) ------------ //

		FXMLLoader loader4 = new FXMLLoader(getClass().getResource("MenuScreen.fxml"));
		screenController.addScreen("MenuScreen", (Pane) loader4.load());
		MenuScreenController controller4 = loader4.getController();
		controller4.setScreenController(screenController);

		// -------- Settings Screen ------------ //
		
		FXMLLoader loader5 = new FXMLLoader(getClass().getResource("SettingsScreen.fxml"));
		screenController.addScreen("SettingsScreen", (Pane) loader5.load());
		SettingsScreenController controller5 = loader5.getController();
		controller5.setScreenController(screenController);
		
		// -------- User Screen ------------ //

		FXMLLoader loader6 = new FXMLLoader(getClass().getResource("UserScreen.fxml"));
		screenController.addScreen("UserScreen", (Pane) loader6.load());
		UserScreenController controller6 = loader6.getController();
		controller6.setScreenController(screenController);
		
		FXMLLoader loader7 = new FXMLLoader(getClass().getResource("AdminScreen.fxml"));
		screenController.addScreen("AdminScreen", (Pane) loader7.load());
		AdminScreenController controller7 = loader7.getController();
		controller7.setScreenController(screenController);
		
		//-------RecordActivityScreen------------//
		
		FXMLLoader loader8 = new FXMLLoader(getClass().getResource("RecordActivityScreen.fxml"));
		screenController.addScreen("RecordActivityScreen", (Pane) loader8.load());
		RecordActivityScreenController controller8 = loader8.getController();
		controller8.setScreenController(screenController);
		
		
		
		// Activating the relevant scene
		screenController.activate("LoginScreen");

	}

	public void activateStatisticsScreen() throws Exception
	{
		// -------- Statistics Cities Mean Screen ------------ //

		FXMLLoader statLoader1 = new FXMLLoader(getClass().getResource("statisticsScreen/StatisticsCitiesMean.fxml"));
		screenController.addScreen("StatisticsCitiesMean", (Pane) statLoader1.load());
		StatisticsCitiesMeanController statController1 = statLoader1.getController();
		statController1.setScreenController(screenController);

		// -------- Statistics Mean Screen ------------ //

		FXMLLoader statLoader2 = new FXMLLoader(getClass().getResource("statisticsScreen/StatisticsMean.fxml"));
		screenController.addScreen("StatisticsMean", (Pane) statLoader2.load());
		StatisticsMeanController statController2 = statLoader2.getController();
		statController2.setScreenController(screenController);
/*
		// -------- Statistics Cities Median Screen ------------ //

		FXMLLoader statLoader3 = new FXMLLoader(getClass().getResource("statisticsScreen/StatisticsCitiesMedian.fxml"));
		screenController.addScreen("StatisticsCitiesMedian", (Pane) statLoader3.load());
		StatisticsCitiesMedianController statController3 = statLoader3.getController();
		statController3.setScreenController(screenController);
*/
/*		// -------- Statistics Median Screen ------------ //

		FXMLLoader statLoader4 = new FXMLLoader(getClass().getResource("statisticsScreen/StatisticsMedian.fxml"));
		screenController.addScreen("StatisticsMean", (Pane) statLoader4.load());
		StatisticsMedianController statController4 = statLoader4.getController();
		statController4.setScreenController(screenController);
*/
	}

}
