package me.bmwpi.controller;

import java.io.IOException;

import me.bmwpi.BMW_Pi_Main;
import me.bmwpi.model.PidModel;

/*TODO
        Run python script
        Handle connection to socket server
        Read data from socket
        Update pidList in model
        Read from pid list and display in various gauges
     */
public class LiveDataController {
    private final PidModel model;
    private final ScriptHandler scriptHandler;
    private final SocketHandler socketHandler;
    private final Thread socketThread;
    private final Thread scriptThread;

    public LiveDataController() throws IOException {
        System.out.println("Controller created");
        model = new PidModel();
        socketHandler = new SocketHandler(model);
        socketThread = new Thread(socketHandler);
        socketThread.start();
        scriptHandler = new ScriptHandler();
        scriptThread = new Thread(scriptHandler);
        scriptThread.start();

    }

    public void switchToMainPage() throws IOException {
        scriptHandler.stopScript();
        socketHandler.stopSocket();
        socketThread.interrupt();
        scriptThread.interrupt();
        BMW_Pi_Main.setRoot("mainpage");
    }
}