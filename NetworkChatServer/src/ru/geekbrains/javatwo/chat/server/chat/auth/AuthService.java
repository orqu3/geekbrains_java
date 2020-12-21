package ru.geekbrains.javatwo.chat.server.chat.auth;

public interface AuthService {

    void start();

    void stop();

    String getNickByLoginPass(String login, String password);
}
