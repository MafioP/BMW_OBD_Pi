package me.bmwpi.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;

public class Settings {
    private static int MODE = 0;
    private static double DELAY = 0.1;
    private static final int GAUGE_SIZE = 250;
    private static final ArrayList<String> usedValues = new ArrayList<>(Arrays.asList("rpm", "speed", "torque", "engLoad"));


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

    public static int getGaugeSize() {
        return GAUGE_SIZE;
    }

    public static ArrayList<String> getUsedValues() {
        return usedValues;
    }

    public static String getUsedvaluesAsString() {
        String val = "";
        for (String value : usedValues) {
            val += value + ",";
        }
        val = val.substring(0, val.length()-1);
        return val;
    }

    public static void addUsedValue(String value) {
        usedValues.add(value);
    }

    public static void removeUsedValue(String value) {
        usedValues.remove(value);
    }

    public static void clearAll() {usedValues.clear();}
}
