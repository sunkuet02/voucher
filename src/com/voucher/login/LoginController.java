package com.voucher.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utils.DBConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private void login(ActionEvent event) {
        Connection conn = DBConnection.getDBConnection();
        String retrivalSqlString = "select password from user where username='" + txtUsername.getText() + "'";
        try {
            ResultSet resultSet =  conn.createStatement().executeQuery(retrivalSqlString);
            if(resultSet.next()) {
                String password = resultSet.getString("password");
                if (!password.equals(txtPassword.getText())) {
                    JOptionPane.showMessageDialog(null, "Password incorrect");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the username : " + txtUsername.getText());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection Error");
        }

    }
}
