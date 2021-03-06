package tdt4140.gr1805.app.ui;

import java.util.HashMap;
import java.util.ServiceConfigurationError;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tdt4140.gr1805.app.core.data.Database;
import tdt4140.gr1805.app.core.server.Server;

public class MasterScreenController {
	
	
	//HashMap input is a String and a Pane-view. Every controller shares the same instance of the MasterScreenController-object
	//You can use the String-input as a Key, that points at the Pane-view. This makes switching scenes easy.
	
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;
    private Stage stage;
    private int ID;
    private Database db = new Database();

    //Sets stage.
    public MasterScreenController(Scene main,Stage stage) {
        this.main = main;
        this.stage = stage;
        new Server(db).start();
    }

    
    
    //method for adding Pane-views. Input is Pane name, and Pane-object.
    protected void addScreen(String name, Pane pane){
         screenMap.put(name, pane);
    }
    
    //method for removing Pane-views. Input is String name. Deletes correspondning Pane.
    protected void removeScreen(String name){
        screenMap.remove(name);
    }
    
    //Activate new Pane-views. Input is String --> Same as constructor String. Calls Pane which points at String-key.
    public void activate(String name){
        main.setRoot(screenMap.get(name));
        stage.setTitle("PU-prosjekt");
        stage.setScene(main);
        stage.show();
    }
    
    //Stores the current logged in user in the master controller
    
    public void setCurrentUserID(int ID) {
    		this.ID = ID;
    }
    public int getCurrentUserID() {
    		return ID;
    }
    public Database getDatabase() {
    	return db;
    }
}
