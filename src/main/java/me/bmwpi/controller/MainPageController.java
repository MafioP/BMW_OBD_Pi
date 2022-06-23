package me.bmwpi.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.PidModel;

public class MainPageController {

    @FXML
    private Label testLbl;

    private String test;
    public MainPageController() {
        test = "5";
    }

    @FXML
    private void switchToLiveData() throws IOException {
        BMW_Pi_Main.setRoot("livedata");
    }

    @FXML
    private void switchToTravelMode() throws IOException {
        BMW_Pi_Main.setRoot("travelmode");
    }
}
