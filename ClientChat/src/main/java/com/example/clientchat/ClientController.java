package com.example.clientchat;

import javafx.beans.binding.MapExpression;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController {
    @FXML
    public TextField messageField;

    @FXML
    public Button sendMessageButton;

    @FXML
    public TextArea messageTextArea;

    @FXML
    public ListView userList;

    public void appendMessageToChat(ActionEvent actionEvent) {
        if (!messageField.getText().isEmpty()){
            messageTextArea.appendText(messageField.getText());
            messageTextArea.appendText(System.lineSeparator());
            messageField.clear();
        }
    }
}