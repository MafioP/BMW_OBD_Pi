package me.bmwpi.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    private static int MODE = 2;
    private static double DELAY = 0.5;
    private static final ArrayList<String> usedValues = new ArrayList<>(Arrays.asList("rpm", "coolTemp", "airInTemp", "boost"));


    public static double getDELAY() {
        return DELAY;
    }

    public static int getMODE() {
        return MODE;
    }

    public static void setDELAY(double DELAY) {
        Settings.DELAY = DELAY;
    }

    public static void setMODE(int MODE) {
        Settings.MODE = MODE;
    }

    public static ObservableList<String> getUsedValues() {
        return FXCollections.observableList(usedValues);
    }

    public static void addUsedValue(String value) {
        usedValues.add(value);
    }

    public static void removeUsedValue(String value) {
        usedValues.remove(value);
    }

    public static void clearAll() {usedValues.clear();}
}
