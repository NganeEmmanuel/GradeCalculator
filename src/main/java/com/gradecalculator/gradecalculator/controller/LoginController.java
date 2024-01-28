package com.gradecalculator.gradecalculator.controller;


import com.gradecalculator.gradecalculator.App;
import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.LoginService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button loginBtn;

    @FXML
    private FontAwesomeIconView loginSpinner;

    @FXML
    private PasswordField password;

    @FXML
    private TextField password2;

    @FXML
    private FontAwesomeIconView showPassword;

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
        loginSpinner.setVisible(true);
        loginBtn.setDisable(true);
        if (!username.getText().isBlank() &&
                !(password.isVisible() ? password.getText() : password2.getText()).isBlank()
        ) {
            User user = loginService.login(username.getText(), password.getText());
            if (user != null) {
                loginBtn.getScene().getWindow().hide();
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Account-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 779, 604);
                stage.setTitle("Bank Management System");
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.setResizable(true);
                stage.show();
                //todo also figure out the activities logging mechanism
            } else {
                warning("Invalid user credentials. Please try again!!");
            }
        } else {
            warning("All fields must be filled. Try again!!");
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
        if (password.isVisible()) {
            password2.setText(password.getText());
            password2.setVisible(true);
            password.setVisible(false);
        } else {
            password.setText(password2.getText());
            password.setVisible(true);
            password2.setVisible(false);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        loadSplashScreen();
    }

}