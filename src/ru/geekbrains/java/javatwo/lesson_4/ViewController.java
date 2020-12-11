package ru.geekbrains.java.javatwo.lesson_4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML
    public ListView<String> usersList;
    @FXML
    public Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(Main.USERS));
    }

    @FXML
    private void sendMessage() {
        chatHistory.appendText(textField.getText());
        chatHistory.appendText(System.lineSeparator());
        textField.clear();
    }

}
