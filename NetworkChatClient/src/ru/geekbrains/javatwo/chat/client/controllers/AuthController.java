package ru.geekbrains.javatwo.chat.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.geekbrains.javatwo.chat.client.ClientChat;
import ru.geekbrains.javatwo.chat.client.models.Network;

import java.io.IOException;

public class AuthController {

    @FXML
    public TextField loginField;

    @FXML
    public PasswordField passwordField;

    private Network network;

    @FXML
    public void executeAuth(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();
        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            ClientChat.showNetworkError("Login and password are required!", "Validation", null);
            return;
        }

        try {
            network.sendAuthMessage(login, password);
        } catch (IOException e) {
            ClientChat.showNetworkError(e.getMessage(), "Authentication error!", null);
            e.printStackTrace();
        }
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
