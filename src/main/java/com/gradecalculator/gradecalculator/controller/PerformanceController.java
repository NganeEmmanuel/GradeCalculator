package com.gradecalculator.gradecalculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PerformanceController {

    @FXML
    private TableColumn<?, ?> GPAColumn;

    @FXML
    private Label addGradeErrorMessage;

    @FXML
    private TableColumn<?, ?> addGradeFirstNameColumn;

    @FXML
    private TableColumn<?, ?> addGradeGPAColumn;

    @FXML
    private TableColumn<?, ?> addGradeIdColumn;

    @FXML
    private TableColumn<?, ?> addGradeLastNameColumn;

    @FXML
    private TableColumn<?, ?> addGradeMiddleNameColumn;

    @FXML
    private TableView<?> addGradeTableView;

    @FXML
    private Label addStudentErrorMessage;

    @FXML
    private TextField assignmentScoreInput;

    @FXML
    private TableColumn<?, ?> assignmentsColumn;

    @FXML
    private TableColumn<?, ?> attendanceColumn;

    @FXML
    private TextField attendanceScoreInput;

    @FXML
    private TableColumn<?, ?> caColumn;

    @FXML
    private TextField caScoreInput;

    @FXML
    private TextField calcAssignmentScoreInput;

    @FXML
    private TextField calcAttendanceScoreInput;

    @FXML
    private TextField calcCAScoreInput;

    @FXML
    private TextField calcExamScoreInput;

    @FXML
    private Label calcGradeErrorMessage;

    @FXML
    private TextField calcParticipationScoreInput;

    @FXML
    private TextField calcProjectScoreInput;

    @FXML
    private TableColumn<?, ?> courseCodeColumn;

    @FXML
    private TableColumn<?, ?> courseNameColumn;

    @FXML
    private ComboBox<?> courseSelectorInput;

    @FXML
    private TableColumn<?, ?> examColumn;

    @FXML
    private TextField examScoreInput;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TableColumn<?, ?> gradeColumn;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TextField instructorEmailInput;

    @FXML
    private Label instructorErrorMessage;

    @FXML
    private TextField instructorNameInput;

    @FXML
    private TextField instructorPasswordInput;

    @FXML
    private TextField instructorUsernameInput;

    @FXML
    private TextField lastNameInput;

    @FXML
    private TextField middleNameInput;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> participationColumn;

    @FXML
    private TextField participationScoreInput;

    @FXML
    private TableView<?> performanceTableView;

    @FXML
    private TableColumn<?, ?> projectColumn;

    @FXML
    private TextField projectScoreInput;

    @FXML
    private TableView<?> studentTableView;

    @FXML
    private Label viewFirstNameLabel;

    @FXML
    private Label viewLastNameLabel;

    @FXML
    private Label viewMiddleNameLabel;

    @FXML
    void CalculateAverage(MouseEvent event) {

    }

    @FXML
    void ShowTransactionDetails(MouseEvent event) {

    }

    @FXML
    void addGrade(MouseEvent event) {

    }

    @FXML
    void addInstructor(MouseEvent event) {

    }

    @FXML
    void addStudent(MouseEvent event) {

    }

    @FXML
    void generateReport(MouseEvent event) {

    }

    @FXML
    void searchStudent(MouseEvent event) {

    }

}
