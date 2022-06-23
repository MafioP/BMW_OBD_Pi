package me.bmwpi.controller;

public class ScriptHandler implements Runnable{
    Process process;

    @Override
    public void run() {
        try {
            ProcessBuilder pyProcess = new ProcessBuilder("python", "src/main/resources/me/bmwpi/BMW_e46_ECU_Interface.py");
            pyProcess.redirectErrorStream(true);
            pyProcess.inheritIO();
            process = pyProcess.start();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void stopScript() {
        try {
            process.destroy();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
