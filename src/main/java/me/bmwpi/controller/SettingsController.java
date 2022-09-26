package me.bmwpi.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.Settings;
import me.bmwpi.model.SupportedValues;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SettingsController {
    @FXML
    ListView<String> availableValuesList;
    @FXML
    ListView<String> usedValuesList;
    @FXML
    Slider delaySlider;
    @FXML
    ComboBox<String> modeComboBox;

    public void initialize() {
        availableValuesList.setItems(FXCollections.observableList(Stream.of(SupportedValues.values())
                .map(SupportedValues::name)
                .collect(Collectors.toList())));
        usedValuesList.getItems().addAll(Settings.getUsedValues());
        availableValuesList.getItems().removeAll(usedValuesList.getItems());
        modeComboBox.getItems().addAll(Arrays.asList("Live Mode", "Sim Mode"));
        modeComboBox.getSelectionModel().select(Settings.getMODE());
    }

    @FXML
    public void switchToMainPage() throws IOException {
        BMW_Pi_Main.setRoot("mainpage");
    }

    @FXML
    public void addValueToList(ActionEvent actionEvent) {
        String selected = availableValuesList.getSelectionModel().getSelectedItem();
        usedValuesList.getItems().add(selected);
        Settings.addUsedValue(selected);
        availableValuesList.getItems().remove(selected);
    }

    @FXML
    public void removeValFromList(ActionEvent actionEvent) {
        String selected = usedValuesList.getSelectionModel().getSelectedItem();
        usedValuesList.getItems().remove(selected);
        Settings.removeUsedValue(selected);
        availableValuesList.getItems().add(selected);
    }

    @FXML
    public void clearList(ActionEvent actionEvent) {
        availableValuesList.getItems().addAll(usedValuesList.getItems());
        Settings.clearAll();
        usedValuesList.getItems().clear();
    }

    @FXML
    public void setDelay(MouseEvent dragEvent) {
        Settings.setDELAY(delaySlider.getValue()/1000);
    }

    @FXML
    public void setMode(ActionEvent actionEvent) {
        Settings.setMODE(modeComboBox.getSelectionModel().getSelectedIndex());
    }
}
