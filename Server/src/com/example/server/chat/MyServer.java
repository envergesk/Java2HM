package com.example.server.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {

    private final List<ClientHandler> clients = new ArrayList<>();

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            while (true) {
                waitAndProcessClientConnection(serverSocket);
            }

        } catch (IOException ex) {
            System.err.println("Failed to bind port " + port);
        }
    }

    private void waitAndProcessClientConnection(ServerSocket serverSocket) throws IOException {

        System.out.println("Waiting for new client connection");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
        this.clients.add(clientHandler);

    }

    public void broadcastMessage(String message, ClientHandler sender) throws IOException {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

}
