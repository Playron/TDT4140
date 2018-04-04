package tdt4140.gr1805.app.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;



public class AdminScreenController {
	@FXML
	private ChoiceBox ByChoiceBox;
	
	public MasterScreenController screenController;
	ObservableList<String> byListe = FXCollections.observableArrayList("Ingen","Trondheim","Oslo","Bergen","Stavanger","Kristiansand","Tromsoe");
	
	@FXML
	private void initialize() {
		ByChoiceBox.setValue("Ingen");
		ByChoiceBox.setItems(byListe);
		
	}
	
	
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
	
}
