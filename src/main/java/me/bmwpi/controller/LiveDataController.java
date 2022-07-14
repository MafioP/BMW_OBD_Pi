package me.bmwpi.controller;

import eu.hansolo.medusa.Gauge;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.PidGauges;
import me.bmwpi.model.PidModel;

import java.io.IOException;

public class LiveDataController {
    private PidModel model;
    private ScriptHandler scriptHandler;
    private SocketHandler socketHandler;
    private Thread socketThread;
    private Thread scriptThread;

    @FXML
    private VBox rpmVBox;
    @FXML
    private VBox coolTempVBox;
    @FXML
    private VBox oilTempVBox;
    @FXML
    private VBox boostVBox;


    public void initialize() {
        System.out.println("Controller created");
        model = setModel();
        setGauges();
        handleScript();
    }

    public PidModel setModel() {
        model = new PidModel();
        return model;
    }

    private void handleScript() {
        Thread stopLiveDataThread = new Thread(() -> {
            try {
                stopHandlers();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Runtime.getRuntime().addShutdownHook(stopLiveDataThread);
        socketHandler = new SocketHandler(model);
        socketThread = new Thread(socketHandler);
        socketThread.setDaemon(true);
        socketThread.start();
        scriptHandler = new ScriptHandler();
        scriptThread = new Thread(scriptHandler);
        scriptThread.setDaemon(true);
        scriptThread.start();
    }

    private void stopHandlers() throws IOException {
        socketHandler.stopSocket();
        socketThread.interrupt();
        scriptHandler.stopScript();
        scriptThread.interrupt();
    }
    public void switchToMainPage() throws IOException {
        stopHandlers();
        BMW_Pi_Main.setRoot("mainpage");
    }

    public void setGauges() {
        Gauge rpmGauge = PidGauges.getRpmGauge();
        rpmVBox.getChildren().add(rpmGauge);
        rpmGauge.valueProperty().bind(model.rpmProperty());

        Gauge coolantGauge = PidGauges.getCoolantTempGauge();
        coolTempVBox.getChildren().add(coolantGauge);
        coolantGauge.valueProperty().bind(model.coolantTempProperty());

        Gauge airInTempGauge = PidGauges.getIntakeTempGauge();
        oilTempVBox.getChildren().add(airInTempGauge);
        airInTempGauge.valueProperty().bind(model.airInTempProperty());

        Gauge boostGauge = PidGauges.getBoostGauge();
        boostVBox.getChildren().add(boostGauge);
        boostGauge.valueProperty().bind(model.boostPressureProperty());
    }


}