package me.bmwpi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class BMW_Pi_Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Parent loader = loadFXML("mainpage");
        scene = new Scene(loader, 1280, 400);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop!");
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        return new FXMLLoader(BMW_Pi_Main.class.getResource(fxml + ".fxml")).load();
    }

    public static void main(String[] args) {
        launch();
    }

}