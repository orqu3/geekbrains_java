package ru.geekbrains.javatwo.chat.server.chat.handler;

import ru.geekbrains.javatwo.chat.server.chat.MyServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private static final String END_CMD = "/end";
    private static final String AUTH_CMD = "/auth";
    private static final String AUTH_OK_CMD = "/authok";
    private static final String PRIVATE_MESSAGE_CMD_PREFIX = "/w";
    private static final String CLIENT_MSG_CMD_PREFIX = "/clientMsg";

    private final MyServer myServer;
    private final Socket clientSocket;

    private DataInputStream in;
    private DataOutputStream out;

    private String nickname;

    public ClientHandler(MyServer myServer, Socket clientSocket) {
        this.myServer = myServer;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(() -> {
            try {
                authentication();
                readMessages();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    closeConnection();
                } catch (IOException e) {
                    System.err.println("Failed to close connection!");
                }
            }
        }).start();
    }

    private void authentication() throws IOException {
        while (true) {
            String message = in.readUTF();
            if (message.startsWith(AUTH_CMD)) {
                String[] parts = message.split(" ", 3);
                String login = parts[1];
                String password = parts[2];
                String nickname = myServer.getAuthService().getNickByLoginPass(login, password);
                if (nickname == null) {
                    out.writeUTF("Wrong login or password!");
                    continue;
                }

                if (myServer.isNickBusy(nickname)) {
                    out.writeUTF("This user already exists!");
                    continue;
                }

                out.writeUTF(String.format("%s %s", AUTH_OK_CMD, nickname));
                setNickname(nickname);
                myServer.broadcastMessage(String.format("User '%s' joined the chat!", nickname), null);
                myServer.subscribe(this);
                return;
            }
        }
    }

    private void readMessages() throws IOException {
        while (true) {
            String message = in.readUTF();
            System.out.println("message: " + message);
            if (message.startsWith(END_CMD)) {
                return;
            } else if (message.startsWith(PRIVATE_MESSAGE_CMD_PREFIX)) {
                String[] parts = message.split("\\s+", 3);
                String recipient = parts[1];
                String privateMessage = parts[2];
                myServer.sendPrivateMessage(this, recipient, privateMessage);
            } else {
                myServer.broadcastMessage(nickname + ": " + message, this);
            }
        }
    }

    private void closeConnection() throws IOException {
        myServer.unsubscribe(this);
        clientSocket.close();
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }

    public void sendMessage(String sender, String message) throws IOException {
        out.writeUTF(String.format("%s %s %s", CLIENT_MSG_CMD_PREFIX, sender, message));
    }

    public String getNickname() {
        return nickname;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
