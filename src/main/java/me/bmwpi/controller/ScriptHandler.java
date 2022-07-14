package me.bmwpi.controller;

import me.bmwpi.model.Settings;

public class ScriptHandler implements Runnable{
    Process process;

    @Override
    public void run() {
        try {
            ProcessBuilder pyProcess = new ProcessBuilder("python", "src/main/resources/me/bmwpi/BMW_e46_ECU_Interface.py",
                    String.valueOf(Settings.getDELAY()), String.valueOf(Settings.getMODE()));
            pyProcess.redirectErrorStream(true);
            pyProcess.inheritIO();
            process = pyProcess.start();
            long pid = process.pid();
            System.out.println("PID: " + pid + " on " + System.getProperty("os.name"));

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void stopScript() {

        try {
            long pid = process.pid();
            System.out.println("KILL PID: " + pid + " on " + System.getProperty("os.name"));
            //Runtime.getRuntime().exec("taskkill /f /PID " + pid);
            process.destroy();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
