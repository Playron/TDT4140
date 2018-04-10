package tdt4140.gr1805.app.ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;



public class AdminScreenController {
	@FXML
	private Button stavangerButton;
	@FXML
	private Button bergenButton;
	@FXML
	private Button osloButton;
	@FXML
	private Button tromsoeButton;
	@FXML
	private Button kristiansandButton;
	@FXML
	private Button trondheimButton;
	
	public MasterScreenController screenController;
	
	
	
	public void setScreenController(MasterScreenController screenController) {
		this.screenController = screenController;
	}
	
	@FXML
	public void stavangerButtonClicked(ActionEvent event) throws IOException {
		
		System.out.println("Statistikk for Stavanger");
	}
	
	@FXML
	public void bergenButtonClicked(ActionEvent event) throws IOException {
		
		System.out.println("Statistikk for Bergen");
	}
	
	@FXML
	public void osloButtonClicked(ActionEvent event) throws IOException {
		
		System.out.println("Statistikk for Oslo");
	}
	
	@FXML
	public void tromsoeButtonClicked(ActionEvent event) throws IOException {
		
		System.out.println("Statistikk for Tromsoe");
	}
	
	@FXML
	public void kristiansandButtonClicked(ActionEvent event) throws IOException {
		
		System.out.println("Statistikk for Kristiansand");
	}
	
	@FXML
	public void trondheimButtonClicked(ActionEvent event) throws IOException {
		
		System.out.println("Statistikk for Trondheim");
	}
	
}
