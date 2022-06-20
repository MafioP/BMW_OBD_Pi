package me.bmwpi.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import me.bmwpi.App;

public class LiveDataController {

    public void switchToMainPage() throws IOException {
        App.setRoot("mainpage");
    }
}