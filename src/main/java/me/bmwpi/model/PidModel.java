package me.bmwpi.model;

import java.util.HashMap;

public class PidModel {
    private HashMap<String, String> pidMap;

    public PidModel() {
        pidMap = new HashMap<>();
    }

    public void setPid(String key, String value) {
        pidMap.put(key, value);
    }

    public String getPid(String key) {
        return pidMap.get(key);
    }
}
