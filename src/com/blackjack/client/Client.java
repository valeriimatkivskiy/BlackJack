package com.blackjack.client;


import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Валерій on 8/15/2015.
 */
public class Client {

    private String clienName;

    private int cash;

    private Socket socket;

    public Client() {
        connectToServer();
        socket = null;
        this.cash = 0;
    }

    public Client(String clienName) {
        this.clienName = clienName;
        socket = null;
        this.cash = 100;
    }

    public void lauchUser() {
        while (true) {
            try {
                socket = new Socket("localhost", 5432);

                Reader reader = new Reader(socket);
                reader.start();
                reader.join();
                System.out.println(reader.getText());
                socket.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public void sendMessage() {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        if (message != null) {
            try {
                Writer writer = new Writer(clienName, socket, message);
                writer.start();
                writer.join();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public void connectToServer() {
        System.out.println("Hello. What is your name?");
        Scanner scanner = new Scanner(System.in);
        this.clienName = scanner.nextLine();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.lauchUser();
    }


}
