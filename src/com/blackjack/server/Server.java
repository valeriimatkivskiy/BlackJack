package com.blackjack.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Валерій on 8/15/2015.
 */
public class Server {

    private ServerSocket serverSocket;

    private ClientService clientService;

    public static List<Socket> activeSockets;

    public Server(int port) {
        activeSockets = new ArrayList<Socket>();
        clientService = null;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void start() {
        ClientService.count = 0;
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                activeSockets.add(socket);
                clientService = new ClientService(socket);
                clientService.start();
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5432);
        server.start();
    }


}
