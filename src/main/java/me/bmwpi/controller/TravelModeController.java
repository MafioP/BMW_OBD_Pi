package me.bmwpi.controller;

import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.PidModel;

import java.io.IOException;

public class TravelModeController {

    public void switchToMainPage() throws IOException {
        BMW_Pi_Main.setRoot("mainpage");
    }

}
