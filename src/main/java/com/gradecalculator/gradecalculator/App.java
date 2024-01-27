package com.gradecalculator.gradecalculator;

import com.gradecalculator.gradecalculator.dao.EntityDao.UserDao;
import com.gradecalculator.gradecalculator.helper.enums.UserAuthority;
import com.gradecalculator.gradecalculator.helper.enums.UserStatus;
import com.gradecalculator.gradecalculator.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        UserDao userDao = new UserDao();
//        List<UserAuthority> authorities = new ArrayList<>();
//        authorities.add(UserAuthority.ADMIN);
//        User user = new User("Ngane", "emmanuel", "example@gmail.com","test123", UserStatus.ACTIVE, authorities);
//        userDao.add(user);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}