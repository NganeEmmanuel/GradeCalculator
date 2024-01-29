package com.gradecalculator.gradecalculator.controller;

import com.gradecalculator.gradecalculator.model.Course;
import com.gradecalculator.gradecalculator.model.Performance;
import com.gradecalculator.gradecalculator.model.Student;
import com.gradecalculator.gradecalculator.service.GradeCalculatorService.GradeCalculatorService;
import com.gradecalculator.gradecalculator.service.courseService.CourseService;
import com.gradecalculator.gradecalculator.service.performanceService.PerformanceService;
import com.gradecalculator.gradecalculator.service.studentService.StudentService;
import com.gradecalculator.gradecalculator.service.validationService.InputValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PerformanceController implements Initializable {

    @FXML
    private TableColumn<Student, Double> GPAColumn;

    @FXML
    private Label addGradeErrorMessage;

    @FXML
    private TableColumn<Student, String> addGradeFirstNameColumn;

    @FXML
    private TableColumn<Student, Double> addGradeGPAColumn;

    @FXML
    private TableColumn<Student, Long> addGradeIdColumn;

    @FXML
    private TableColumn<Student, String> addGradeLastNameColumn;

    @FXML
    private TableColumn<Student, String> addGradeMiddleNameColumn;

    @FXML
    private TableView<Student> addGradeTableView;

    @FXML
    private Label addStudentErrorMessage;

    @FXML
    private TextField assignmentScoreInput;

    @FXML
    private TableColumn<Performance, Double> assignmentsColumn;

    @FXML
    private TableColumn<Performance, Double> attendanceColumn;

    @FXML
    private TextField attendanceScoreInput;

    @FXML
    private TableColumn<Performance, Double> caColumn;

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
    private TableColumn<Performance, Course> courseCodeColumn;

    @FXML
    private TableColumn<Performance, Course> courseNameColumn;

    @FXML
    private ComboBox<Course> courseSelectorInput;

    @FXML
    private TableColumn<Performance, Double> examColumn;

    @FXML
    private TextField examScoreInput;

    @FXML
    private TextField firstNameInput;

    @FXML
    private TableColumn<Performance, String> gradeColumn;

    @FXML
    private TableColumn<Student, Long> id;

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
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Performance, Double> participationColumn;

    @FXML
    private TextField participationScoreInput;

    @FXML
    private TableView<Performance> performanceTableView;

    @FXML
    private TableColumn<Performance, Double> projectColumn;

    @FXML
    private TextField projectScoreInput;

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private Label viewFirstNameLabel;

    @FXML
    private Label viewLastNameLabel;

    @FXML
    private Label viewMiddleNameLabel;

    @FXML
    private Button addGradeBtn;

    private ObservableList<Student> studentsData = FXCollections.observableArrayList();;
    private ObservableList<Performance> performancesData = FXCollections.observableArrayList();;

    @FXML
    void CalculateAverage(MouseEvent event) {

    }

    @FXML
    void ShowStudentDetails(MouseEvent event) {
        Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
           viewFirstNameLabel.setText(selectedStudent.getFirstName());
           viewLastNameLabel.setText(selectedStudent.getLastName());
           viewMiddleNameLabel.setText(selectedStudent.getMiddleName());

           //fill the performance table wth the selected student's performance if student performance is not empty
           if(!selectedStudent.getPerformances().isEmpty()){
               performanceTableView.getColumns().clear();
                // map the columns with the database data table columns
                courseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
                courseCodeColumn.setCellFactory(column -> new TableCell<>(){
                    @Override
                    protected void updateItem(Course course, boolean empty){
                        super.updateItem(course, empty);
                        if(course == null || empty){
                            setText(null);
                        }else {
                            setText(course.getCourseCode());
                        }
                    }
                });
                courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
               courseNameColumn.setCellFactory(column -> new TableCell<>(){
                   @Override
                   protected void updateItem(Course course, boolean empty){
                       super.updateItem(course, empty);
                       if(course == null || empty){
                           setText(null);
                       }else {
                           setText(course.getCourseName());
                       }
                   }
               });

                assignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("homeWorkScore"));
                caColumn.setCellValueFactory(new PropertyValueFactory<>("caScore"));
                projectColumn.setCellValueFactory(new PropertyValueFactory<>("projectScore"));
                examColumn.setCellValueFactory(new PropertyValueFactory<>("examScore"));
                attendanceColumn.setCellValueFactory(new PropertyValueFactory<>("attendanceScore"));
                participationColumn.setCellValueFactory(new PropertyValueFactory<>("participationScore"));
                gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

                // add all columns to table

                performanceTableView.getColumns().addAll(courseCodeColumn, courseNameColumn, assignmentsColumn, caColumn, projectColumn, examColumn, attendanceColumn, participationColumn, gradeColumn);

                //add performance data to table
                performancesData.addAll(selectedStudent.getPerformances());
                performanceTableView.setItems(performancesData);
            }
        }
    }

    private final PerformanceService performanceService =  new PerformanceService();
    private final GradeCalculatorService gradeCalculatorService = new GradeCalculatorService();
    @FXML
    void addGrade(MouseEvent event) {
        Student selectedStudent = addGradeTableView.getSelectionModel().getSelectedItem(); //get selected student
        if (selectedStudent != null && courseSelectorInput.getSelectionModel().getSelectedItem() != null) { //make sure course is selected too
            Course course = courseSelectorInput.getSelectionModel().getSelectedItem();
            Performance performance = new Performance(selectedStudent, course);

            String assignmentScore = assignmentScoreInput.getText();
            String caScore = caScoreInput.getText();
            String projectScore = projectScoreInput.getText();
            String examScore = examScoreInput.getText();
            String attendanceScore = attendanceScoreInput.getText();
            String participationScore = participationScoreInput.getText();

            // check if inputs are numbers and can be converted to double
            if(InputValidator.isDouble(assignmentScore) && InputValidator.isDouble(caScore) &&
                    InputValidator.isDouble(projectScore) && InputValidator.isDouble(examScore) &&
                    InputValidator.isDouble(attendanceScore) && InputValidator.isDouble(participationScore)
            ){
                // fill the score for each assessment type
                performance.setHomeWorkScore(Double.parseDouble(assignmentScore));
                performance.setCaScore(Double.parseDouble(caScore));
                performance.setProjectScore(Double.parseDouble(projectScore));
                performance.setExamScore(Double.parseDouble(examScore));
                performance.setAttendanceScore(Double.parseDouble(attendanceScore));
                performance.setParticipationScore(Double.parseDouble(participationScore));
                performance.setGrade(gradeCalculatorService.calculateGrade(
                        performance.getHomeWorkScore(), performance.getCaScore(),
                        performance.getProjectScore(), performance.getExamScore(),
                        performance.getAttendanceScore(), performance.getParticipationScore()
                ));

                performanceService.addPerformance(performance); //add performance to database
                if(performance.getId() != null){
                    //clear form and display a success message
                    assignmentScoreInput.setText("0");
                    caScoreInput.setText("0");
                    projectScoreInput.setText("0");
                    examScoreInput.setText("0");
                    attendanceScoreInput.setText("0");
                    participationScoreInput.setText("0");

                    addGradeErrorMessage.setText("Grade added successfully");
                    //todo make the error and success message animated to setTimeOut
                }
            }else{
                addGradeErrorMessage.setText("Please fill in proper scores");
            }
        }else{
            addGradeErrorMessage.setText("Please select a student and the course to proceed");
        }
    }

    @FXML
    void addInstructor(MouseEvent event) {

    }

    @FXML
    void addStudent(MouseEvent event) {
        if(!firstNameInput.getText().isBlank() && !middleNameInput.getText().isBlank() && !middleNameInput.getText().isBlank()){
            Student student = new Student(firstNameInput.getText(), middleNameInput.getText(), lastNameInput.getText());
            studentService.addStudent(student);
            if(student.getId() != null){
                addStudentErrorMessage.setText("Student Added Successfully");
                studentTableView.getItems().add(student);
                addGradeTableView.getItems().add(student);
            }
        }else{
            // todo display error message. animate it to setTimeOut
        }
    }

    @FXML
    void generateReport(MouseEvent event) {

    }

    @FXML
    void searchStudent(MouseEvent event) {

    }

    @Override
    //prepopulate the student table on dashboard load
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshStudentTable();
        refreshGradeStudentTable();
    }

    private final CourseService courseService = new CourseService();
    private final StudentService studentService = new StudentService();

    @FXML
    void enableAddGrade(MouseEvent event) {
        addGradeBtn.setDisable(false);
    }

    private void refreshStudentTable(){
        // map the columns with the database data table columns
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.GPAColumn.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        //add columns to tableView
        this.studentTableView.getColumns().clear();
        this.studentTableView.getColumns().addAll(id, firstNameColumn, lastNameColumn, GPAColumn);

        List<Student> students = this.studentService.getAllStudents();
        if(students != null) {
            //add student data to table
            studentsData.addAll(students);
            this.studentTableView.setItems(studentsData);
        }
    }

    private ObservableList<Student> GradeStudentsData = FXCollections.observableArrayList();
    private void refreshGradeStudentTable(){
        // map the columns with the database data table columns
        this.addGradeIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.addGradeFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.addGradeMiddleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        this.addGradeLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.addGradeGPAColumn.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        //add columns to tableView
        this.addGradeTableView.getColumns().clear();
        this.addGradeTableView.getColumns().addAll(addGradeIdColumn, addGradeFirstNameColumn, addGradeMiddleNameColumn, addGradeLastNameColumn, addGradeGPAColumn);

//        tableView.setItems(studentsData); // Already initialize studentDat on launch of app so can just add
        List<Student> students = this.studentService.getAllStudents();
        if(students != null) {
            //add student data to table
            GradeStudentsData.addAll(students);
            this.addGradeTableView.setItems(GradeStudentsData);
        }
        courseSelectorInput.setConverter(new StringConverter<Course>() {
            @Override
            public String toString(Course course) {
                return course == null? null : course.getCourseCode() + "  " + course.getCourseName();
            }

            @Override
            public Course fromString(String s) {
                return null;
            }
        });

        courseSelectorInput.setCellFactory(param -> new ListCell<Course>(){
            @Override
            protected void updateItem(Course item, boolean empty){
                super.updateItem(item, empty);
                if(item == null || empty){
                    setText(null);
                }else{
                    setText(item.getCourseCode() + " " + item.getCourseName());
                }
            }
        });
        courseSelectorInput.getItems().addAll(courseService.getAllCourses());

        //clear form and display a success message
        assignmentScoreInput.setText("0");
        caScoreInput.setText("0");
        projectScoreInput.setText("0");
        examScoreInput.setText("0");
        attendanceScoreInput.setText("0");
        participationScoreInput.setText("0");

    }
}
