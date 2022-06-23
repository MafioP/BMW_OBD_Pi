package me.bmwpi.controller;

import me.bmwpi.model.PidModel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHandler implements Runnable{
    private final PidModel model;
    private final int PORT = 4000;
    private boolean stop = false;

    public SocketHandler(PidModel model) {
        this.model = model;
        stop = false;
    }

    @Override
    public void run() {
        System.out.println("Start socket");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server created");
        try {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress() + " is connected");
            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter outputBufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("Waiting for client...");
            String in = "", out = "";
            while (!stop) {
                in = inputBufferedReader.readLine();
                System.out.println("Message from client: " + in);
            }
            System.out.println("Exiting server");
            outputBufferedWriter.write(-1);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void stopSocket() {
        stop = true;
    }
}
