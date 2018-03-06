package tdt4140.gr1805.app.ui;

import java.awt.Font;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class LoginScreen {
	public Scene login;

	private int width;
	private int height;
	
	public LoginScreen(int width,int height,Pane root) {
		this.width = width;
		this.height = height;
		
		Text loginText = new Text();
		
		
		loginText.setFont(new javafx.scene.text.Font(20));
		loginText.setText("Velkommen\nLogg inn her");
		loginText.setTextAlignment(TextAlignment.CENTER);
		loginText.relocate(0.5*width, 0.12*height);
		
		root.getChildren().add(loginText);
		this.login = new Scene(root,width,height);
		
	}
}