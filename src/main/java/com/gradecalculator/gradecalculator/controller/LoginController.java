package com.gradecalculator.gradecalculator.controller;


import com.gradecalculator.gradecalculator.App;
import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.loginService.LoginService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginBtn;

    @FXML
    private FontAwesomeIconView loginSpinner;

    @FXML
    private PasswordField password;

    @FXML
    private TextField password2;

    @FXML
    private TextField username;

    @FXML
    private Label warningMsg;

    private final LoginService loginService;

    public LoginController() {
        this.loginService = new LoginService();
    }

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @FXML
    void login(MouseEvent event) throws IOException {
        loginSpinner.setVisible(true); // show login spinner animation
        loginBtn.setDisable(true); // disable login button to avoid double request
        if (!username.getText().isBlank() &&
                !(password.isVisible() ? password.getText() : password2.getText()).isBlank() //check for which password field is visible at the time of submission
        ) { // check if the username and password fields are not empty
            User user = loginService.login(username.getText(), password.getText()); // get and authenticate user from database if exist
            if (user != null) { //check if user exist
                loginBtn.getScene().getWindow().hide(); //hide login window

                // allow user to access the dashboard of the app
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("UI/performance-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 950, 700);
                stage.setTitle("Student Grade Calculator");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                //todo also figure out the activities logging mechanism
            } else {
                warning("Invalid user credentials. Please try again!!"); // display warning message
            }
        } else {
            warning("All fields must be filled. Try again!!"); // display warning message
        }
    }

    private void warning(String message) {
        warningMsg.setText(message);
        warningMsg.setVisible(true);
        FadeTransition fadOutMsg = new FadeTransition(Duration.seconds(10), warningMsg);
        fadOutMsg.setFromValue(1);
        fadOutMsg.setToValue(0);
        fadOutMsg.setCycleCount(1);
        loginSpinner.setVisible(false);
        loginBtn.setDisable(false);
        fadOutMsg.play();
    }

    @FXML
    void showPassword(MouseEvent event) {
        if (password.isVisible()) { //check if the hidden password field is visible
            password2.setText(password.getText()); //set visible password field's text to hidden password field's text
            password2.setVisible(true); // show visible password field
            password.setVisible(false); // hide hidden password field
        } else {
            password.setText(password2.getText()); //set hidden password field's text to visible password field's text
            password.setVisible(true); // show hidden password field
            password2.setVisible(false); // hide visible password field
        }
    }

}