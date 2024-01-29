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
//        UserDao userDao = new UserDao();
//        List<UserAuthority> authorities = new ArrayList<>();
//        authorities.add(UserAuthority.ADMIN);
//        User user = new User("Ngane", "emmanuel", "example@gmail.com","test123", UserStatus.ACTIVE, authorities);
//        userDao.add(user);
//        Course course = new Course("Java Programming 1", "ICT2143");
//        course.setCourseInstructor(userDao.findById(1L).orElse(null));
//        CourseDao courseDao = new CourseDao();
////        courseDao.add(course);
//        StudentDao studentDao = new StudentDao();
//        Performance performance = new Performance(studentDao.findById(1L).orElse(null), courseDao.findById(1L).orElse(null));
//        PerformanceDao performanceDao = new PerformanceDao();
//        performanceDao.add(performance);
        System.out.println(InputValidator.isDouble(""));
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