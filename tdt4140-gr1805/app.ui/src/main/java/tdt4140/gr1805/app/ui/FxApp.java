package tdt4140.gr1805.app.ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FxApp extends Application {
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    Pane root = new Pane();
    

    LoginScreen LoginScene = new LoginScreen(width,height,root);
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(LoginScene.login);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
