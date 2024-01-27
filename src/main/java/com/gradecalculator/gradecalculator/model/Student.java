package com.gradecalculator.gradecalculator.model;

import com.gradecalculator.gradecalculator.helper.enums.Grade;
import jakarta.persistence.*;

import java.util.List;

@SuppressWarnings("unused")
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String FirstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String LastName;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "student")
    private List<Performance> performances;
    private Grade grade; // overall grade of the student -- average of all performances

    public Student(String firstName, String middleName, String lastName) {
        FirstName = firstName;
        this.middleName = middleName;
        LastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", performances=" + performances +
                ", grade=" + grade +
                '}';
    }
}
