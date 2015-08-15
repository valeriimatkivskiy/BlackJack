package com.blackjack.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Валерій on 8/15/2015.
 */
public class Writer extends Thread {

    private String name;

    private Socket socket;

    private String text;

    public Writer(String name, Socket socket, String text) {
        this.name = name;
        this.socket = socket;
        this.text = text;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String message = name + ": " + text;
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

    }


}
