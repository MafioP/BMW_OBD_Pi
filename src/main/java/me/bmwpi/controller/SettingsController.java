package me.bmwpi.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.Settings;
import me.bmwpi.model.SupportedValues;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SettingsController {
    @FXML
    ListView<String> availableValuesList;
    @FXML
    ListView<String> usedValuesList;

    public void initialize() {
        availableValuesList.setItems(FXCollections.observableList(Stream.of(SupportedValues.values())
                .map(SupportedValues::name)
                .collect(Collectors.toList())));
        usedValuesList.setItems(Settings.getUsedValues());
        availableValuesList.getItems().removeAll(usedValuesList.getItems());
    }

    @FXML
    public void switchToMainPage() throws IOException {
        BMW_Pi_Main.setRoot("mainpage");
    }

    public void addValueToList(ActionEvent actionEvent) {
        String selected = availableValuesList.getSelectionModel().getSelectedItem();
        usedValuesList.getItems().add(selected);
        Settings.addUsedValue(selected);
        availableValuesList.getItems().remove(selected);
    }

    public void removeValFromList(ActionEvent actionEvent) {
        String selected = usedValuesList.getSelectionModel().getSelectedItem();
        usedValuesList.getItems().remove(selected);
        Settings.removeUsedValue(selected);
        availableValuesList.getItems().add(selected);
    }

    public void clearList(ActionEvent actionEvent) {
        availableValuesList.getItems().addAll(usedValuesList.getItems());
        Settings.clearAll();
        usedValuesList.getItems().clear();
    }
}
