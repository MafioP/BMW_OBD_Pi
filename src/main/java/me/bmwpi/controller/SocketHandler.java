package me.bmwpi.controller;

import me.bmwpi.model.PidModel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHandler implements Runnable{
    private final PidModel model;
    private final int PORT = 4000;
    private boolean stop;
    ServerSocket serverSocket = null;

    public SocketHandler(PidModel model) {
        this.model = model;
        stop = false;
    }

    @Override
    public void run() {
        System.out.println("Start socket");
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
            while (!serverSocket.isClosed()) {
                if (inputBufferedReader.ready()) {
                    in = inputBufferedReader.readLine();
                    parseData(in);
                    System.out.println("Message from client: " + in);
                }
            }
            outputBufferedWriter.write("exit");
            System.out.println("Exiting server");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void stopSocket() throws IOException {
        serverSocket.close();
    }

    public void parseData(String in) {
        String[] split = in.split(":");
        if (split.length > 1) {
            model.setPid(split[0], split[1]);
        }
    }
}
