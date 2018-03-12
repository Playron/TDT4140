package tdt4140.gr1805.app.ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tdt4140.gr1805.app.ui.*;
import tdt4140.gr1805.app.core.*;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;
import javafx.stage.Stage;

public class registrationScreenController extends Application {

	@FXML
	TextField dag_ID;
	@FXML
	TextField mÃ¥ned_ID;
	@FXML
	TextField Ã¥r_ID;
	@FXML
	Label logInMessage;
	
	
	@FXML
	public void registerUser() {
		int dag = Integer.parseInt(dag_ID.getText());
		int måned = Integer.parseInt(mÃ¥ned_ID.getText());
		int år = Integer.parseInt(Ã¥r_ID.getText());
		Person person = new Person(år, måned, dag, Gender.MALE);
		System.out.println(person);
		logInMessage.setText(person.toString());
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
