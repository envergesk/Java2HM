package com.company.GeekBrains.HomeWork6.Lesson6;

import com.company.GeekBrains.HomeWork6.EchoConstants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(EchoConstants.PORT)) {
            System.out.println("Server started, waiting for new connections");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            while (true){
                String message = inputStream.readUTF();
                if (message.startsWith(EchoConstants.STOP_WORD)){
                    break;
                }
                outputStream.writeUTF("Echo: " + message);
            }

        } catch (IOException ex) {
            System.err.println("Connection error on PORT number " + EchoConstants.PORT);
            ex.printStackTrace();
        }
    }
}
