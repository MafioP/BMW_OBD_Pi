package me.bmwpi.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import me.bmwpi.BMW_Pi_Main;

import java.io.IOException;

public class DataloggerController {

    @FXML
    private HBox loggerHBox;
    private LineChart<Number, Number> lineChart;

    private final int CHARTSIZE = 50;

    public void initialize() {
        NumberAxis xAxis = new NumberAxis(0, CHARTSIZE, 1);
        xAxis.setForceZeroInRange(false);
        xAxis.setAutoRanging(false);
        xAxis.setTickLabelsVisible(false);
        xAxis.setTickMarkVisible(false);
        xAxis.setMinorTickVisible(false);
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis) {
            @Override
            protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {
            }
        };
        loggerHBox.getChildren().add(lineChart);
    }
    @FXML
    public void switchToMainPage() throws IOException {
        BMW_Pi_Main.setRoot("mainpage");
    }
}
