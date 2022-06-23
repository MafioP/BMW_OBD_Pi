package me.bmwpi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {
    private static final int PORT = 4000;
    public static void main(String [] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " is connected");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Waiting for client...");
        String in = "", out = "";
        while (!in.equals("Stop")) {
            in = bufferedReader.readLine();
            System.out.println("Message from client: " + in);
            /*out = bufferedReader.readLine();
            dataOut.writeUTF(out);
            dataOut.flush();*/
        }
    }
}
