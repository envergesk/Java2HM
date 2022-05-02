package com.company.GeekBrains.HomeWork6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(EchoConstants.PORT)){
            System.out.println("Server started");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream inputServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputServer = new DataOutputStream(socket.getOutputStream());
            Thread t1 = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Введите сообщение для клиента");
                        outputServer.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
            Thread t2 = new Thread(() -> {
                try {
                    while (true) {
                        String string = inputServer.readUTF();
                        if (string.equals(EchoConstants.STOP_WORD)){
                            break;
                        }
                        System.out.println(string);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t2.start();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
