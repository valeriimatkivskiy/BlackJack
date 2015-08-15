package com.blackjack.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientService extends Thread{

    private Socket socket;

    public static int count;

    public ClientService(Socket socket) {
        this.socket = socket;
    }

    private  synchronized void sendMessage(String str) {
        for (Socket socket : Server.activeSockets) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(str);
                dataOutputStream.flush();
                count++;
                System.out.println("Server send message " + count + " : " + str);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream((socket.getInputStream()));
            String str = dataInputStream.readUTF();
            sendMessage(str);
            count++;
            System.out.println("Server received message " + count + " : " + str);
            if (Server.activeSockets.contains(socket)) {
                Server.activeSockets.remove(socket);
            }

        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}