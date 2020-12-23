package ru.geekbrains.javatwo.chat.server.chat.auth;

import ru.geekbrains.javatwo.chat.server.chat.User;

import java.util.Map;

public class BaseAuthService implements AuthService {

    private static final Map<User, String> USERS = Map.of(
            new User("login1", "pass1", "Alice"), "Alice",
            new User("login2", "pass2", "John"), "John",
            new User("login3", "pass3", "Boris"), "Boris"
    );

    @Override
    public void start() {
        System.out.println("Authentication service is running");
    }

    @Override
    public void stop() {
        System.out.println("Authentication service has been stopped");
    }

    @Override
    public String getNickByLoginPass(String login, String password) {
        User requestedUser = new User(login, password, null);
        return USERS.get(requestedUser);
    }
}
