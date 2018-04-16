package tdt4140.gr1805.app.ui.statisticsScreen;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ChoiceBox;
import javafx.util.Pair;
import tdt4140.gr1805.app.core.analysis.Statistics;
import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.ui.MasterScreenController;


public class StatisticsAdminController 
{
	public MasterScreenController screenController;
	ObservableList<City> cityList = FXCollections.observableArrayList(City.BERGEN, City.KRISTIANSAND, City.OSLO, City.TROMSOE, City.TRONDHEIM, City.STAVANGER);

	@FXML
	private NumberAxis xAxis;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private LineChart<Number, Number> lC;
	@FXML
	private ChoiceBox<City> cityBox;
	
	@FXML
	private void initialize()
	{
		cityBox.setItems(cityList);
		cityBox.getSelectionModel().selectFirst();
	}
	
	 //Setting the screen controller
	public void setScreenController(MasterScreenController screenController) 
	{
		this.screenController = screenController;
	}
	
	//Changing scenes on clicking the registration button
	@FXML
	public void backToMenu(ActionEvent event) throws IOException 
	{
		lC.getData().clear();
		screenController.activate("MenuScreen");
	}
	
	@FXML
	public void showAveragePulse(ActionEvent event)
	{
		lC.getData().clear();
		Series<Number, Number> series = Statistics.averagePulseSeriesByCity(LocalDateTime.now().minusDays(120), LocalDateTime.now().minusDays(60), cityBox.getSelectionModel().getSelectedItem(), 60);
		series.setName("Pulse");
		lC.getData().add(series);
	}
	
	@FXML
	public void showAllAveragePulse()
	{
		lC.getData().clear();
		for (int i = 0; i < cityList.size(); i++)
		{
			Series<Number, Number> series = Statistics.averagePulseSeriesByCity(LocalDateTime.now().minusDays(120), LocalDateTime.now().minusDays(60), cityList.get(i), 60);
			series.setName(cityList.get(i).toString());
			lC.getData().add(series);
		}
	}
	
	@FXML
	public void showExercises()
	{
		lC.getData().clear();
		ArrayList<Pair<Exercise, Integer>> stat = Statistics.exerciseCounts(screenController.getDatabase().getWorkoutsByCity(cityBox.getSelectionModel().getSelectedItem()), true);
		for (int i = 0; i < stat.size(); i++)
		{
			Series<Number, Number> series = new Series<>();
			series.getData().add(new Data<Number, Number>(i, stat.get(i).getValue()));
			series.setName(stat.get(i).getKey().toString());
			lC.getData().add(series);
		}
	}

}
