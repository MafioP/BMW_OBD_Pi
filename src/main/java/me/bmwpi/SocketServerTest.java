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
        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String in = "", out = "";
        while (!in.equals("Stop")) {
            in = dataIn.readUTF();
            System.out.println("Message from client: " + in);
            out = bufferedReader.readLine();
            dataOut.writeUTF(out);
            dataOut.flush();
        }
    }
}
