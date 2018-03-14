package tdt4140.gr1805.app.ui;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MasterScreenController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;
    private Stage stage;

    public MasterScreenController(Scene main,Stage stage) {
        this.main = main;
        this.stage = stage;
    }

    protected void addScreen(String name, Pane pane){
         screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        main.setRoot(screenMap.get(name));
        stage.setTitle("Test");
        stage.setScene(main);
        stage.show();
    }
}