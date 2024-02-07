package com.gradecalculator.gradecalculator;

import com.gradecalculator.gradecalculator.dao.EntityDao.CourseDao;
import com.gradecalculator.gradecalculator.dao.EntityDao.PerformanceDao;
import com.gradecalculator.gradecalculator.dao.EntityDao.StudentDao;
import com.gradecalculator.gradecalculator.dao.EntityDao.UserDao;
import com.gradecalculator.gradecalculator.helper.enums.UserAuthority;
import com.gradecalculator.gradecalculator.helper.enums.UserStatus;
import com.gradecalculator.gradecalculator.model.Course;
import com.gradecalculator.gradecalculator.model.Performance;
import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.validationService.InputValidator;
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("UI/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 779, 520);
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}