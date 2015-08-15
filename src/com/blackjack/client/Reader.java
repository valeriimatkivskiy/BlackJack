package com.blackjack.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Валерій on 8/15/2015.
 */
public class Reader extends Thread {

    private Socket socket;

    private String text;

    public Reader (Socket socket) {
        this.socket = socket;
    }

    public String getText() {
        return text;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream((socket.getInputStream()));
            this.text = dataInputStream.readUTF();
        }
        catch ( IOException exception) {
            exception.printStackTrace();
        }
    }
}
