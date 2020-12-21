package ru.geekbrains.javatwo.chat.server;

import ru.geekbrains.javatwo.chat.server.chat.MyServer;

import java.io.IOException;

public class ServerApp {

    public static final int DEFAULT_PORT = 8189;

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }
        try {
            new MyServer().start(port);
        } catch (IOException e) {
            System.err.println("Failed to create MyServer");
            e.printStackTrace();
        }
    }
}
