package tdt4140.gr1805.app.ui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import tdt4140.gr1805.app.core.person.*;
import tdt4140.gr1805.app.core.*;




public class LoginScreen implements EventHandler<ActionEvent> {
	public Scene login;

	private int width;
	private int height;
	Button loginButton;
	String ID;
	int id;
	
	public LoginScreen(int width,int height,Pane root) {
		this.width = width;
		this.height = height;
		
		
		
		Text welcomeText = new Text();
		welcomeText.setFont(new Font(25));
		welcomeText.setText("Velkommen!");
		welcomeText.setTextAlignment(TextAlignment.CENTER);
		welcomeText.relocate(0.45*width, 0.05*height);
		
		Text loginText = new Text();
		loginText.setFont(new Font(20));
		loginText.setText("Skriv inn ID:");
		loginText.setTextAlignment(TextAlignment.CENTER);
		loginText.relocate(0.45*width, 0.45*height);
		
		TextField idText = new TextField();
		idText.setPrefHeight(50);
		idText.relocate(0.45*width, 0.5*height);
		ID = idText.getText();
		id = Integer.parseInt(ID);
		
		loginButton = new Button("Logg inn");
		loginButton.relocate(0.47*width,0.57*height);
		loginButton.setPrefWidth(100);
		loginButton.setOnAction(this);
		
		
		
		root.getChildren().add(welcomeText);
		root.getChildren().add(loginText);
		root.getChildren().add(idText);
		root.getChildren().add(loginButton);
		
		this.login = new Scene(root,width,height);
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		Liste liste = new Liste();
		Person person = new Person(1991, 02, 20, Gender.MALE);
		if(event.getSource() == loginButton) {
			
		}
		
	}
}