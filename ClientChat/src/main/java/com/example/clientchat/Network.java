package com.example.clientchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class Network {

    private static Network INSTANCE;
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;

    private String host;
    private int port;

    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    private Network(String host, int port) {
        this.port = port;
        this.host = host;
    }

    private Network() {
        this(SERVER_HOST, SERVER_PORT);
    }

    public static Network getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Network();
        }
        return INSTANCE;
    }

    public boolean connect() {
        try {
            socket = new Socket(host, port);
            socketInput = new DataInputStream(socket.getInputStream());
            socketOutput = new DataOutputStream(socket.getOutputStream());


            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            socketOutput.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Send message to server failed");
            e.printStackTrace();
            throw e;
        }
    }

    public void waitMessages(Consumer<String> messageHandler){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (Thread.currentThread().isInterrupted()){
                            return;
                        }
                        String message = socketInput.readUTF();
                        messageHandler.accept(message);
                    } catch (IOException e) {
                        System.err.println("Receive message from server failed");
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void close(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Socket close failed");
            e.printStackTrace();
        }
    }
}
