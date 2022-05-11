package com.company.GeekBrains.HomeWork6;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientConsole {
    public static void main(String[] args) throws IOException {
        openConnection();
    }

    public static void openConnection() throws IOException {
        Socket socket = new Socket(EchoConstants.HOST, EchoConstants.PORT);
        DataInputStream inputClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputClient = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Введите сообщение для сервера");
                    outputClient.writeUTF(scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    String string = inputClient.readUTF();
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
    }
}
