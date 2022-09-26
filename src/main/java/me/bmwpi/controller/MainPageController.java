package me.bmwpi.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import me.bmwpi.BMW_Pi_Main;

public class MainPageController {

    @FXML
    private void switchToLiveData() throws IOException {
        BMW_Pi_Main.setRoot("livedata");
    }

    @FXML
    private void switchToTravelMode() throws IOException {
        BMW_Pi_Main.setRoot("travelmode");
    }

    @FXML
    private void switchToSettings() throws IOException {
        BMW_Pi_Main.setRoot("settings");
    }

    @FXML
    public void switchToDataLogger() throws IOException {
        BMW_Pi_Main.setRoot("datalogger");
    }
}
