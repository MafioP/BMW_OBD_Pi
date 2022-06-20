package me.bmwpi.controller;

import javafx.event.ActionEvent;
import me.bmwpi.App;

import java.io.IOException;

public class TravelModeController {

    public void switchToMainPage() throws IOException {
        App.setRoot("mainpage");
    }
}
