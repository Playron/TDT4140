package tdt4140.gr1805.app.ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RecordActivityScreenController {
	
	public MasterScreenController screenController;
	
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
	
	@FXML
	public void backToMenu(ActionEvent event) throws IOException {
		screenController.activate("MenuScreen");
	}
	
	@FXML
	public void openWhileActivityScreen() {
		screenController.activate("WhileActivityScreen");
	}

}
