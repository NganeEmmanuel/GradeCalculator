package com.gradecalculator.gradecalculator.service.studentService;

import com.gradecalculator.gradecalculator.dao.EntityDao.StudentDao;
import com.gradecalculator.gradecalculator.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public void addStudent(Student student) {
        studentDao.add(student);
    }

    public List<Student> getStudentsQuery(String query) {
        List<Student> students = studentDao.runQuery(query, 0);
        return (students != null? students : new ArrayList<>());
    }

    public Student getStudentByID(Long id) {
        return studentDao.findById(id).orElse(null);
    }
}
