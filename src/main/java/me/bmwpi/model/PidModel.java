package me.bmwpi.model;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PidModel {

    public void setPid(String key, String value) {
        switch (key) {
            case "coolTemp": Platform.runLater(() -> setCoolantTemp(Double.parseDouble(value)));
                break;
            case "rpm": Platform.runLater(() -> setRpm(Integer.parseInt(value)));
                break;
            case "oilTemp": Platform.runLater(() -> setOilTemp(Integer.parseInt(value)));
                break;
            case "boost": Platform.runLater(() -> setBoostPressure(Double.parseDouble(value)));
                break;
            case "airInTemp": Platform.runLater(() -> setAirInTemp(Integer.parseInt(value)));
                break;
            case "engLoad": Platform.runLater(() -> setEngineLoad(Double.parseDouble(value)));
                break;
            case "speed": Platform.runLater(() -> setSpeed(Integer.parseInt(value)));
                break;
            case "torque": Platform.runLater(() -> setTorque(Integer.parseInt(value)));
                break;

            default:
        }
    }

    // coolantTempProperty
    private final DoubleProperty coolantTempProperty = new SimpleDoubleProperty(this, "coolantTemp");
    public final DoubleProperty coolantTempProperty() {
       return coolantTempProperty;
    }
    public final double getCoolantTemp() {
       return coolantTempProperty.get();
    }
    public final void setCoolantTemp(double value) {
        coolantTempProperty.set(value);
    }

    // oilTempProperty
    private final IntegerProperty oilTempProperty = new SimpleIntegerProperty(this, "oilTemp");
    public final IntegerProperty oilTempProperty() {
       return oilTempProperty;
    }
    public final int getOilTemp() {
       return oilTempProperty.get();
    }
    public final void setOilTemp(int value) {
        oilTempProperty.set(value);
    }

    // rpmProperty
    private final IntegerProperty rpmProperty = new SimpleIntegerProperty(this, "rpm");
    public final IntegerProperty rpmProperty() {
       return rpmProperty;
    }
    public final int getRpm() {
       return rpmProperty.get();
    }
    public final void setRpm(int value) {
        rpmProperty.set(value);
    }

    // boostPressureProperty
    private final DoubleProperty boostPressureProperty = new SimpleDoubleProperty(this, "boostPressure");
    public final DoubleProperty boostPressureProperty() {
       return boostPressureProperty;
    }
    public final double getBoostPressure() {
       return boostPressureProperty.get();
    }
    public final void setBoostPressure(double value) {
        boostPressureProperty.set(value);
    }

    // airInTempProperty
    private final IntegerProperty airInTempProperty = new SimpleIntegerProperty(this, "airInTemp");
    public final IntegerProperty airInTempProperty() {
       return airInTempProperty;
    }
    public final int getAirInTemp() {
       return airInTempProperty.get();
    }
    public final void setAirInTemp(int value) {
        airInTempProperty.set(value);
    }

    // engineLoadProperty
    private final DoubleProperty engineLoadProperty = new SimpleDoubleProperty(this, "engineLoad");
    public final DoubleProperty engineLoadProperty() {
       return engineLoadProperty;
    }
    public final double getEngineLoad() {
       return engineLoadProperty.get();
    }
    public final void setEngineLoad(double value) {
        engineLoadProperty.set(value);
    }

    // speedProperty
    private final IntegerProperty speedProperty = new SimpleIntegerProperty(this, "speed");
    public final IntegerProperty speedProperty() {
       return speedProperty;
    }
    public final int getSpeed() {
       return speedProperty.get();
    }
    public final void setSpeed(int value) {
        speedProperty.set(value);
    }

    // torqueProperty
    private final IntegerProperty torqueProperty = new SimpleIntegerProperty(this, "torque");
    public final IntegerProperty torqueProperty() {
       return torqueProperty;
    }
    public final int getTorque() {
       return torqueProperty.get();
    }
    public final void setTorque(int value) {
        torqueProperty.set(value);
    }


}
