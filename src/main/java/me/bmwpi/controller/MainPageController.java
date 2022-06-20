package me.bmwpi.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import me.bmwpi.App;

public class MainPageController {
    @FXML
    private Label testLbl;

    private String test;
    public MainPageController() {
        test = "5";
    }

    @FXML
    private void switchToLiveData() throws IOException {
        App.setRoot("livedata");
    }

    @FXML
    private void switchToTravelMode() throws IOException {
        App.setRoot("travelmode");
    }


}
