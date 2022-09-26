package me.bmwpi.controller;

import eu.hansolo.medusa.Gauge;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.PidGauges;
import me.bmwpi.model.PidModel;
import me.bmwpi.model.Settings;

import java.io.IOException;

public class LiveDataController {
    private PidModel model;
    private ScriptHandler scriptHandler;
    private SocketHandler socketHandler;
    private Thread socketThread;
    private Thread scriptThread;

    @FXML
    private FlowPane gaugePane;

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
        Settings.getUsedValues().forEach( e -> {
            switch (e){
                case "rpm":
                    Gauge rpmGauge = PidGauges.getRpmGauge();
                    gaugePane.getChildren().add(rpmGauge);
                    rpmGauge.valueProperty().bind(model.rpmProperty());
                    break;
                case "coolTemp":
                    Gauge coolantGauge = PidGauges.getCoolantTempGauge();
                    gaugePane.getChildren().add(coolantGauge);
                    coolantGauge.valueProperty().bind(model.coolantTempProperty());
                    break;
                case "airInTemp":
                    Gauge airInTempGauge = PidGauges.getIntakeTempGauge();
                    gaugePane.getChildren().add(airInTempGauge);
                    airInTempGauge.valueProperty().bind(model.airInTempProperty());
                    break;
                case "boost":
                    Gauge boostGauge = PidGauges.getBoostGauge();
                    gaugePane.getChildren().add(boostGauge);
                    boostGauge.valueProperty().bind(model.boostPressureProperty());
                    break;
                case "engLoad":
                    Gauge loadGauge = PidGauges.getEngineLoadGauge();
                    gaugePane.getChildren().add(loadGauge);
                    loadGauge.valueProperty().bind(model.engineLoadProperty());
                    break;
                case "torque":
                    Gauge torqueGauge = PidGauges.getTorqueGauge();
                    gaugePane.getChildren().add(torqueGauge);
                    torqueGauge.valueProperty().bind(model.torqueProperty());
                    break;
                case "speed":
                    Gauge speedGauge = PidGauges.getSpeedGauge();
                    gaugePane.getChildren().add(speedGauge);
                    speedGauge.valueProperty().bind(model.speedProperty());
                    break;
            }
        });





    }
}